$(function(){
    initEvent();
});

function initEvent() {
    $("#myAccount").click(function(){
        f_selectLoginuserAccount();
        $("#myAccountModel").modal('show');
    });


    $(".navbar-nav li").click(function(){
        $(".navbar-nav li").removeClass("active");
        $(this).addClass("active");
    });

    $(".ct-action a").click(function(){
        f_purchaseSeed($(this).attr("value"));
    });//兑换种子

    $("#mission a").click(function(){
        f_finishMission($(this).attr("value"));
    });//完成任务
}
/*
点击我的账户时，查询对应账户的详细信息
 */
function f_selectLoginuserAccount(){
    var sendRequest = new SendRequest("/system/selectLoginuserAccount","POST");//构造对象
    sendRequest.addParamObj({

    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        console.log(ret);
    });//发送请求并获取返回结果
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
    var sendRequest = new SendRequest("/system/insertTGreenZzZjzzmx","POST");//构造对象
    sendRequest.addParamObj({
        cSpbm:sSpbh
    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        console.log(ret);
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

/**
 * 完成每日基础任务
 * @param sRwlb  任务类别，必传
 */
function f_finishMission(sRwlb){
    var sendRequest = new SendRequest("/system/insertTGreenRwRwmx","POST");//构造对象
    sendRequest.addParamObj({
        cRwlb:sRwlb
    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        console.log(ret);
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
                message: "操作成功",
                closeable: true,
                buttonLabel: "确定"
            });
        }

    });//发送请求并获取返回结果
}



