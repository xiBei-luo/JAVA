$(function () {
    checkRegister();

    initEvent();
});


function initEvent(){
    $("#btnRegister").click(function(){
        f_submitData();
    });
    $("#btnRegister").keyup(function(){
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if(keycode == '13'){// 回车触发事件
            $("#btnRegister").click();
        }
    });
}


function checkRegister(){
    $('#registerForm').bootstrapValidator({
        excluded: [':disabled'],
        feedbackIcons: {
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            cEmail: {
                message: '邮箱验证失败',
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
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
    var paramObj = {
        "cEmail":$("#cEmail").val(),
        "cLoginname":$("#cLoginname").val(),
        "cPassword":$("#cPassword").val()
    };
    var options = {
        url:"/system/register",
        type:"POST",
        data:paramObj,
        success:function(ret){
            console.log(ret);
            if("0" != ret.flag){
                $("#btnRegister").attr("disabled",false);
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '注册失败',
                    message: ret.msg,
                    closeable: true,
                    buttonLabel: "确定"
                });
            }else{
                window.location.href="/system/index";
            }
        },
        error:function(){
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "系统错误！",
                closeable: true,
                buttonLabel: "确定"
            });
        }
    };

    $("#registerForm").bootstrapValidator('validate');//提交验证

    if ($("#registerForm").data('bootstrapValidator').isValid()) {
        $.ajax(options);
    }
}