$(function(){
    initEvent();
});

function initEvent() {
    $(".ct-action a").click(function(){
        f_purchaseSeed($(this).attr("value"));
    });//兑换种子

}


/**
 * 能量兑换种子
 * @param sSpbh  商品编号，必传
 */
function f_purchaseSeed(sSpbh){
    BootstrapDialog.confirm({
        type: BootstrapDialog.TYPE_PRIMARY,
        size: BootstrapDialog.SIZE_SMALL,
        title: '提示',
        message: "确认兑换吗！",
        closeable: true,
        btnOKLabel: "确定",
        btnCancelLabel: "取消",
        callback: function (ret) {
            if(ret){
                f_doPurchaseSeed(sSpbh);
            }
        }
    });
}

/**
 * 执行兑换
 * @param sSpbh
 */
function f_doPurchaseSeed(sSpbh) {
    var sendRequest = new SendRequest("/web/buySeeds","POST");//构造对象
    sendRequest.addParamObj({
        cSpbh:sSpbh
    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        if("0" != ret.flag){
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "兑换失败！"+ret.msg,
                closeable: true,
                buttonLabel: "确定"
            });
        }else{
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_PRIMARY,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "兑换成功",
                closeable: true,
                buttonLabel: "确定"
            });
        }

    });//发送请求并获取返回结果
}




