$(function(){
    initEvent();
});

function initEvent() {


    $("#myAccountModel .close").click(function(){
        window.location.reload()
    });

    $("#returnTop").click(function(){
        $('body,html').animate({scrollTop:0},300)
    });

    $("#myAccount").click(function(){
        f_selectLoginuserAccount();
        $("#myAccountModel").modal('show');
    });

    $("#btnCz,#btnTx").click(function () {
        $("#customModel").modal('show');
    });


    $(".navbar-nav li").click(function(){
        $(".navbar-nav li").removeClass("active");
        $(this).addClass("active");
    });

    $("#btnInviteUser").click(function () {
        $("#inviteUserQrcode").attr("src","/web/getInviteQrcode");
        $("#inviteUserModel").modal('show');
    });//邀请好友

    $(".ct-action a").click(function(){
        f_purchaseSeed($(this).attr("value"));
    });//兑换种子

    $("#mission a").click(function(){
        f_finishMission($(this).attr("value"));
    });//完成任务

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
/*
点击我的账户时，查询对应账户的详细信息
 */
function f_selectLoginuserAccount(){
    var sendRequest = new SendRequest("/web/selectLoginuserAccount","POST");//构造对象
    sendRequest.addParamObj({

    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        //登陆账户信息
        var oPlateuser = ret.object.plateUser[0];//登陆账户信息（获取人员姓名与人员等级）
        $("#cUsername").text(oPlateuser.cUsername);
        $("#cRydj").text("L"+oPlateuser.cRydj);
        if(!(oPlateuser.cRydj)){
            $("#cRydj").text("L"+0);
        }
        if (oPlateuser.cIssmz == 1){
            $("#btnCz,#btnTx").attr("disabled",false);
            $("#certiBtn").hide();
        } else{
            $("#btnCz,#btnTx").attr("disabled",true);
            $("#certiBtn").show();
        }


        //登陆用户能量汇总信息（获取能量总量）
        var oTGreenNlHz = ret.object.tGreenNlHz[0];//登陆用户能量汇总信息（获取能量总量）
        if(oTGreenNlHz){
            $("#nNlhz").text("￥ "+oTGreenNlHz.nNlhz);
        }else {
            $("#nNlhz").text("￥ "+"0");
        }

        //登陆用户点赞数量
        var oTGreenDzzl = ret.object.tGreenDzzl[0];//登陆用户点赞数量
        if(oTGreenDzzl){
            $("#nDzzl").text("M "+oTGreenDzzl.nDzzl);
        }else{
            $("#nDzzl").text("M "+"0");
        }
        //登陆用户金币总量
        var oTGreenJbzl = ret.object.tGreenJbzl[0];//登陆用户金币总量
        if(oTGreenJbzl){
            $("#nJbzl").text("S "+oTGreenJbzl.nJbzl);
        }else{
            $("#nJbzl").text("S "+"0");
        }

        //登陆用户连续完成任务多少天
        var nMonthRw = ret.object.nMonthRw;
        if (nMonthRw){
            $("#nMonthRw").text(nMonthRw + "天");
        } else{
            $("#nMonthRw").text("0天");
        }

        //登陆用户任务完成信息（今日任务是否完成）
        var aTGreenRwRwmx = ret.object.tGreenRwRwmx;//登陆用户任务完成信息（今日任务是否完成）
        if(aTGreenRwRwmx.length > 0){
            var aRwlbArr = [];
            $(aTGreenRwRwmx).each(function(i){
                aRwlbArr.push(aTGreenRwRwmx[i].cRwlb);
            });
            if (aRwlbArr.length < 3){
                for(var i=1;i<4;i++){
                    if($.inArray(i.toString(),aRwlbArr)<0){
                        $("#cRwlb_"+i).addClass( "badge-warning");
                        $("#cRwlb_"+i).text( "未完成");
                    }
                }
            }
        }else{
            for(var i=1;i<4;i++){
                $("#cRwlb_"+i).addClass( "badge-warning");
                $("#cRwlb_"+i).text( "未完成");
            }
        }


        //登陆用户种子信息（查询用户有几种未捐赠的种子）
        var atGreenZzZjzzmx = ret.object.tGreenZzZjzzmx;//登陆用户种子信息（查询用户有几种未捐赠的种子）
        if (atGreenZzZjzzmx.length > 0) {

            $("#mySeed ul li").remove();

            $(atGreenZzZjzzmx).each(function(i,v){
                $("#mySeed ul").append("<li class=\"list-group-item\">\n" +
                    "<span id='"+v.cSpbh+"'>"+v.cSpmc+"</span>\n" +
                    //"<button id='"+v.cSpbh+"' onclick='f_contributeSeed("+JSON.stringify(v)+")'  class='btn btn-primary btn-sm float-right' "+(v.cKjz == '0' ? 'disabled' : '')+">捐赠</button>\n" +
                    "<button id='"+v.cSpbh+"' onclick='f_contributeSeed("+JSON.stringify(v)+")' class='btn btn-primary btn-sm float-right'>捐赠</button>\n" +
                    "</li>");
            });
        }else{
            $("#mySeed ul").append("<li class=\"list-group-item\">\n" +
                "无\n" +
                "</li>");
        }

        //登陆人的徒弟账户信息
        var aplateUserSon = ret.object.plateUserSon;//登陆用户的子账户信息
        if (aplateUserSon.length > 0) {

            $("#mySon ul li").remove();

            $(aplateUserSon).each(function(i,v){

                $("#mySon ul").append("<li class=\"list-group-item\">\n" +
                    "<span id='"+v.cUserid+"'>"+v.cUsername+"</span>\n" +

                    "<div class='float-right'>"+
                    "<input type='checkbox' disabled "+(v.sonUserRwmx['1'] == true ? 'checked' : '')+"> 施肥&nbsp&nbsp"+
                    "<input type='checkbox' disabled "+(v.sonUserRwmx['2'] == true ? 'checked' : '')+"> 浇水&nbsp&nbsp"+
                    "<input type='checkbox' disabled "+(v.sonUserRwmx['3'] == true ? 'checked' : '')+"> 沐浴阳光"+
                    "</div>"+
                    "</li>");
            });
        }else{
            $("#mySon ul").append("<li class=\"list-group-item\">\n" +
                "无\n" +
                "</li>");
        }



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
        if("0" == ret.flag){
            $(".rwlb_"+sRwlb).hide(100);
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


/**
 * 捐赠种子
 * @param id
 */
function f_contributeSeed(data){
    var sendRequest = new SendRequest("/web/contributeSeed","POST");//构造对象
    sendRequest.addParamObj({
       "cSpbh":data.cSpbh,
        "cLsh":data.cLsh
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


/*function f_initBannerImg(){
    var width = $(window).width();
    if (width <= 600) {
        $(".item>img").attr("src","../../publicImg/telBg.jpg");
    }

}*/









