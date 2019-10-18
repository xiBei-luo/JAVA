
jQuery(function() {
	
    MdiWindow = function(win, width,height,left,top,isMadal,opacity,skin){
        this.parentWin = win;       // 父亲窗口
        this.ywlxdm = "";           // 业务类型代码
        this.winname = "";          // 窗口名称
        this.winIndex = null;       // 窗口索引
        this.winHandle = null;      // 窗口对象
        this.layero = null;         // layer对象
        this.iframeWin = null;      // 窗口中iframe对象
        this.title = '';            // 标题
        this.titlestyle = '';       // 标题类型
        this.dispTitle = true;      // 是否显示标题
        this.left = left;           // 打开左侧位置
        if(null == left){
        	this.left = 0;
        }
        this.top = top;             // 打开顶部位置
        if(null == top){
        	this.top = 0;
        }
        if((width+"").indexOf("%") > 0){
        	// 按百分比
        	var fulwidth = document.body.offsetWidth;
        	var newstr = (width+"").replace(/%/, "");
        	this.width = fulwidth * ((newstr * 1) / 100);
        }else{
        	this.width = width;         // 窗口宽
        }
        if((height+"").indexOf("%") > 0){
        	var fulheight = document.body.offsetHeight;
        	var newstr = (height+"").replace(/%/, "");
        	this.height = fulheight * ((newstr * 1) / 100);
        }else{
        	this.height = height;       // 窗口高
        }
        this.canClose = 1;          // 是否显示关闭按键
        this.canMax = true;         // 是否允许最大化
        this.canMin = true;         // 是否允许最小化
        this.canresize = false;     // 是否允许拉伸
        this.shade = false;         // 是否遮罩
        this.fullopen = false;      // 是否打开最大化
        this.params = null;         // 参数
        if(isMadal){
        	if(opacity){
        	  this.shade = opacity;   // 遮罩深度
        	}else{
        		this.shade = 0.3;
        	}
        }
        this.skin = skin;
        this.cancelEvent = null;       // 右上角关闭事件
        this.closeEvent = null;        // 关闭事件
        this.fullEvent = null;         // 最大化事件
        this.minEvent = null;          // 最小化事件
        this.restoreEvent = null;      // 窗口大小还原事件
        this.isOpenHide = false;       // 创建后是否隐藏窗口
        this.isHide = false;           // 窗口是否隐藏
    };
    
    
    /**
     * 打开窗口
     */
    MdiWindow.prototype.load = function(sUrl,/*Window*/oWin, callback){
        if(oWin){
          try{
          	  if(sUrl.indexOf("http://") < 0){
                  sUrl=oWin.document.URL.replace(/[^\\\/]*$/,"")+sUrl;
          	  }
          }catch(ex){
              throw new Exception("MdiWindow.load 错误:"+ex.description);
          }
        }
        
        var fulwidth = document.body.offsetWidth;
        var fulheight = document.body.offsetHeight;
        
        var canMaxMin = false;
        if(this.canMax || this.canMin){
        	canMaxMin = true;
        }
        var dispClose = this.canClose;

        var loc_titlestyle = this.titlestyle;
        var arg = this.params;
        var loc_parentwin = this.parentWin;
        var loc_winwidth = this.width;
        var loc_winheight = this.height;
        var loc_resize = this.canresize;
        var loc_shade = this.shade;
        
        var loc_cancelEvent = this.cancelEvent;
        var loc_closeEvent = this.closeEvent;
        var loc_fullEvent = this.fullEvent;
        var loc_minEvent = this.minEvent;
        var loc_restoreEvent = this.restoreEvent;
        
        var loc_this = this;
        
        var loc_fullopen = this.fullopen;
        var loc_openhide = this.isOpenHide;
        
        var setok = false;
        
        var loc_title = null;
        //var loc_title = this.title;
        if(this.dispTitle){
        	 loc_title = [this.title, loc_titlestyle];
        }else{
        	 loc_title = false;
        }
        
        var loc_offset = null;
        var loc_setoffset = false;
        
        if(0 != this.left && 0 != this.top ){
        	 loc_offset = [this.top + 'px', this.left + 'px'];
        	 loc_setoffset = true;
        }
        if(0 != this.top  && 0 == this.left ){
        	 loc_offset = this.top + 'px';
        	 loc_setoffset = true;
        }
        if(0 != this.left && 0 == this.top ){
        	 var ltop = (fulheight - loc_winheight)/2;
        	 loc_offset = [ltop + 'px', this.left + 'px'];
        	 loc_setoffset = true;
        }
        /*if((null == this.top || this.top == 0) && (null == this.left || this.left == 0)){
        	 //var lleft = (fulwidth - loc_winwidth)/2;
        	 var ltop = (fulheight - loc_winheight - 43)/2;
        	 loc_offset = ltop + 'px';
        }*/

        var winparams = {
                            type: 2,
                           title: loc_title,
                            area: [loc_winwidth + "px", loc_winheight + "px"],
                          maxmin: canMaxMin,
                        closeBtn: dispClose,
                          resize: loc_resize,
                      shadeClose: false,
                           shade: loc_shade,
                       scrollbar: false,
                          zIndex: top.layer.zIndex,
                         content: sUrl,
                         success: function(layero, index){
                                     loc_this.winname = layero.find('iframe')[0]['name'];
                                     var iframeWin = top.window[loc_this.winname]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                                     iframeWin.parentWindow = loc_parentwin;
                                     iframeWin.windowArguments = arg;
                                     loc_this.winIndex = index;
                                     loc_this.layero = layero;
                                     loc_this.iframeWin = iframeWin;
                                     top.layer.setTop(layero);
                                     if(loc_fullopen){
                                        // 全屏打开
                                        top.layer.full(index);
                                     }
                                     if(loc_openhide){
                                        $(layero).hide();
                                        loc_this.isHide = true;
                                     }
                                     if(callback){
                                       callback(loc_this);
                                     }
                                     try{
                                         // 自动调用子页面的初始化方法，此方法主要用于获取参数，不然会出现windowArguments未定义的情况
                                         iframeWin._init(arg,loc_this,index,loc_parentwin);
                                     }catch (e){}
                                  },
                          cancel: function(index){
                                     if(typeof loc_cancelEvent=="function"){
                                       return loc_cancelEvent(index);
                                     };
                                  },
                             end: function(){
                                     var retParam = loc_parentwin.returnValue;
                                     loc_parentwin.returnValue = null;
                                     
                                     if(typeof loc_closeEvent=="function"){
                                       loc_closeEvent(retParam, loc_this);
                                     };
                                     //var iframeWin = top.window[loc_this.layero.find('iframe')[0]['name']];
                                     //document.getElementById(iframeWin.name).src = "about:blank";
                                  },
                            full: function(){
                                     if(typeof loc_fullEvent=="function"){
                                       loc_fullEvent(obj);
                                     };
                                  },
                             min: function(){
                                     if(typeof loc_minEvent=="function"){
                                       loc_minEvent(obj);
                                     };
                                  },
                         restore: function(){
                                     if(typeof loc_restoreEvent=="function"){
                                       loc_restoreEvent(obj);
                                     };
                                  }
                        };
                        
        if(loc_setoffset){
        	winparams.offset = loc_offset;
        }
        
        this.winHandle = top.layer.open(
                                         winparams
                                       );
    
    };
    
    
    /**
     * 设置业务类型代码
     */
    MdiWindow.prototype.setYwlxdm = function(ywlxdm){
    	this.ywlxdm = ywlxdm;
    }
    /*
    var show_win = top.layer.open(
      {
        title:  [titlename,'font-family:微软雅黑;font-size:14px'],
        type:   2,
        area:   ['960px', '500px'],
        maxmin: canMaxmin,
        resize: param.winresize,
        shadeClose: true,
        shade: false,
        content: './function/test/test.jsp?version=6',
        zIndex: top.layer.zIndex,
        success: function(layero, index){
          top.layer.setTop(layero);
          var iframeWin = top.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
          iframeWin.windowArguments = arg
          //var body = layer.getChildFrame('body', index);
          //console.log(body.html()) //得到iframe页的body内容
          //body.find('input').val('Hi，我是从父页来的')
        },
        end: function(){
          alert([window.returnValue.retflag, window.returnValue.retmsg]);
        }
      }
    );*/
    
    
    /**
     * 设置标题
     */
    MdiWindow.prototype.setTitle = function(title, titlestyle){
    	this.title = title;
    	if(titlestyle){
    		this.titlestyle = titlestyle;
    	}
    	if(this.winIndex){
    		top.layer.title([this.title, this.titlestyle], this.winIndex);
    	}
    };
    
    /**
     * 设置窗口创建后是否隐藏
     */
    MdiWindow.prototype.setOpenHide = function(hide){
    	this.isOpenHide = hide;
    }
    
    /**
     * 设置是否显示标题
     */
    MdiWindow.prototype.isDispTitle = function(display){
    	this.dispTitle = display;
    };
    
    /**
     * 设置参数
     */
    MdiWindow.prototype.setWindowArguments = function(param){
    	this.params = param;
    };
    
    
    MdiWindow.prototype.fullOpen = function(fullopen){
    	this.fullopen = fullopen;
    };
    
    /**
     * 关闭窗口
     */
    MdiWindow.prototype.close = function(index){
    	top.layer.close(index)
    }
    
    /**
     * 回复原窗口
     */
    MdiWindow.prototype.restore = function(index){
    	try{
    	   top.layer.restore(index);
    	}catch(e){};
    }
    
    
    /**
     * 隐藏窗口
     */
    MdiWindow.prototype.hide = function(){
    	 if(this.layero && !this.isHide){
    	 	  $(this.layero).hide();
    	 	  this.isHide = true;
    	 }
    }
    
    /**
     * 显示窗口
     */
    MdiWindow.prototype.show = function(){
    	 if(this.layero && this.isHide){
          $(this.layero).show();
          this.isHide = false;
       }
    }
    
    /**
     * 调整窗口大小
     */
    MdiWindow.prototype.setSize = function(width, height){
    	 try{
    	 	   var params = new Object();
    	 	   if(null != width && width > 0){
    	 	   	  params.width = width + "px";
    	 	   }
    	 	   if(null != height && height > 0){
    	 	   	  params.height = height + "px";
    	 	   }
    	 	   top.layer.style(this.winIndex, params);
    	 }catch(e){};
    }
    
    
    /**
     * 调整窗口位置
     */
    MdiWindow.prototype.setPosition = function(tops, lefts){
    	 try{
    	 	   var params = new Object();
    	 	   if(null != tops){
    	 	   	  params.top = tops + "px";
    	 	   }
    	 	   if(null != lefts){
    	 	   	  params.left = lefts + "px";
    	 	   }
    	 	   top.layer.style(this.winIndex, params);
    	 }catch(e){};
    }
    
    
    /**
     * 窗口置顶
     */
    MdiWindow.prototype.setTop = function(layerNow){
    	top.layer.zIndex++;
    	layerNow.css('z-index', top.layer.zIndex + 1);
    	
    }
    
    /**
     * 是否显示窗口右上角关闭按键
     */
    MdiWindow.prototype.btnClose = function(isCanClose){
    	if(isCanClose){
    		this.canClose = 1;
    	}else{
    		this.canClose = 0;
    	}
    }
    
    /**
     * 设置是否允许最大化
     */
    MdiWindow.prototype.btnMax = function(isCanMax){
    	this.canMax = isCanMax;
    }
    
    /**
     * 设置是否允许最小化
     */
    MdiWindow.prototype.btnMin = function(isCanMin){
      this.canMin = isCanMin;
    }
    
    /**
     * 设置是否允许拉伸
     */
    MdiWindow.prototype.isResize = function(isresize){
      this.canresize = isresize;
    }
    
    /**
     * 窗口右上角关闭按键事件
     */
    MdiWindow.prototype.onCancel = function(cancelhandle){
    	this.cancelEvent = cancelhandle;
    }
    /**
     * 设置关闭事件
     */
    MdiWindow.prototype.onClose = function(closeHandle){
    	this.closeEvent = closeHandle;
    };
    
    /**
     * 最大化事件
     */
    MdiWindow.prototype.onFull = function(fullHandle){
    	this.fullEvent = fullHandle;
    };
    
    /**
     * 最小化事件
     */
    MdiWindow.prototype.onMin = function(minHandle){
      this.minEvent = minHandle;
    }
    
    /**
     * 恢复原始大小事件
     */
    MdiWindow.prototype.onRestore = function(restoreHandle){
      this.restoreEvent = restoreHandle;
    }
    
    // 兼容老版本不报错设置
    MdiWindow.prototype.moveToCenter = function(){
        if(console && console.log)console.log("moveToCenter 方法已经过时，增加此方法为了兼容低版本不报错。");
    }
    MdiWindow.prototype.setIcon = function(){
        if(console && console.log)console.log("setIcon 方法已经过时，增加此方法为了兼容低版本不报错。");
    }
    window.initMdiWindow  = function(){
        if(console && console.log)console.log("initMdiWindow 方法已经过时，增加此方法为了兼容低版本不报错。");
    }
	
});



