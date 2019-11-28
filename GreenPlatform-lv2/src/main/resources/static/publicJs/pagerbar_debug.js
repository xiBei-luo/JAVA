function PagerBar(jsonData){
	var _default = 11;

	var scale_bgColor = "#ebf9ff"; //页码容器背景颜色
	var scale_borderColor = "#c2e8f8";//页码容器边框颜色

	var text_color = "#00aaee"; //页码容器中文字颜色和当前选中的页码容器背景色
	var text_clickedColor = "#ffffff"; //选中页码容器中的文本颜色

	//var scale_selectedColor = "white";
	//var input_bgColor = "white";
	
	var scale_len = 29;  //页码容器的边长
	var currentPage = 1; //当前页码
	var currentScaleIndex = 1;//当前页码容器的索引
	var pageSize = 12; //设置共有多少页码的参数， 必须设置
	var show_scale_size = _default; //设置有多少个页码容器（也就是装页码的小方框）
	var user_scale_size = _default; //用户定义的页块，取奇数值

    var pageListSize = -1; //每页列表显示记录数

	var totalCount = null;//总记录数
	var clickEvent = null;//点击页码事件处理函数
	var pageListSizeEvent = null; //输入每页显示的记录数后回调函数
	var renderTo = null; //将空间渲染到某个容器中，必须设置
	
	var flag = true;
	//获取配置数据
	if(jsonData.scaleLen != undefined) {
		scale_len = jsonData.scaleLen;
	}
	if(jsonData.scaleBgColor != undefined) {
		scale_bgColor = jsonData.scaleBgColor;
	}
	if(jsonData.scaleBorderColor != undefined) {
		scale_borderColor = jsonData.scaleBorderColor;
	}
	/*if(jsonData.scaleSelectedColor != undefined) {
		scale_selectedColor = jsonData.scaleSelectedColor
	}
	if(jsonData.inputBgColor != undefined) {
		input_bgColor = jsonData.inputBgColor
	}*/
	if(jsonData.currentPage != undefined) {
		currentPage = jsonData.currentPage;
	}
	if(jsonData.showScaleSize != undefined) {
		user_scale_size = jsonData.showScaleSize;
		if(user_scale_size%2 == 0) user_scale_size += 1;
		
		if(jsonData.showScaleSize > _default)
			show_scale_size = jsonData.showScaleSize;
	}
	if(jsonData.textColor != undefined) {
		text_color = jsonData.textColor;
	}
	if(jsonData.textClickedColor != undefined) {
		text_clickedColor = jsonData.textClickedColor;
	}
	if(jsonData.clickEvent != undefined) {
		clickEvent = jsonData.clickEvent;
	}
	if(jsonData.pageSize != undefined) {
		pageSize = jsonData.pageSize;
	}else {
		alert("必须设置总共有好多页pageSize属性！！！");
		return null;
	}
	
	if(jsonData.pageListSize && jsonData.pageListSize > 0){
		pageListSize = jsonData.pageListSize;
	}
	
	if(jsonData.pageListSizeEvent){
		pageListSizeEvent = jsonData.pageListSizeEvent;
	}
	
	if(jsonData.renderTo != undefined) {
		renderTo = jsonData.renderTo;
	}else {
		alert("必须指定目标容器，以便将分页控件渲染到其中！！！");
		return null;
	}
	
	var control = null; //控件句柄
	var controlList = []; //页码容器集合
	var textInput = null; //页码输入框句柄
	var pageListSizeInput = null; //每页显示记录数输入框句柄
	var totalHandler = null; //总记录数句柄
    var listSizeHandler = null; //每页显示记录数句柄

	//设置点击页码事件处理函数
	this.setClickEvent = function(ev) {
		clickEvent = ev;
	};

	/**
	 * 取当前页
	 */
	this.getCurrentPage = function() {
		return currentPage;
	}

	/**
	 * 取每页列表显示记录条数
	 */
    this.getPageListSize = function(){
    	return pageListSize;
    }
    
	/**
	 * 设置总记录数
	 */
	this.setTotalCount = function(total){
		totalCount = total;
		if(totalCount && totalCount > 0 && totalHandler){
			var totalNodes = totalHandler.getElementsByTagName("span");
			if(totalNodes && totalNodes.length > 0){
				totalNodes[0].innerText = totalCount;
				totalHandler.style.display = "";
			}
		}		
	}

	/**
	 * 设置每页列表显示记录条数
	 */
    this.setPageListSize = function(listSize){
    	pageListSize = listSize;
    }

	//设置当前页码大小
	this.setPageSize = function(sz) {
		
		if(sz <= user_scale_size) {//显示全部页
			control.parentNode.removeChild(control);
			control = null; //控件的根节点容器设置为空
			controlList = [];//页码容器集合重新开辟一个新的空间
			textInput = null; //文本输入框设置为空
			show_scale_size = sz;
			currentPage = 1; //当前页码
			currentScaleIndex = 1;//当前页码容器的索引
			pageSize = sz; //设置共有多少页码的参数， 必须设置
			
			this.creatControl();
			this.initPageData();
		}else if(sz > user_scale_size && user_scale_size < _default) {//显示定义页数
			control.parentNode.removeChild(control);
			control = null; //控件的根节点容器设置为空
			controlList = [];//页码容器集合重新开辟一个新的空间
			textInput = null; //文本输入框设置为空
			show_scale_size = user_scale_size;
			currentPage = 1; //当前页码
			currentScaleIndex = 1;//当前页码容器的索引
			pageSize = sz; //设置共有多少页码的参数， 必须设置
			
			this.creatControl();
			this.initPageData();
		}else {
			refreshPage(sz);
		}
		
		if(listSizeHandler){//每页列表显示记录数
			listSizeHandler.style.display = "";
		}
		//if(clickEvent != null) 
		//	clickEvent(1);
	};
	
	//设置当前选中第几页
	this.setChangePage = function(page) {
		textInput.value = page;
		goToPage(page);
	};
	
	//当pageSize变动之后刷新页码容器
	var refreshPage = function(sz) {
		backStyle(currentScaleIndex);

		var count = sz;
		var centerIndex = Math.ceil(show_scale_size/2);
		if(sz < pageSize) {
			if(sz - currentPage > 0 && sz - currentPage < show_scale_size) {
				for(var i = show_scale_size ; i >= 1 ; i--) {
					if(currentPage == count) {
						setStyle(i);
						currentScaleIndex = i;
					}
					controlList[i].innerHTML = count;
					count--;
				}
				if(clickEvent != null) 
					clickEvent(currentPage);
			}else if(sz < currentPage) {
				for(var i = 1 ; i < centerIndex ; i++) {
					controlList[i].innerHTML = i;
				}
				controlList[centerIndex].innerHTML = "...";
				for (var i = show_scale_size ; i > centerIndex ; i--)
				{
					controlList[i].innerHTML = count;
					count--;
				}
				setStyle(1);
				currentScaleIndex = 1;	
				currentPage = 1;
				//if(clickEvent != null) 
					//clickEvent(currentPage);
			}else {
				for(var i = show_scale_size ; i > centerIndex ; i--) {
					controlList[i].innerHTML = count;
					count--;
				}
				setStyle(currentScaleIndex);
				//if(clickEvent != null) 
					//clickEvent(currentPage);
			}
		}else {
			/*if(sz-currentPage < show_scale_size-centerIndex) {
				for(var i = show_scale_size ; i > centerIndex ; i--) {
					
					if(count == currentPage) {
						setStyle(i);
						currentScaleIndex = i;
					}
					controlList[i].innerHTML = count;
					count--;
				}
				
			}
			else {
				for(var i = show_scale_size ; i > centerIndex ; i--) {
					controlList[i].innerHTML = count;
					count--;
				}
				setStyle(currentScaleIndex);
			}*/
			for(var i = 1 ; i < centerIndex ; i++) {
				controlList[i].innerHTML = i;
			}
			controlList[centerIndex].innerHTML = "...";
			for (var i = show_scale_size ; i > centerIndex ; i--)
			{
				controlList[i].innerHTML = count;
				count--;
			}
			setStyle(1);
			currentScaleIndex = 1;	
			currentPage = 1;
			//if(clickEvent != null) 
				//clickEvent(currentPage);
		}
		
		pageSize = sz;
	};
	
	//给页码容器填充数据的方法
	var fillPageNumber = function() {
		
	};

	//创建控件的框架
	this.creatControl = function(){
		var boxWidth = (scale_len+2) * (show_scale_size+2) +((show_scale_size+2)-1)*5+30+(12+(scale_len-12)/3)*2+scale_len+45+10-5;
		var boxHeight = scale_len;
		control = document.createElement("div");
		control.style.cssText = "border:0px dashed red;width:auto;height:"+(boxHeight+2)+"px !important; height:"+boxHeight+"px;";
		renderTo.appendChild(control);
		if(show_scale_size >= pageSize){
			show_scale_size = pageSize;
			flag = true;
		}
		else {
			flag = false;
		}
		for (var i = 0 ; i <  show_scale_size+2 ; i++)
		{
			var tempDiv = document.createElement("div");
			tempDiv.index = i;
			tempDiv.style.cssText = "border:1px solid "+scale_borderColor+";width:"+scale_len+"px;height:"+scale_len+"px;float:left;margin-left:5px;text-align:center;vertical-align:middle;line-height:"+scale_len+"px;font-size:12px;color:"+text_color+";background-color:"+scale_bgColor+";cursor: pointer;";
			tempDiv.innerHTML = i;
			controlList.push(tempDiv);
			control.appendChild(tempDiv);
		}
		controlList[0].style.marginLeft = 0;
		controlList[0].innerHTML ="◀";
		controlList[controlList.length-1].innerHTML = "▶";
		
		setStyle(currentScaleIndex);

		var lable = document.createElement("div");
		lable.style.cssText = "border:0px dashed black;margin-left:15px;height:"+scale_len+"px;width:"+((12+(scale_len-12)/3)*2)+"px;float:left;font-size:"+(12+(scale_len-12)/8)+"px;text-align:center;vertical-align:middle;line-height:"+scale_len+"px;";
		lable.innerHTML = "跳至";
		control.appendChild(lable);

		var textFeild = document.createElement("div");
		textFeild.style.cssText = "border:1px solid "+scale_borderColor+";margin-left:15px;width:45px;height:"+(scale_len)+"px;float:left;text-align:left;";
		control.appendChild(textFeild),
		textFeild.innerHTML = "<input type='text' value='' style='border:0px;color:"+text_color+";margin-left:0px !important; margin-left:-15px;width:100%;height:"+(scale_len-2)+"px;border:0px;font-size:12px;vertical-align:middle;line-height:"+(scale_len-2)+"px;'>";
		
		var isIE = !!window.ActiveXObject,
			isIE6 = isIE && !window.XMLHttpRequest,
			_scale_width = scale_len;
		if(isIE6) {_scale_width += 2;}
		var button = document.createElement("div");
		button.style.cssText = "border:1px solid "+scale_borderColor+";border-left:0px;background-color:"+scale_bgColor+";width:"+scale_len+"px;height:"+_scale_width+"px;float:left;line-height:"+scale_len+"px;vertical-align:middle;text-align:center;font-size:12px;font-weight:bold;color:"+text_color+";cursor: pointer;";
		button.innerHTML = "GO";
		control.appendChild(button);
        
        //======list size begin======
        if(pageListSize && pageListSize > 0){
        	var listSizeDiv = document.createElement("div");
        	listSizeDiv.style.cssText = "display: none;";
        	listSizeHandler = listSizeDiv;
        	
	        var listSizeBegin = document.createElement("div");
			listSizeBegin.style.cssText = "margin-left:10px;border-left:0px;height:"+_scale_width+"px;float:left;line-height:"+scale_len+"px;vertical-align:middle;text-align:center;";
	        listSizeBegin.innerHTML = "<div style=\"font-size:"+(12+(scale_len-12)/8)+"px;\">每页</div>";
	        listSizeDiv.appendChild(listSizeBegin);
	        
	        var listSizeInputDiv = document.createElement("div");
			listSizeInputDiv.style.cssText = "border:1px solid "+scale_borderColor+";margin-left:15px;width:40px;height:"+(scale_len)+"px;float:left;text-align:left;";
			listSizeDiv.appendChild(listSizeInputDiv),
			listSizeInputDiv.innerHTML = "<input type='text' maxlength='3' value='"+pageListSize+"' style='border:0px;color:"+text_color+";margin-left:0px !important; margin-left:-15px;width:100%;height:"+(scale_len-2)+"px;border:0px;font-size:12px;text-align:center;vertical-align:middle;line-height:"+(scale_len-2)+"px;'>";
	       	       
	        var listSizeEnd = document.createElement("div");
			listSizeEnd.style.cssText = "margin-left:10px;border-left:0px;height:"+_scale_width+"px;float:left;line-height:"+scale_len+"px;vertical-align:middle;text-align:center;";
	        listSizeEnd.innerHTML = "<div style=\"font-size:"+(12+(scale_len-12)/8)+"px;\">条</div>";
	        listSizeDiv.appendChild(listSizeEnd);
	        
	        control.appendChild(listSizeDiv);
	        pageListSizeInput = listSizeInputDiv.childNodes.item(0);
			pageListSizeInput.attachEvent && pageListSizeInput.attachEvent("onkeypress", this.keydownListSizeFeild) ;
			pageListSizeInput.addEventListener && pageListSizeInput.addEventListener("keypress", this.keydownListSizeFeild,false);
			pageListSizeInput.attachEvent && pageListSizeInput.attachEvent("onblur", this.blurListSizeFeild) ;
			pageListSizeInput.addEventListener && pageListSizeInput.addEventListener("blur", this.blurListSizeFeild,false);				        
        }
        //======list size end======

		var totalDiv = document.createElement("div");
		totalHandler = totalDiv;
		totalDiv.style.cssText = "display:none;margin-left:10px;height:"+scale_len+"px;width:"+((20+(scale_len-12)/3)*2)+"px;float:left;font-size:"+(12+(scale_len-12)/8)+"px;text-align:center;vertical-align:middle;line-height:"+scale_len+"px;";		
		totalDiv.innerHTML = "共&nbsp;<span style=\"font-size:12px;color:"+text_color+"\">0</span>&nbsp;条";
		control.appendChild(totalDiv);
        
		//var textInput = textFeild.childNodes.item(0);
		textInput = textFeild.childNodes.item(0);
		textInput.attachEvent && textInput.attachEvent("onkeypress", this.keydownTextFeild) ;
		textInput.addEventListener && textInput.addEventListener("keypress", this.keydownTextFeild,false);
		
		
		button.attachEvent && button.attachEvent("onclick", goToPage) ;
		button.addEventListener && button.addEventListener("click", goToPage,false);
		
	};
	
	//设置当前选中页码样式的方法
	var setStyle = function(index) {
		controlList[index].style.backgroundColor = text_color;
		controlList[index].style.borderColor = text_color;
		controlList[index].style.color = text_clickedColor;
	};
	//撤销上一次被选中页码的颜色
	var backStyle = function(index) {
		controlList[index].style.backgroundColor = scale_bgColor;
		controlList[index].style.borderColor = scale_borderColor;
		controlList[index].style.color = text_color;
	};
	var keyCodeToNumber = function(keyCode) {
		return keyCode - 48 ;
	};
	
	/**
	 * 每页显示记录数键盘按下事件处理函数
	 */
	this.keydownListSizeFeild = function(event) {
		var key = window.event ? event.keyCode : event.which;
		if(key == 8) {
			/*if(parseInt(textInput.value) <= 1) {
				event.returnValue = false;
				event.preventDefault && event.preventDefault();
			}*/
		}else if(key >= 48 && key <= 57) {
			if(parseInt(pageListSizeInput.value) < 1) {
				event.returnValue = false;
				event.preventDefault && event.preventDefault();
			}
		}else if(key == 13) {
			if(pageListSizeInput.value == "" || pageListSizeInput.value == undefined) {
				return ;
			}
			pageListSize = parseInt(pageListSizeInput.value?pageListSizeInput.value:'0');
			if(pageListSize < 1){
				pageListSize = 1;
				pageListSizeInput.value = pageListSize;
			}
			if(pageListSizeEvent) pageListSizeEvent();	
		}else {
			event.returnValue=false;
			event.preventDefault && event.preventDefault();
		}
	}
	
	/**
	 * 每页显示记录数输入框失去焦点事件
	 */
	this.blurListSizeFeild = function(event) {
		pageListSize = parseInt(pageListSizeInput.value?pageListSizeInput.value:'0');
		if(pageListSize < 1) {
			pageListSize = 1;
			pageListSizeInput.value = pageListSize;
		}
	}
	
	//文本框键盘按下事件处理函数
	this.keydownTextFeild = function(event) {
		var key = window.event ? event.keyCode : event.which;
		if(key == 8) {
			/*if(parseInt(textInput.value) <= 1) {
				event.returnValue = false;
				event.preventDefault && event.preventDefault();
			}*/
		}else if(key >= 48 && key <= 57) {
			if(parseInt(textInput.value+keyCodeToNumber(key)) > pageSize) {
				event.returnValue = false;
				event.preventDefault && event.preventDefault();
			}
		}else if(key == 13) {
			if(textInput.value == "" || textInput.value == undefined) {
				return ;
			}
			goToPage();
		}else {
			event.returnValue=false;
			event.preventDefault && event.preventDefault();
		}
	};

	var goToPage = function(pg) {
		var page;
		if(pg == undefined || typeof pg == "object") {
			page = parseFloat(textInput.value);
		}else {
			page = pg;
		}
		
		if(page > pageSize || page < 1 || isNaN(page)) {
			return ;
		}
		backStyle(currentScaleIndex);
		currentPage = page;

		var centerIndex = Math.ceil(show_scale_size/2);
		var count = pageSize;
		if(pageSize-page < show_scale_size) {
			for(var i = show_scale_size ; i >= 1 ; i--) {
				if(count == page) {
					setStyle(i);
					currentScaleIndex = i;
				}
				controlList[i].innerHTML = count;
				count--;
			}
			controlList[centerIndex].attachEvent && controlList[centerIndex].attachEvent("onclick",self.clickScale);
			controlList[centerIndex].addEventListener && controlList[centerIndex].addEventListener("click",self.clickScale,false);
		}else {
			for(var i = 1 ; i < centerIndex ; i++) {
				controlList[i].innerHTML = page;
				page++;
			}
			controlList[centerIndex].innerHTML = "...";
			controlList[centerIndex].detachEvent && controlList[centerIndex].detachEvent("onclick", self.clickScale);
			controlList[centerIndex].removeEventListener && controlList[centerIndex].removeEventListener("click", self.clickScale, false);
			for(var i = show_scale_size ; i > centerIndex ; i--) {
				controlList[i].innerHTML = count;
				count--;
			}
			setStyle(1);
			currentScaleIndex = 1;
		}

		//设置页码事件处理函数 todo...
		if(clickEvent != null)
			clickEvent(currentPage);
	};


	//初始化页码数据添加点击事件
	this.initPageData = function() {
		//var centerIndex = Math.ceil(show_scale_size/2)+1;
		var centerIndex = Math.ceil(show_scale_size/2);
		if(pageSize < show_scale_size) 
			return ;
		var count = 0;
		if (flag){
			for (var i = 1 ; i <= controlList.length-2; i++)
			{
				controlList[i].innerHTML = i;
				controlList[i].attachEvent && controlList[i].attachEvent("onclick",this.clickScale);
				!controlList[i].attachEvent && controlList[i].addEventListener 
					&& controlList[i].addEventListener("click",this.clickScale,false);
			}
		}else {
			
			for(var i = 1 ; i < controlList.length-2 ; i++){
				if(i != centerIndex) {
					controlList[i].innerHTML = i;
					controlList[i].attachEvent && controlList[i].attachEvent("onclick",this.clickScale);
					!controlList[i].attachEvent && controlList[i].addEventListener 
						&& controlList[i].addEventListener("click",this.clickScale,false);
				}
				else {
					controlList[i].innerHTML = "...";
					controlList[i].detachEvent && controlList[i].detachEvent("onclick", self.clickScale);
					!controlList[i].detachEvent && controlList[i].removeEventListener 
						&& controlList[i].removeEventListener("click", self.clickScale, false);
					count = i;
					break;
				}
			}
			var tempPageSize = pageSize;
			for (var i = controlList.length-2 ; i > count ; i--)
			{
				controlList[i].innerHTML = tempPageSize;
				tempPageSize-- ;
				controlList[i].attachEvent && controlList[i].attachEvent("onclick",this.clickScale);
				!controlList[i].attachEvent && controlList[i].addEventListener 
					&& controlList[i].addEventListener("click",this.clickScale,false);
			}
		}
		
		//绑定上一页事件处理函数
		controlList[0].attachEvent && controlList[0].attachEvent("onclick",this.backPage);
		!controlList[0].attachEvent && controlList[0].addEventListener 
			&& controlList[0].addEventListener("click",this.backPage,false);
		
		//绑定下一页事件处理函数
		controlList[controlList.length-1].attachEvent && controlList[controlList.length-1].attachEvent("onclick",this.nextPage);
		!controlList[controlList.length-1].attachEvent && controlList[controlList.length-1].addEventListener 
			&& controlList[controlList.length-1].addEventListener("click",this.nextPage,false);
	};

	//上一页处理事件函数
	this.backPage = function(e) {
		if(currentPage <= 1) {
			return ;
		}
		
		backStyle(currentScaleIndex);
		currentPage--;
		
		if(currentScaleIndex > 1){
			currentScaleIndex--;
		}		

		var centerIndex = Math.ceil(show_scale_size/2);
		var prefixCenter = Math.ceil((centerIndex-1)/2) == 1 ? Math.ceil((centerIndex-1)/2)+1:Math.ceil((centerIndex-1)/2);
		var suffixCenter = Math.ceil((show_scale_size-centerIndex)/2)+centerIndex;
		
		selectScale(currentScaleIndex, currentPage, centerIndex, prefixCenter, suffixCenter);
	};
	
	//下一页事件处理函数
	this.nextPage = function(e) {
		if(currentPage >= pageSize) {
			return ;
		}
		
		backStyle(currentScaleIndex);
		currentPage++;
		
		if(currentScaleIndex < controlList.length-2){
			currentScaleIndex++;
		}		

		var centerIndex = Math.ceil(show_scale_size/2);
		var prefixCenter = Math.ceil((centerIndex-1)/2) == 1 ? Math.ceil((centerIndex-1)/2)+1:Math.ceil((centerIndex-1)/2);
		var suffixCenter = Math.ceil((show_scale_size-centerIndex)/2)+centerIndex;
		
		selectScale(currentScaleIndex, currentPage, centerIndex, prefixCenter, suffixCenter);
	};
	var self = this;
	
	//点击pageSacle事件处理函数
	this.clickScale = function(e) {
		var ev = e.target || window.event.srcElement;
		var index = ev.index; //获取页码容器索引
		currentPage = parseFloat(ev.innerHTML); //设置当前页码

		//var centerIndex = Math.ceil(show_scale_size/2)+1;
		var centerIndex = Math.ceil(show_scale_size/2);
		var prefixCenter = Math.ceil((centerIndex-1)/2) == 1 ? Math.ceil((centerIndex-1)/2)+1:Math.ceil((centerIndex-1)/2);
		var suffixCenter = Math.ceil((show_scale_size-centerIndex)/2)+centerIndex;
		
		selectScale(index, currentPage, centerIndex, prefixCenter, suffixCenter);
	};

	var selectScale = function(index, currentPage, centerIndex, prefixCenter, suffixCenter) {
		//撤销上一次被选中页码的颜色
		backStyle(currentScaleIndex);
		if(controlList[index+1].innerHTML == "...") { //判断当index+1的元素值为...
			var startNumber = currentPage - (centerIndex-prefixCenter);
			var len = parseFloat(controlList[centerIndex+1].innerHTML);
			if(startNumber+centerIndex >= len) {
				startNumber = (len-1) - centerIndex;

				controlList[centerIndex].attachEvent && controlList[centerIndex].attachEvent("onclick",self.clickScale);
				controlList[centerIndex].addEventListener && controlList[centerIndex].addEventListener("click",self.clickScale,false);
				centerIndex++;

				
			}
			for(var i = 1 ; i < centerIndex ; i++) {
				startNumber++;
				controlList[i].innerHTML = startNumber;
				if(currentPage == startNumber) {
					setStyle(i);//设置当前选中页码的颜色
					currentScaleIndex = i;
				}
			}
		}else if(controlList[index-1].innerHTML == "...") {//判断当index-1的元素值为...
			var startNumber = currentPage - (suffixCenter-centerIndex);
			var len = parseFloat(controlList[centerIndex-1].innerHTML);
			if(startNumber <= len) {
				controlList[centerIndex].attachEvent && controlList[centerIndex].attachEvent("onclick",self.clickScale);
				controlList[centerIndex].addEventListener && controlList[centerIndex].addEventListener("click",self.clickScale,false);

				centerIndex -= 1; 
				startNumber = len+1;
			}
			for(var i = centerIndex+1 ; i <= show_scale_size ; i++) {
				
				controlList[i].innerHTML = startNumber;
				if(currentPage == startNumber) {
					setStyle(i);//设置当前选中页码的颜色
					currentScaleIndex = i;
				}
				startNumber++;
			}
		}else if(index == 1) {
			if(!flag) {
				if(parseFloat(controlList[show_scale_size-1].innerHTML) > show_scale_size-1) {
					controlList[centerIndex].innerHTML = "...";
					controlList[centerIndex].detachEvent && controlList[centerIndex].detachEvent("onclick", self.clickScale);
					controlList[centerIndex].removeEventListener && controlList[centerIndex].removeEventListener("click", self.clickScale, false);
				}
			}
			var startNumber = currentPage - (centerIndex-prefixCenter)-1;
			if(startNumber <= 1) {
				startNumber = 0;
			}
			if(!flag) {
				for(var i = 1 ; i < centerIndex ; i++) {
					startNumber++;
					controlList[i].innerHTML = startNumber;
					if(currentPage == startNumber) {
						setStyle(i);//设置当前选中页码的颜色
						currentScaleIndex = i;
					}
				}
			}else {
				for(var i = 1 ; i <= centerIndex ; i++) {
					startNumber++;
					controlList[i].innerHTML = startNumber;
					if(currentPage == startNumber) {
						setStyle(i);//设置当前选中页码的颜色
						currentScaleIndex = i;
					}
				}
			}
			
		}else if(index == show_scale_size) {
			if(!flag) {
				if(pageSize - parseFloat(controlList[1].innerHTML) > show_scale_size-1) {
					controlList[centerIndex].innerHTML = "...";
					controlList[centerIndex].detachEvent && controlList[centerIndex].detachEvent("onclick", self.clickScale);
					controlList[centerIndex].removeEventListener && controlList[centerIndex].removeEventListener("click", self.clickScale, false);
				}
			}
			var startNumber = currentPage + (suffixCenter-centerIndex);
			if(startNumber >= pageSize) {
				startNumber = pageSize;
			}
			for(var i = show_scale_size ; i >= centerIndex+1 ; i--) {
				
				controlList[i].innerHTML = startNumber;
				if(currentPage == startNumber) {
					setStyle(i);//设置当前选中页码的颜色
					currentScaleIndex = i;
				}
				startNumber--;
			}
		}else {
			setStyle(index);
			currentScaleIndex = index;
		}
		
		//设置页码事件处理函数 todo...
		if(clickEvent != null)
			clickEvent(currentPage);
	};

	this.creatControl();
	this.initPageData();
	
}