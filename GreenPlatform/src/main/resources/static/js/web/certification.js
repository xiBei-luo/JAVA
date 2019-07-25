$(function(){

    $("#btnCertification").click(function(){
        checkForm();
        $("#dataForm").bootstrapValidator('validate');//提交验证
        if ($("#dataForm").data('bootstrapValidator').isValid()) {
            doCertification();
        }
    });
})


/**
 * 表单验证
 */
function checkForm(){
    var phoneReg = /^1[3456789]\d{9}$/;
    var zjhmReg = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;

    $('#dataForm').bootstrapValidator({
        excluded: [':disabled'],
        feedbackIcons: {
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            cUsername: {
                message: '姓名验证失败',
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    }
                }
            },
            cPhone: {
                message: '电话号码验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    regexp: {
                        regexp: phoneReg,
                        message: '电话号码格式有误'
                    }
                }
            },
            cZjhm: {
                validators: {
                    notEmpty: {
                        message: '证件号码不能为空'
                    },
                    regexp: {
                        regexp: zjhmReg,
                        message: '电话号码格式有误'
                    }
                }
            }
        }
    });
}

/**
 * 提交实名制操作
 */
function doCertification(){
    var sendRequest = new SendRequest("/web/certification","POST");//构造对象
    sendRequest.addParamObj({
        cUsername   :  $.trim($("#cUsername").val()),
        cPhone      :  $.trim($("#cPhone").val()),
        cZjhm       :  $.trim($("#cZjhm").val())
    });//构造请求参数

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
                message: "操作成功",
                closeable: true,
                buttonLabel: "确定",
                callback:function(){
                    window.location.href = "/web/index";
                }
            });
        }

    });//发送请求并获取返回结果
}