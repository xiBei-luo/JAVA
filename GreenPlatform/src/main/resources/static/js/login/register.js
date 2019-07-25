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

    $("#btnRegister").click(function(){
        checkRegister();
        $("#registerForm").bootstrapValidator('validate');//提交验证
        if ($("#registerForm").data('bootstrapValidator').isValid()) {
            f_submitData();
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
    var sendRequest = new SendRequest("/login/register","POST");//构造对象
    sendRequest.addParamObj({
        "cEmail":$("#cEmail").val(),
        "cLoginname":$("#cLoginname").val(),
        "cPassword":$("#cPassword").val(),
        "cRylb":'2'
    });

    sendRequest.sendRequest(function(ret){
        $("#btnRegister").attr("disabled",false);
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
            BootstrapDialog.confirm({
                type: BootstrapDialog.TYPE_PRIMARY,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "操作成功！"+ret.msg,
                closeable: true,
                btnOKLabel: "确定",
                btnCancelLabel: "留在当前页面",
                callback: function (ret) {
                    if(ret){
                        window.location.href="/web/index";
                    }
                }
            });
        }
    });//发送请求并获取返回结果

}