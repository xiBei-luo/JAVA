var wait = 60;
var smsCodeFlag = false;
$(function () {
    checkRegister();

    initEvent();

});


function initEvent(){

    $("#smsCode").blur(function () {
        var reg = /^\d{6}\b/;

        if(reg.test($("#smsCode").val())){
            f_checkSms();
        }else{
            $(".inputPassword").hide();
        }
    });

    $("#cPhone").blur(function () {
        $("#getVerificationCode").attr("disabled",true);
        setTimeout(f_controlGetSmsBtn,2000);
    });

    $("#getVerificationCode").click(function () {
        //checkRegister();
        $("#registerForm").bootstrapValidator('validate');//提交验证
        if ($("#registerForm").data('bootstrapValidator').isValid()) {
            //调用短信接口发送验证码
            getVerificationCode();
        }

    });

    $("#btnNext").click(function(){
        $("#registerForm").bootstrapValidator('validate');//提交验证
        if ($("#registerForm").data('bootstrapValidator').isValid()) {
            if (smsCodeFlag){
                f_foGetBackPassword();
            }else{
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "请先输入短信验证码！",
                    closeable: true,
                    buttonLabel: "确定",
                    callback: function () {

                    }
                });
                return;
            }
        }
    });
}

function f_controlGetSmsBtn(){
    $("#registerForm").bootstrapValidator('validate');//提交验证
    if ($("#registerForm").data('bootstrapValidator').isValid()) {
        $("#getVerificationCode").attr("disabled",false);
    }else{
        $("#getVerificationCode").attr("disabled",true);
    }
}

/**
 * 倒计时
 * @param obj
 */
function countDownTime() {
    if (wait == 0) {
        $("#getVerificationCode").attr("disabled",false);
        $("#getVerificationCode").val("重新获取");
        wait = 60;
    } else {
        $("#getVerificationCode").attr("disabled",true);
        $("#getVerificationCode").val("重新发送(" + wait + ")");
        wait--;
        setTimeout(function() {
            countDownTime()
        }, 1000)
    }
}


/**
 * 获取短信验证码
 */
function getVerificationCode() {
    var sendRequest = new SendRequest("/login/getVerificationCode","POST");//构造对象
    sendRequest.addParamObj({
        "cPhone":$("#cPhone").val()
    });

    sendRequest.sendRequest(function(ret){
        if("0" != ret.flag){
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "操作失败！"+ret.msg,
                closeable: true,
                buttonLabel: "确定",
                callback: function () {

                }
            });
        }else{
            smsCodeFlag = true;
            //显示倒计时
            countDownTime();
            //显示验证码
            $(".cVerification").show();
        }
    });//发送请求并获取返回结果
}

/**
 * 验证用户输入
 */
function checkRegister(){
    $('#registerForm').bootstrapValidator({
        feedbackIcons: {
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            cPhone: {
                message: '手机号码验证失败',
                validators: {
                    notEmpty: {
                        message: '手机号码不能为空'
                    },
                    regexp: {
                        regexp: /^1[3456789]\d{9}$/,
                        message: '手机号码格式有误'
                    },
                    remote: {
                        url: '/checkForm/checkPhone',//验证地址
                        data:{type:"1",cPhone:$("#cPhone").val()},
                        message: '手机号未被注册,请先注册',//提示消息
                        delay: 2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                        type: 'POST'//请求方式
                    }
                }
            },
            cPassword: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            },
            cPassword1: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'cPassword',
                        message: '两次密码不一致'
                    }
                }
            }
        }
    });
}

/**
 * 验证手机验证码输入是否正确
 */
function f_checkSms(){
    var data = {
        "cPhone":$("#cPhone").val(),
        "smsCode":$("#smsCode").val()
    }
    var options = {
        url : '/login/checkSmsCode',
        type : 'post',
        data : JSON.stringify(data),
        contentType: 'application/json',
        dataType : 'json',
        success: function(ret){
            if("0" != ret.flag){
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "操作失败！"+ret.msg,
                    closeable: true,
                    buttonLabel: "确定",
                    callback: function () {

                    }
                });
            }else{
                $("#cPassword,#cPassword1").val("");
                $(".inputPassword").show();
                $("#btnNext").attr("disabled",false);
            }
        }
    };
    $.ajax(options);//传递参数为json格式，不使用公共调用方式

}


function f_foGetBackPassword(){
    var data = {
        "cPassword":$("#cPassword").val(),
        "cPhone":$("#cPhone").val(),
        "cRylb":'2'
    }
    var options = {
        url : '/login/retWebUserPassowrd',
        type : 'post',
        data : JSON.stringify(data),
        contentType: 'application/json',
        dataType : 'json',
        success: function(ret){
            $("#btnRetPassowrd").attr("disabled",false);
            if("0" != ret.flag){
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "操作失败！"+ret.msg,
                    closeable: true,
                    buttonLabel: "确定",
                    callback: function () {

                    }
                });
            }else{
                window.location.href="/base/tipPage?cPhone="+$("#cPhone").val();
            }
        }
    };
    $.ajax(options);//传递参数为json格式，不使用公共调用方式
}