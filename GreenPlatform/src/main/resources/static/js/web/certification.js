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
    var hanReg = /^[\u4e00-\u9fa5]{2,4}$/;
    var phoneReg = /^1[3456789]\d{9}$/;
<<<<<<< HEAD
    var zjhmReg = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;//验证最后一位X
=======
    var zjhmReg = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;
>>>>>>> 88bb2517bb97dc29a343dfccdd5e47433d788a69

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
                        message: '姓名不能为空'
                    },
                    regexp: {
                        regexp: hanReg,
                        message: '姓名为2-4个长度的汉字'
                    }
                }
            },
            cPhone: {
                message: '电话号码验证失败',
                validators: {
                    notEmpty: {
                        message: '电话号码不能为空'
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
                        message: '证件号码格式有误'
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
                    window.location.href = "/base/login";
                }
            });
        }

    });//发送请求并获取返回结果
}