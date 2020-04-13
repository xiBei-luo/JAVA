
var Page = {};

/**
 * 在当前页面加入透明层以阻止页面继续响应事件
 * 主要用于防止用户两次点击按钮
 */
Page.wait = function(){
	var bgdiv = top.document.getElementById("_BackGroundWaitDiv");
	if(!bgdiv){
		var bgdiv = top.document.createElement("div");
		bgdiv.id = "_BackGroundWaitDiv";
		bgdiv.style.display = 'none';
		
		var ts = top.document.getElementsByTagName("body");
		ts[0].appendChild(bgdiv);
		bgdiv.style.cssText = "background-color:#333;position:absolute;left:0px;top:0px;opacity:0.03;filter:alpha(opacity=3);width:100%;height:100%;z-index:20000";
	}
	var mh = Math.max(top.document.documentElement.scrollHeight, top.document.body.scrollHeight);
	bgdiv.style.height = mh+"px";
	bgdiv.style.display = '';
};


/**
 * 取消当前页面加入的透明层
 */
Page.waitend = function(){
	var bgdiv = top.document.getElementById("_BackGroundWaitDiv");
	if(bgdiv){
		bgdiv.style.display = 'none';
	}
};

/**
 * 将指定对象加上遮罩层
 * @param {} obj
 * @param {} backcolor
 * @param {} deep
 * @param {} zindex
 */
Page.waitObj = function(obj, backcolor, deep, zindex){
	var bgdiv = obj.getElementById("_BackGroundWaitDiv");
	if(!bgdiv){
		var bgdiv = obj.createElement("div");
		bgdiv.id = "_BackGroundWaitDiv";
		bgdiv.style.display = 'none';
		
		var ts = obj.getElementsByTagName("body");
		ts[0].appendChild(bgdiv);
		bgdiv.style.cssText = "background-color:" + backcolor + ";position:absolute;left:0px;top:0px;opacity:" + deep * 0.01 + ";filter:alpha(opacity=" + deep + ");width:100%;height:100%;z-index:" + zindex + ";";
	}
	var mh = Math.max(obj.documentElement.scrollHeight, obj.body.scrollHeight);
	bgdiv.style.height = mh+"px";
	bgdiv.style.display = '';
};

/**
 * 取消指定对象的遮罩
 * @param {} obj
 */
Page.waitendObj = function(obj){
	var bgdiv = obj.getElementById("_BackGroundWaitDiv");
	if(bgdiv){
		bgdiv.style.display = 'none';
	}
};

