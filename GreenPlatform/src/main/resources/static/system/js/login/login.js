$(function(){
    checkLogin();

    initEvent();

});


function initEvent(){
    $("#btnLogin").click(function(){
        checkLogin();
        $("#loginForm").bootstrapValidator('validate');//提交验证

        if ($("#loginForm").data('bootstrapValidator').isValid()) {
            f_submitData();
        }
    });
    $("#btnLogin").keyup(function(){
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if(keycode == '13'){// 回车触发事件
            $("#btnLogin").click();
        }
    });
}

function checkLogin(){
    $('#loginForm').bootstrapValidator({
        excluded: [':disabled'],
        feedbackIcons: {
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
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
                    }
                }
            },
            cPassword: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    });
}

function f_submitData(){
    var sendRequest = new SendRequest("/system/login","POST");//构造对象
    sendRequest.addParamObj({
        "cLoginname":$("#cLoginname").val(),
        "cPassword":$("#cPassword").val()
    });//构造请求参数
    sendRequest.sendRequest(function(ret){
        $("#btnLogin").attr("disabled",false);
        if("0" != ret.flag){
            $("#btnLogin").attr("disabled",false);
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '登陆失败',
                message: ret.msg,
                closeable: true,
                buttonLabel: "确定"
            });
        }else{
            window.location.href="/system/index";
        }
    });//发送请求并获取返回结果
}