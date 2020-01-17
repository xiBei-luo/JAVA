$(function(){
    initEvent();
});

function initEvent() {
    $("#btnLike").click(function(){
        f_doLike();
    });//点赞业务
}


function toStart(){
    $("#jsGold").css({
        "top":"0",
        "opacity":"1"
    });
}



/**
 * 点赞业务
 */
function f_doLike(){
    var sendRequest = new SendRequest("/web/doLike","POST");//构造对象

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
            $("#jsGold").animate({
                top:"-30px",
                opacity:"0"
            }, {speed:"400",easing:"swing",callback:toStart()});

            $("#btnLike").css({"color":"#b92c28"});
        }

    });//发送请求并获取返回结果
}










