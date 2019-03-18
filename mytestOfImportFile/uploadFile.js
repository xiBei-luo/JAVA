top.initMdiWindow(this);
var user = top._globPlateUserInfo;
var allywfjqx = user.allywfjqx;
var allywqxmenu = user.allywqxmenu;

$(function() {
	
	initEvent();


});

function initEvent() {
	
	$("#btnRet").click(function() {
    	window.returnValue = false;
    	windowHandler.btnClose.click();
    });
	
	$("#btnSelFile").click(function(){
		//f_btnSelFile();
		$("#openFile").trigger("click");  
	});

	$("#openFile").change(function(){
		var filePath = $("#openFile").val();
		 $("#C_FILE").val(filePath);
		 $("#C_FILE").attr("title",filePath);
	});

	$("#btnSave").click(function(){
		f_btnSave();
	});	
	
	$(window).load(function(){
	});
	
}

/**
 * 保存
 */
function f_btnSave(){
	$("#btnSave").attr("disabled",true);
	
	if(!f_checked()){
		return;
	}
	
	top.dhtmlx.confirm({
		title: "温馨提示",
		type: "confirm-warning",
		ok: "确  定",
		cancel: "取  消",
		text: "确定上传？",
		callback: function(params) {
			$("#btnSave").attr("disabled",false);
			if (!params) {
				return ;
			} else {
				f_savedata_bak();
			}
		}
	});

}

/**
 * 保存数据
 */
function f_savedata(){
	$("#btnSave").attr("disabled",true);
	var filePath = $.trim($("#C_FILE").val());
	filePath = "C:\\Users\\lcm\\Desktop\\银行收款明细表（导出原表）(潘老师给的).xlsx";
	var imp = {};
	imp.impfile = filePath; //不能为空
	imp.userid = 1; //不能为空
	imp.header = ["对方账号","交易时间","对方单位","转入金额"]; //不能为空
	imp.tableName = "T_CTRI_CW_YHRJZ_TEMP"; //不能为空
	imp.tableField = ["C_ACCOUNTNO","C_JYSJ","C_KHMC","C_ZRJE"]; //不能为空
    
    //传入的参数
	var param={
			impfile 	:	imp.impfile,  
			header 		:	imp.header,  
			tableName 	:	imp.tableName,  
			tableField 	:	imp.tableField,  
			userid 		:	1          
	}
	
	var ajax=new AjaxProxy();
	//禁止缓存
	ajax.setCacheData(false);
	ajax.addParm("json_params",$.toJSON(param));
	ajax.addParm("file", $.trim($("#C_FILE").val()));
	
	Page.wait();
	//等待图标
	var spinner = new Spinner({lines: 20, radius: 30, length: 6, corners:0.9, trail: 30}).spin(document.body);
	
	try {
		ajax.invokeJava("impFileCltService.impFile", true, function (ap) {
			Page.waitend();
			spinner.stop();
			
			if(ap.getString("SYS_FLAG")==null || ap.getString("SYS_FLAG") != "0"){
				top.$.MdiAlert('提示', "调用出错！"+ap.getString("SYS_ERROR"), "ERR", function(){});
				return;
			}
			//返回结果集
			eval("var result = " + ap.getString("RESULT"));
			var ret = result.ret;
			var msg = result.msg;
			if(ret == "0"){
				top.dhtmlx.alert({
					title:"成功",
					type: "alert",
					ok:   "确　定",
					text: "上传成功！",
					callback: function(){
						$("#btnSave").attr("disabled",false);
						window.returnValue = true;
						windowHandler.btnClose.click();
					}
				});
			}else{
				top.dhtmlx.alert({
					title: "错误",
					type:  "alert-error",
					ok:    "返　回",
					text:  "上传失败！\n"+msg,
					callback: function(){
						$("#btnSave").attr("disabled",false);
					}
				});
			}
			
			
		}, ajax)
	} catch (e) {
	}
}
/**
 * 保存数据  使用Servlet方式
 */
