$(function(){
    initEvent();

    getTipsOfZz();

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
    $("#rwDayBox").click(function(){
        f_selectRwDayTips();
        $("#rwDayModal").modal('show');
    });
}

/**
 * 查询任务日历提示
 */
function f_selectRwDayTips(){
    var sendRequest = new SendRequest("/web/selectRwDayTips","POST");//构造对象
    sendRequest.addParamObj({

    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        if("0" == ret.flag){
           /* $("#rwDayModal .modal-body").html("<p>亲爱的用户，您本次已种植【仙人掌】14天，</p>\n" +
                "                    <p>完成本次30天任务种植可获得总能量为￥：112，</p>\n" +
                "                    <p>您的账户等级为1级，完成本次种植任务后还可额外获得能量奖励￥：2。</p>");*/

            $("#rwDayModal .modal-body").html(ret['object']);
        }else{
            $("#rwDayModal .modal-body").html("查询出错啦！");
        }

    });//发送请求并获取返回结果
}

/**
 * 完成每日基础任务
 * @param sRwlb  任务类别，必传
 */
function f_finishMission(sRwlb){
    var sendRequest = new SendRequest("/web/accomplishRw","POST");//构造对象
    sendRequest.addParamObj({
        cRwlb:sRwlb
    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        console.log(ret);
        if("0" == ret.flag){
            $(".rwlb_"+sRwlb).css("visibility","hidden");
            $(".hand_"+sRwlb).css("visibility","hidden");
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

/**
 * 获取多少天未种植植物提示
 */
function getTipsOfZz(){
    var sendRequest = new SendRequest("/web/noZz","POST");//构造对象
    sendRequest.addParamObj({

    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        if("0" != ret.flag){
            $(".carousel-indicators li:first-child").attr("class","active");
            $(".carousel-inner .item:first-child").addClass("active");

            $("#noZzModal #noZzContent").html(ret.msg);
            $("#noZzModal").modal('show');
        }

    });//发送请求并获取返回结果
}








