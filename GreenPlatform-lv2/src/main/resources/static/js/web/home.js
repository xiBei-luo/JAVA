$(function(){
    initEvent();
});

function initEvent() {
    //移动端滑动播放
    var myTouch = util.toucher(document.getElementById('carousel-example-generic'));
    myTouch.on('swipeLeft',function(e){
        $('#carright').click();
    }).on('swipeRight',function(e){
        $('#carleft').click();
    });


    $("#mission a").click(function(){
        f_finishMission($(this).attr("value"));
    });//完成任务

    //任务天数日历事件
    $("#rwDay").click(function(){

    });
}

/**
 * 完成每日基础任务
 * @param sRwlb  任务类别，必传
 */
function f_finishMission(sRwlb){
    $(".rwlb_"+sRwlb).hide(100);
    $(".hand_"+sRwlb).hide(100);
    return
    var sendRequest = new SendRequest("/web/accomplishRw","POST");//构造对象
    sendRequest.addParamObj({
        cRwlb:sRwlb
    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        if("0" == ret.flag){
            $(".rwlb_"+sRwlb).hide(100);
            $(".hand_"+sRwlb).hide(100);
        }else if("1" == ret.flag){
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: ret.msg,
                closeable: true,
                buttonLabel: "确定"
            });
        }else{
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "操作失败！"+ret.msg,
                closeable: true,
                buttonLabel: "确定"
            });
        }

    });//发送请求并获取返回结果
}








