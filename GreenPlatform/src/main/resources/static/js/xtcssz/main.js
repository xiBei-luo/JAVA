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
        win.setTitle("新增系统参数");
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
        win.load("/xtcssz/edit", window, function (obj) { });
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
    grid.setHeader("操作,参数代码,参数值,备注,状态");
    grid.setInitWidthsP("20,20,20,20,19.5");
    grid.setColAlign("center,center,center,left,center");
    grid.setColTypes("ro,ro,ro,ro,ro");
    grid.enableMultiselect(false);
    grid.init();
}

/**
 * 查询数据
 */
function loadGridData(){
    grid.clearAll();
    var sendRequest = new SendRequest("/plate/selectPlateCodeXtcs","POST");//构造对象
    sendRequest.addParamObj({
        "cKey":$("#cKey").val()
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
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-primary \" onclick=\"f_upd(\'"+data[i].cKey+"\');\" id=\"xg_link_"+(i+1)+"\" >修改</button>&nbsp&nbsp&nbsp&nbsp&nbsp")
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-warning \" onclick=\"f_del(\'"+data[i].cKey+"\');\" id=\"del_link_"+(i+1)+"\" >删除</button>")

        grid.addRow(data[i].cKey,[
            opLinkBuff.toString(),
            data[i].cKey,
            data[i].cValue,
            data[i].cBz,
            data[i].cZt == '1' ? '有效' : '无效'
        ]);
        grid.setUserData(data[i].cKey,"data",data[i]);
    }
}

/*
修改用户,页面赋值
 */
function f_upd(id){
    var data = grid.getUserData(id,"data");
    var win = top.$.MdiWindow(window, 750, 300, 0, 0, true);
    win.setTitle("修改系统参数");
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
    win.load("/xtcssz/edit", window, function (obj) { });
}
/*
删除
 */
function f_del(id){
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
                f_submitData('2',"/plate/delPlateCodeXtcs",id);
            }
        }
    });
}

/**
 * 发送请求保存数据
 * type:操作类型，0新增/1修改/2删除
 * reqURL：服务地址
 * data：业务数据
 */
function f_submitData(type,reqURL,id){
    var sendRequest = new SendRequest(reqURL,"POST");//构造对象

    sendRequest.addParamObj({
        "cKey"     : id
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
                callback: function () {
                    loadGridData();
                }
            });
        }
    });//发送请求并获取返回结果
}