/**
 * 打开一个MDI窗口
 * @param {} win
 * @param {} width
 * @param {} height
 * @param {} left
 * @param {} top
 * @param {} isMadal
 * @param {} skin
 * @return {}
 */
function openMdiWindow(win, width, height, left, top, isMadal, skin) {
    var iwidth = width;
    var iheight = height;
    var itype = (width + "").toLowerCase();
    if(itype == 's'){
      // 小窗口
      iwidth = "320";
      if(null == iheight || "" == iheight || iheight.length < 1){
        iheight = "202";
      }
    }else if(itype == 'm'){
      // 中窗口
      iwidth = "400";
      if(null == iheight || "" == iheight || iheight.length < 1){
        iheight = "288";
      }
    }else if(itype == 'l'){
      // 大窗口
      iwidth = "640";
      if(null == iheight || "" == iheight || iheight.length < 1){
        iheight = "480";
      }
    }
    
    return new MdiWindow(win, width, height, left, top, isMadal, 0.3, skin);
  
}


/**
 * 显示提示信息
 * @param {} message
 */
function openMdiAlert(title, message, icon, callback, ext){
    var disptitle = "";
    var iicon = 2;
    if(null == title || "" == title){
      disptitle = "提示";
    }else{
      disptitle = title;
    }
    if(null == icon || "" == icon){
      iicon = 2;
    }else{
      switch(icon.toUpperCase()){
        
        case 'EXC':      // 感叹号
           iicon = 0;
           break;
        case 'OK':       // 正确
           iicon = 1;
           break;
        case 'ERR':       // 错误
           iicon = 2;
           break;
        case 'QUESTION':  // 问题
           iicon = 3;
           break;
        case 'LOCK':      // 锁
           iicon = 4;
           break;
        case 'CRYFACE':      // 哭脸
           iicon = 5;
           break;
        case 'SMILEFACE':      // 笑脸
           iicon = 6;
           break;
        default:
           iicon = 2;
      }
    }
    
      var area = 'auto';
      if(ext){
          if(!ext.width || parseInt(ext.width) <  220) ext.width = '220px';
          if(ext.height && parseInt(ext.height) < 130) ext.height = '130px';
          if(!ext.height){
              area = ext.width;
          }else{
              area = [ext.width, ext.height];
          }
      }
          
    layer.alert(message, 
                {
                     icon: iicon,
                    title: disptitle,
                scrollbar: false,
                     area: area,
                   zIndex: layer.zIndex,
                  success:function(layero, index){
                             layer.setTop(layero);
                          },
                      end: function(){
                          if(callback){
                            callback();
                          }
                      }
                }
               );
}


