var wait = 60;
var smsCodeFlag = false;
$(function () {
    checkRegister();

    initEvent();

});


function initEvent(){

    $(document).keyup(function(event){
        if(event.keyCode ==13){
            $("#btnRegister").trigger("click");
        }
    });

    $("#getVerificationCode").click(function () {
        //checkRegister();
        $("#registerForm").bootstrapValidator('validate');//提交验证
        if ($("#registerForm").data('bootstrapValidator').isValid()) {
            //调用短信接口发送验证码
            getVerificationCode();
        }

    });

    $("#btnRegister").click(function(){
        //checkRegister();
        $("#registerForm").bootstrapValidator('validate');//提交验证
        if ($("#registerForm").data('bootstrapValidator').isValid()) {
            if ($("#btnAgreeRule").prop("checked")) {
                if (smsCodeFlag){
                    f_submitData();
                }else{
                    BootstrapDialog.alert({
                        type: BootstrapDialog.TYPE_WARNING,
                        size: BootstrapDialog.SIZE_SMALL,
                        title: '提示',
                        message: "请先输入短信验证码！",
                        closeable: true,
                        buttonLabel: "确定",
                        callback: function () {
                            $("#btnRegister").attr("disabled",false);
                        }
                    });
                    return;
                }
            }else{
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "请先阅读并同意《法律声明及平台服务条款》",
                    closeable: true,
                    buttonLabel: "确定",
                    callback: function () {
                        $("#btnRegister").attr("disabled",false);
                    }
                });
                return;
            }
        }
    });
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
    $("#btnRegister").attr("disabled",false);
    var sendRequest = new SendRequest("/login/getVerificationCode","POST");//构造对象
    sendRequest.addParamObj({
        "cLoginname":$("#cLoginname").val(),
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
        excluded: [':disabled'],
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
                        data:{cPhone:$("#cPhone").val()},
                        message: '手机号已被注册',//提示消息
                        delay: 2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                        type: 'POST'//请求方式
                    }
                }
            },
            cLoginname: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 18,
                        message: '用户名长度必须在3到18位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    },
                    remote: {
                        url: '/checkForm/checkLoginname',//验证地址
                        data:{cLoginname:$("#cLoginname").val()},
                        message: '用户名已被注册',//提示消息
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
                    },
                }
            }
        }
    });
}

function f_submitData(){
    var data = {
        "cYqm":$("#cYqm").val(),
        "cPhone":$("#cPhone").val(),
        "cLoginname":$("#cLoginname").val(),
        "cPassword":$("#cPassword").val(),
        "smsCode":$("#smsCode").val(),
        "cRylb":'2'
    }
    var options = {
        url : '/login/register',
        type : 'post',
        data : JSON.stringify(data),
        contentType: 'application/json',
        dataType : 'json',
        success: function(ret){
            $("#btnRegister").attr("disabled",false);
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
                BootstrapDialog.confirm({
                    type: BootstrapDialog.TYPE_PRIMARY,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "操作成功！",
                    closeable: true,
                    btnOKLabel: "确定",
                    btnCancelLabel: "留在当前页面",
                    callback: function (ret) {
                        if(ret){
                            window.location.href="/web/welcome";
                        }
                    }
                });
            }
        }
    };
    $.ajax(options);//传递参数为json格式，不使用公共调用方式

}

function getParam(paramName) {
    paramValue = "", isFound = !1;
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
    }
    return paramValue == "" && (paramValue = null), paramValue
}