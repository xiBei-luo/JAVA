var grid;
$(function(){
    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){
    $("#btnReset").click(function(){
        $("#insertPlateUserForm input").val("");
    });
    $("#btnAdd").click(function(){
        $("#cUserid").val("");
        $("#addUserModel").modal('show');
        checkRegister();
    });

    $(".center_main_left").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        if ($(a).attr("href") === location.pathname) {
            $(this).addClass("active");
        } else {
            $(this).removeClass("active");
        }
    });
    $("#btnSearch").click(function(){
        loadGridData();
    });
    $("#btnSave").click(function(){
        if($("#cUserid").val()){
            f_submitData("1","/plate/updPlateuser");
        }else{
            f_submitData("0","/plate/insertPlateuser");
        }

    });

    $("#cUsername,#cPhone").keyup(function(){
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if(keycode == '13'){// 回车触发查询
            $("#btnSearch").triggerHandler("click");
        }
    });
}

/**
 * 初始化表格
 */
function initGrid(){
    grid = new dhtmlXGridObject('gridbox');
    grid.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid.setHeader("操作,姓名,性别,证件号码,人员状态,电话号码,微信号码,QQ号码,状态");
    grid.setInitWidthsP("15,10,6,16,8,11,11,11,11.5");
    grid.setColAlign("center,center,center,center,center,center,center,center,center");
    grid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro,ro");
    grid.enableMultiselect(false);
    grid.init();
}

/**
 * 查询数据
 */
function loadGridData(){
    grid.clearAll();
    var paramObj = {
        "cUsername":$("#cUsernameSearch").val(),
        "cPhone":$("#cPhoneSearch").val()
    };

    var options = {
        url:"/plate/selectPlateuser",
        type:"POST",
        data:paramObj,
        success:function(ret){
            if (ret.flag!=0){
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: ret.msg,
                    closeable: true,
                    buttonLabel: "确定"
                });
            }
            if(ret.object.length > 0){
                $("#commonInfo").hide();
                initData(ret.object);
            }else{
                $("#commonInfo").show();
                $("#commonInfo").text("没有查询结果！");
            }
        }
    };

    $.ajax(options);

}

/**
 * 表格赋值
 * @param data
 */
function initData(data){
    for (var i=0; i<data.length; i++){
        var opLinkBuff = new StringBuffer();
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-primary \" onclick=\"f_upd(\'"+data[i].cUserid+"\');\" id=\"xg_link_"+data[i].cUserid+"\" >修改</button>")
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-warning \" onclick=\"f_del(\'"+data[i].cUserid+"\');\" id=\"del_link_"+data[i].cUserid+"\" >删除</button>")

        grid.addRow(data[i].cUserid,[
            opLinkBuff.toString(),
            data[i].cUsername,
            data[i].cSex,
            data[i].cZjhm,
            data[i].cRyzt,
            data[i].cPhone,
            data[i].cWxhm,
            data[i].cQq,
            data[i].cZt
        ]);
        grid.setUserData(data[i].cUserid,'data',data[i]);
    }
}

/**
 * 验证新增用户表单
 */
function checkRegister(){
    $('#insertPlateUserForm').bootstrapValidator({
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
            }/*,
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
            }*/
        }
    });
}


/**
 * 发送请求保存数据
 * type:操作类型，0新增/1修改/2删除
 */
