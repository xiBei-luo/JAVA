$(function(){
    $("#contributeSeed").click(function(){
        var cLsh = $(this).attr("data-clsh");
        var cSpbh = $(this).attr("data-cspbh");

        f_contributeSeed(cLsh,cSpbh);
    });
});


/**
 * 捐赠种子
 * @param id
 */
function f_contributeSeed(cLsh,cSpbh){
    var sendRequest = new SendRequest("/web/contributeSeed","POST");//构造对象
    sendRequest.addParamObj({
        "cSpbh":cSpbh,
        "cLsh":cLsh
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
                    if (ret){
                        $("#myAccountModel .close").trigger("click");
                    }
                }
            });
        }
    });
}
