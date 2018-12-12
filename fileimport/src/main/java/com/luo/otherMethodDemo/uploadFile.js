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