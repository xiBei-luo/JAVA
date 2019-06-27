var grid;
$(function(){

    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){

    $("#btnAdd").click(function(){
        var win = top.$.MdiWindow(window, 750, 300, 0, 0, true);
        win.setTitle("新增商品");
        win.setWindowArguments(null);//参数
        win.btnClose(true);
        win.btnMax(false);
        win.btnMin(false);
        win.isResize(false);
        win.onClose(function (ret) {
            if(ret){
                loadGridData();
            }
        });
        win.load("/spgl/edit", window, function (obj) { });
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
    grid.setHeader("操作,商品名称,商品描述,商品价格,商品单位,状态");
    grid.setInitWidthsP("15,10,40,15,10,9.5");
    grid.setColAlign("center,center,center,center,center,center");
    grid.setColTypes("ro,ro,ro,ro,ro,ro");
    grid.enableMultiselect(false);
    grid.init();
}

/**
 * 查询数据
 */
function loadGridData(){
    grid.clearAll();
    var sendRequest = new SendRequest("/plate/selectTGreenSpSpmx","POST");//构造对象
    sendRequest.addParamObj({
        "cSpmc":$("#cSpmcSearch").val()
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
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-primary \" onclick=\"f_upd(\'"+data[i].cSpbh+"\');\" id=\"xg_link_"+data[i].cSpbh+"\" >修改</button>")
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-warning \" onclick=\"f_del(\'"+data[i].cSpbh+"\');\" id=\"del_link_"+data[i].cSpbh+"\" >删除</button>")

        grid.addRow(data[i].cSpbh,[
            opLinkBuff.toString(),
            data[i].cSpmc,
            data[i].cSpms,
            data[i].cSpjg,
            data[i].cSpdw,
            data[i].cZt
        ]);
        grid.setUserData(data[i].cSpbh,'data',data[i]);
    }
}

/*
修改用户,页面赋值
 */
function f_upd(id){
    var data = grid.getUserData(id,"data");
    var win = top.$.MdiWindow(window, 750, 300, 0, 0, true);
    win.setTitle("新增商品");
    win.setWindowArguments(data);//参数
    win.btnClose(true);
    win.btnMax(false);
    win.btnMin(false);
    win.isResize(false);
    win.onClose(function (ret) {
        if(ret){
            loadGridData();
        }
    });
    win.load("/spgl/edit", window, function (obj) { });
}
/*
删除用户
 */
function f_del(id){
    $("#cSpbh").val(id);
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
                f_submitData('2',"/plate/delTGreenSpSpmx");
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
            "cSpmc":$("#cSpmc").val(),
            "cSpjg":$("#cSpjg").val(),
            "cSpms":$("#cSpms").val(),
            "cZt":'1'
        });//构造请求参数
    }else if("1" === type){
        sendRequest.addParamObj({
            "cSpbh":$("#cSpbh").val(),
            "cSpmc":$("#cSpmc").val(),
            "cSpjg":$("#cSpjg").val(),
            "cSpms":$("#cSpms").val(),
            "cZt":'1'
        });//构造请求参数
    }else if("2" === type){
        sendRequest.addParamObj({
            "cSpbh":$("#cSpbh").val()
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