/**
 * 打开询问窗口
 * @param {} title
 * @param {} message
 * @param {} cancelfun
 * @param {} returnfun
 * @param {} okfun
 */
function openMDIconfirm(title, message, cancelfun, returnfun, okfun, ext){
    var disptitle = "";
    if(null == title || "" == title){
      disptitle = "提示";
    }else{
      disptitle = title;
    }
    
    var area = 'auto';
    if(ext){
        if(!ext.width || parseInt(ext.width) <  220) ext.width = '220px';
        if(ext.height && parseInt(ext.height) < 130) ext.height = '130px';
        if(!ext.height){
            area = ext.width;
        }else{
            area = [ext.width, ext.height];
        }
    }
    
    layer.confirm(message,
                  {
                         icon:  3, 
                        title: disptitle,
                    scrollbar: false,
                         area: area,
                       zIndex: layer.zIndex,
                      success: function(layero, index){
                                  layer.setTop(layero);
                               },
                       cancel: function(){
                                  if(typeof cancelfun=="function"){
                                     cancelfun();
                                  }
                               }
                  },
                  function(index){
                    if(typeof okfun=="function"){
                       okfun(index);
                    }
                  },
                  function(index){
                    if(typeof returnfun=="function"){
                       returnfun(index);
                    }
                  }
                 );
}


/**
 * 关闭指定索引的窗口
 * @param {} index
 */
function closeMDIWin(index){
	 layer.close(index);
}

jQuery.extend({
    MdiWindow : openMdiWindow
});

jQuery.extend({
	  MdiAlert : openMdiAlert
});

jQuery.extend({
	  Mdiconfirm : openMDIconfirm
});

jQuery.extend({
    Mdiclose : closeMDIWin
});