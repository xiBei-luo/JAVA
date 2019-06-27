var grid;
$(function(){

    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){
    initBaseCodeSelect($("#cRylb"),{cDmlb:"C_USER_RYLB"},null,null);

    $("#btnAdd").click(function(){
       var win = top.$.MdiWindow(window, 900, 500, 0, 0, true);
        win.setTitle("新增系统用户");
        win.setWindowArguments("张三");//参数
        win.btnClose(true);
        win.btnMax(false);
        win.btnMin(false);
        win.isResize(false);
        win.onClose(function (ret) {

        });
        win.load("/yhgl/edit", window, function (obj) { });
    });

    $("#btnSearch").click(function(){
        loadGridData();
    });
}

/**
 * 初始化表格
 */
function initGrid(){
    $("#gridbox").attr({width:"100%",height:"100%"});
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
    var sendRequest = new SendRequest("/plate/selectPlateuser","POST");//构造对象
    sendRequest.addParamObj({
        "cRylb":$("#cRylb").val(),
        "cUsername":$("#cUsername").val(),
        "cPhone":$("#cPhone").val()
    });//构造请求参数

    sendRequest.sendRequest(function(ret){
        if(ret.flag != "0"){
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "查询出错,系统错误！",
                closeable: true,
                buttonLabel: "确定"
            });
        }else{
            if(ret.object.length > 0){
                $("#commonInfo").hide();
                initData(ret.object);
            }else{
                $("#commonInfo").show();
                $("#commonInfo").text("没有查询结果！");
            }
        }
    });//发送请求并获取返回结果
}

/**
 * 表格赋值
 * @param data
 */
function initData(data){
    for (var i=0; i<data.length; i++){
        var opLinkBuff = new StringBuffer();
        if ("1" == data[i].cRylb){
            opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-primary \" onclick=\"f_upd(\'"+data[i].cUserid+"\');\" id=\"xg_link_"+data[i].cUserid+"\" >重置密码</button>")
            opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-warning \" onclick=\"f_del(\'"+data[i].cUserid+"\');\" id=\"del_link_"+data[i].cUserid+"\" >删除</button>")
        }

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
/*
重置密码
 */
function f_upd(id){
    $("#cUserid").val(id);
    BootstrapDialog.confirm({
        type: BootstrapDialog.TYPE_DANGER,
        size: BootstrapDialog.SIZE_SMALL,
        title: '提示',
        message: "确认重置用户密码吗！",
        closeable: true,
        btnOKLabel: "确定",
        btnCancelLabel: "取消",
        callback: function (ret) {
            if(ret){
                f_submitData('1',"/plate/retsetPass");//此方法定义在addUserModel中
            }
        }
    });
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
 * 发送请求保存数据
 * type:操作类型，0新增/1修改/2删除
 * reqURL：服务地址
 */
function f_submitData(type,reqURL){
    var sendRequest = new SendRequest(reqURL,"POST");//构造对象

    if ("0" === type) {
        sendRequest.addParamObj({
            "cUsername":$("#cUsername").val(),
            "cSex":$("#cSex").val(),
            "cEmail":$("#cEmail").val(),
            "cPhone":$("#cPhone").val(),
            "cWxhm":$("#cWxhm").val(),
            "cZjhm":$("#cZjhm").val(),
            "cLoginname":$("#cLoginname").val(),
            "cRylb":'1',
            "cPassword":$("#cPassword").val(),
            "cZt":'1',
        });//构造请求参数
    }else if("1" === type){
        sendRequest.addParamObj({
            "cUserid":$("#cUserid").val(),
            "cUsername":$("#cUsername").val(),
            "cSex":$("#cSex").val(),
            "cEmail":$("#cEmail").val(),
            "cPhone":$("#cPhone").val(),
            "cWxhm":$("#cWxhm").val(),
            "cZjhm":$("#cZjhm").val(),
            "cLoginname":$("#cLoginname").val(),
            "cRylb":'1',
            "cPassword":$("#cPassword").val(),
            "cZt":'1'
        });//构造请求参数
    }else if("2" === type){
        sendRequest.addParamObj({
            "cUserid":$("#cUserid").val()
        });//构造请求参数
    }

    sendRequest.sendRequest(function(ret){
        $("#btnSave").attr("disabled",false);
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
                buttonLabel: "确定"
            });
            $("#btnRet,#btnReset").click();
            loadGridData();
        }
    });//发送请求并获取返回结果
}