function f_submitData(type,reqURL){
    var paramObj;
    if ("0" === type) {
        paramObj = {
            "cUsername":$("#cUsername").val(),
            "cSex":$("#cSex").val(),
            "cEmail":$("#cEmail").val(),
            "cPhone":$("#cPhone").val(),
            "cWxhm":$("#cWxhm").val(),
            "cZjhm":$("#cZjhm").val(),
            "cLoginname":$("#cLoginname").val(),
            "cRylb":$("#cRylb").val(),
            "cPassword":$("#cPassword").val(),
            "cZt":'1',
        };
    }else if("1" === type){
        paramObj = {
            "cUserid":$("#cUserid").val(),
            "cUsername":$("#cUsername").val(),
            "cSex":$("#cSex").val(),
            "cEmail":$("#cEmail").val(),
            "cPhone":$("#cPhone").val(),
            "cWxhm":$("#cWxhm").val(),
            "cZjhm":$("#cZjhm").val(),
            "cLoginname":$("#cLoginname").val(),
            "cRylb":$("#cRylb").val(),
            "cPassword":$("#cPassword").val(),
            "cZt":'1',
        };
    }else if("2" === type){
        paramObj = {
            "cUserid":$("#cUserid").val()
        };
    }
    var options = {
        url:reqURL,
        type:"POST",
        data:paramObj,
        success:function(ret){
            console.log(ret);
            if("0" != ret.flag){
                $("#btnSave").attr("disabled",false);
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
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "操作成功",
                    closeable: true,
                    buttonLabel: "确定"
                });
                $("#btnRet,#btnReset").click();
                loadGridData();
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

    $("#insertPlateUserForm").bootstrapValidator('validate');//提交验证

    if ($("#insertPlateUserForm").data('bootstrapValidator').isValid()) {
        $.ajax(options);
    }
}

/*
修改用户,页面赋值
 */
function f_upd(id){
    $("#btnAdd").click();
    var data = grid.getUserData(id,"data");
    setInputArea(nullToEmptyForObject(data));
    $("#cPassword,#cPassword1").hide();
}
/*
删除用户
 */
function f_del(id){
    $("#cUserid").val(id);
    BootstrapDialog.confirm({
        type: BootstrapDialog.TYPE_DANGER,
        size: BootstrapDialog.SIZE_SMALL,
        title: '提示',
        message: "确认删除吗！",
        closeable: true,
        btnOKLabel: "确定",
        btnCancelLabel: "取消",
        callback: function (ret) {
            if(ret){
                f_submitData('2',"/plate/delPlateuser");
            }
        }
    });
}

/**
 *
 * 初始化下拉框
 */
function initSelect(){
    console.log(initBaseCodeSelect($("#cSex"),{C_DMFL:"C_USER_SEX"},null,null));
}



/**
 * 1、初始化基础代码下拉列表：同步
 * @param $container 下拉列表
 * @param args 调用过程参数
 * @param defVal 默认选中值
 * @param allFlag 显示全部时的字符
 */
function initBaseCodeSelect($container, args, defVal, allFlag){
    if($container){
        $container.empty();
    }

    var option_data = [];
    var ajax = new AjaxProxy();
    ajax.setCacheData(false);

    ajax.addParm("PC_DMFL", args.C_DMFL);  //代码分类
    ajax.addParm("PC_DM", args.C_DM ? args.C_DM : "");  //代码值 （空值则全部该代码分类的全部数据）
    ajax.addParm("PC_DWDM", args.C_DWDM ? args.C_DWDM : "");  //单位代码（空值则查询全部）
    ajax.addParm("PC_CS1", args.C_CS1 ? args.C_CS1 : ""); //参数，eg 为1时：工序过滤掉“成品退库”和“对外加工”序
    ajax.invokeProc("APPUSER.CTRI_PUB.PW_CTRI_PUB_DM", false);

    var row=ajax.getRowCount("P_RESULT");

    if($container){
        try{
            $container.combobox("loadData",[[null,null]]);
        }catch(e){

        }
    }
    if(row>0){
        if($container){
            if(allFlag){
                $container.append("<option value=''>"+allFlag+"</option>");
            }else if("" == allFlag){
                $container.append("<option value=''>&nbsp;</option>");
            }
        }

        for(var i=1;i<=row;i++){

            var data={
                C_DM    : ajax.getString("P_RESULT",i,"C_DM"),
                C_MC    : ajax.getString("P_RESULT",i,"C_MC"),
                N_SORT	: ajax.getString("P_RESULT",i,"N_SORT")
            };
            //预留两个字段
            var sSm1 = ajax.getString("P_RESULT",i,"C_SM1");
            if(typeof sSm1 == "undefined" ){
                sSm1 = "";
            }
            data.C_SM1 = sSm1;

            var sSm2 = ajax.getString("P_RESULT",i,"C_SM2");
            if(typeof sSm2 == "undefined" ){
                sSm2 = "";
            }
            data.C_SM2 = sSm2;

            //2019-04-03 增加：约定,如果js没有设置默认选中值时，将N_SORT = 0设为默认选中值
            if(defVal == null && typeof data.N_SORT != "undefined" && data.N_SORT == "0"){
                defVal = data.C_DM;
            }

            if("SCGX" == args.C_DMFL){//工序下拉框，产品状态 、是否涂层检验
                var cpzt = ajax.getString("P_RESULT",i,"C_CPZT");
                var sftcjy = ajax.getString("P_RESULT",i,"C_SFTCJY"); //是否涂层检验【0：否，1：是】
                data.C_CPZT	  = cpzt;
                data.C_SFTCJY = sftcjy;
                if($container){
                    $container.append("<option sx1='"+cpzt+"' value='"+data.C_DM+"' text='"+data.C_MC+"'>"+data.C_MC+"</option>");
                }

            }else if("SL" == args.C_DMFL){
                if($container){
                    $container.append("<option value='"+data.C_DM+"'>"+data.C_MC+"&nbsp;"+data.C_DM+"</option>");
                }
            }else{
                if($container){
                    $container.append("<option value='"+data.C_DM+"' text='"+data.C_MC+"'>"+data.C_MC+"</option>");
                }
            }
            option_data.push(data);
        }

        if(defVal && $container){
            $("option[value='"+defVal+"']", $container).attr({selected: true});
        }
    }


    return option_data;
}
