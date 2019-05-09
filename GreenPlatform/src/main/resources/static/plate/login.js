$(function(){
    //initEvent();
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        submitHandler: function (validator, form, submitButton) {
            // 表单提交成功时会调用此方法
            // validator: 表单验证实例对象
            // form  jq对象  指定表单对象
            // submitButton  jq对象  指定提交按钮的对象
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
                    },
                    remote: { // ajax校验，获得一个json数据（{'valid': true or false}）
                        url: '/plate/selectUserByEmail',       //验证地址
                        message: '邮箱已经被注册',   //提示信息
                        type: 'POST',          //请求方式
                        delay: 2000,
                        data: function(validator){  //自定义提交数据，默认为当前input name值
                            return {
                                act: 'is_registered',
                                cEmail: $("input[name='cEmail']").val()
                            };
                        }
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
                        min: 6,
                        max: 18,
                        message: '用户名长度必须在6到18位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    },
                    remote: { // ajax校验，获得一个json数据（{'valid': true or false}）
                        url: '/plate/selectUserByLoginname',       //验证地址
                        message: '用户已存在',   //提示信息
                        type: 'POST',          //请求方式
                        delay: 2000,
                        data: function(validator){  //自定义提交数据，默认为当前input name值
                            return {
                                act: 'is_registered',
                                cLoginname: $("input[name='cLoginname']").val()
                            };
                        }
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
})

