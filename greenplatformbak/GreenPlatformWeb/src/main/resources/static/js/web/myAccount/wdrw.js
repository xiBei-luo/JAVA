$(function(){
    $("#btnAccYesRw").click(function(){
        f_accYesRw();
    });
});


/**
 * 补昨日任务
 */
function f_accYesRw(){
    var sendRequest = new SendRequest("/web/accYesRw","POST");//构造对象
    sendRequest.addParamObj({

    });

    sendRequest.sendRequest(function(ret){
        if("0" != ret.flag){
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "操作失败！"+ret.msg,
                closeable: true,
                buttonLabel: "确定"
            });
        }else{
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_PRIMARY,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "操作成功！",
                closeable: true,
                buttonLabel: "确定",
                callback: function(ret){
                    $("#btnAccYesRw").attr("disabled",true);
                }
            });
        }
    });
}