function f_savedata_bak(){
	var formData = new FormData($('#fileForm')[0]);
	formData.append('userid','2');
	formData.append('header',["对方账号","交易时间","对方单位","转入金额"]);
	formData.append('tableName','T_CTRI_CW_YHRJZ_TEMP');
	formData.append('tableField',["C_ACCOUNTNO","C_JYSJ","C_KHMC","C_ZRJE"]);
	$.ajax({
		type:'post',
		url:getContextPath() + "/*.IMPXLS",
		data:formData,
		cache:false,
		processData: false,
        contentType: false,
	}).success(function(data){
		top.dhtmlx.alert({
			title:"成功",
			type: "alert",
			ok:   "确　定",
			text: "上传成功！",
			callback: function(){
				$("#btnSave").attr("disabled",false);
				window.returnValue = true;
				windowHandler.btnClose.click();
			}
		});
	}).error(function(){
		top.dhtmlx.alert({
			title: "错误",
			type:  "alert-error",
			ok:    "返　回",
			text:  "上传失败！\n"+msg,
			callback: function(){
				$("#btnSave").attr("disabled",false);
			}
		});
	});
	
	
	/*$("#btnSave").attr("disabled",true);
	var filePath = $("#openFile")[0].files[0];
	console.log(filePath);
	var imp = {};
	imp.impfile = $.toJSON(filePath); //不能为空
	imp.userid = 2; //不能为空
	imp.header = ["对方账号","交易时间","对方单位","转入金额"]; //不能为空
	imp.tableName = "T_CTRI_CW_YHRJZ_TEMP"; //不能为空
	imp.tableField = ["C_ACCOUNTNO","C_JYSJ","C_KHMC","C_ZRJE"]; //不能为空    
    var action = getContextPath() + "/*.IMPXLS";
    console.log(imp);
    var parameter = "data="+$.toJSON(imp);
    var lobj_self = $("#hid_ifrm");*/
    
    
	/*Page.wait();
	//等待图标
	var spinner = new Spinner({lines: 20, radius: 30, length: 6, corners:0.9, trail: 30}).spin(document.body);
	
    private_invoke(lobj_self, action , parameter , true , function(ap){
		Page.waitend();
		spinner.stop();

		var result = lobj_self.responseInfo;
		var ret = result.ret;
		var msg = result.msg;
		if(ret == "0"){
			top.dhtmlx.alert({
				title:"成功",
				type: "alert",
				ok:   "确　定",
				text: "上传成功！",
				callback: function(){
					$("#btnSave").attr("disabled",false);
					window.returnValue = true;
					windowHandler.btnClose.click();
				}
			});
		}else{
			top.dhtmlx.alert({
				title: "错误",
				type:  "alert-error",
				ok:    "返　回",
				text:  "上传失败！\n"+msg,
				callback: function(){
					$("#btnSave").attr("disabled",false);
				}
			});
		}
    });*/
}

/**
 * 
 */
function private_invoke(lobj_self, action , parameter , ab_sync , af_callback , aobj_proxyObject){
	//构造XML-HTTP对象
    var lobj_xmlhttp = null; 
    if ( window.XMLHttpRequest )
        lobj_xmlhttp = new XMLHttpRequest();
    else if ( window.ActiveXObject ) {
       try {
          lobj_xmlhttp = new ActiveXObject('Msxml2.XMLHTTP');
       }
       catch(err) {
          lobj_xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
       }
    }

    //调用    
    lobj_xmlhttp.open("POST" , action , ab_sync);
    lobj_xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    
    //var lobj_self = $("#hid_ifrm");
    if(ab_sync){
        lobj_xmlhttp.send(parameter);
        //异步调用
        lobj_xmlhttp.onreadystatechange = function(){
            /*
            * 0：请求没有发出（在调用 open() 之前）。
            * 1：请求已经建立但还没有发出（调用 send() 之前）。
            * 2：请求已经发出正在处理之中（这里通常可以从响应得到内容头部）。
            * 3：请求已经处理，响应中通常有部分数据可用，但是服务器还没有完成响应。
            * 4：响应已完成，可以访问服务器响应并使用它。
            */

            if (lobj_xmlhttp.readyState == 4){
                //lobj_self.responseText = lobj_xmlhttp.responseText;
            	  //alert(lobj_xmlhttp.responseText);
                eval("var lobj_temp = " + lobj_xmlhttp.responseText);
                lobj_self.responseInfo = lobj_temp;

                af_callback(aobj_proxyObject);
                
                lobj_self   =void(0);
                lobj_xmlhttp=void(0);/*防内存泄漏*/
            }

        }
    }else{
        lobj_xmlhttp.send(parameter);

        //alert(lobj_xmlhttp.responseText);
        
        var responseText = lobj_xmlhttp.responseText;

        eval("var lobj_temp = " + responseText);//alert($.toJSON(lobj_temp));
        lobj_self.responseInfo = lobj_temp;
        
        lobj_xmlhttp=void(0);/*防内存泄漏*/
    }
}
/**
 * 检测判断
 */
function f_checked(){
	
	var file = $.trim($("#C_FILE").val());
	if(null==file || ""==file){
		top.dhtmlx.alert({
			title: "提示",
			type:  "alert",
			ok:    "返　回",
			text:  "请选择上传文件！",
			callback: function(){
				$("#btnSave").attr("disabled",false);
			}
		});
		return false;
	}
	
	return true;
}

/**
 * 选择客户
 */
function f_btnSelFile(){
	var fileCtrl = new ActiveXObject("MagEnvironment.MagFileCtl");
	var filePath = fileCtrl.OpenFileDlg("", false,"*.xls,*.xlsx||");alert(filePath);
	if(filePath){
		/*selectedFile = filePath;
	
		$ELS.enabled("btnOk");
		$("#imgDiv").html("");
		var img = document.createElement("img");
		img.onload = function(){
			$("#N_WIDTH").val(this.width);
			$("#N_HEIGHT").val(this.height);
			ajustImageSize.call(this);
		}
		img.src = filePath;
		$("#imgDiv").empty().append($("<img id='img_1"+"' src='"+filePath+"' width='120px' height='80px' class='thumb'/>")); 
		//$("#imgDiv").empty().append($(img));
		img = void(0);
		// /([^\\\/]*)$/.test(filePath);
		// $("C_FILENAME").value = RegExp.$1;
*/	}
	/*fileCtrl=void(0);
	filePath = void(0);*/
}

