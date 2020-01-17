var grid;
var pagerbar;
var gPageSize = 20;//每页显示数量
$(function(){
    initPagerBar();//初始化分页控件
    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){

    $("#btnAdd").click(function(){
       var win = top.$.MdiWindow(window, 500, 350, 0, 0, true);
        win.setTitle("新增系统用户角色");
        win.setWindowArguments(null);//参数
        win.btnClose(true);
        win.btnMax(false);
        win.btnMin(false);
        win.isResize(false);
        win.onClose(function (ret) {
            if (ret){
                loadGridData(-1);
            }
        });
        win.load("/qxgl/edit", window, function (obj) { });
    });

    $("#btnSearch").click(function(){
        loadGridData(-1);
    });
}

/**
 * 初始化表格
 */
function initGrid(){
    $("#gridbox").attr({width:"100%",height:"100%"});
    grid = new dhtmlXGridObject('gridbox');
    grid.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid.setHeader("操作,角色标识符,角色名,状态");
    grid.setInitWidthsP("25,25,25,24.5");
    grid.setColAlign("center,center,center,center,center");
    grid.setColTypes("ro,ro,ro,ro,ro");
    grid.enableMultiselect(false);
    grid.init();
}

/**
 * 查询数据
 */
function loadGridData(page){
    grid.clearAll();
    var sendRequest = new SendRequest("/plate/selectPlateUserRole","POST");//构造对象
    sendRequest.addParamObj({
        "pageNum":page,
        "pageSize":gPageSize,
        "cRolename":$("#cRolename").val()
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
            var pages = ret.object.pages;
            var totalRows = ret.object.totalRows;

            if(page <= 0){
                //设置总页数
                pagerbar.setPageSize(pages * 1);
                //设置总条数
                pagerbar.setTotalCount(totalRows * 1);
            }



            if(ret.object.retDatas.length > 0){
                $("#commonInfo").hide();
                initData(ret.object.retDatas);
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
        opLinkBuff.append("<a class=\"btn-link \" onclick=\"f_upd(\'"+data[i].cRole+"\');\"  >修改</a>&nbsp&nbsp");
        opLinkBuff.append("<a class=\"btn-link \" onclick=\"f_del(\'"+data[i].cRole+"\');\"  >删除</a>&nbsp&nbsp");
        opLinkBuff.append("<a class=\"btn-link \" onclick=\"f_roleGrant(\'"+data[i].cRole+"\');\"  >角色授权</a>&nbsp&nbsp");
        opLinkBuff.append("<a class=\"btn-link \" onclick=\"f_grantUser(\'"+data[i].cRole+"\');\"  >授予用户</a>");


        grid.addRow(data[i].cRole,[
            opLinkBuff.toString(),
            data[i].cRole,
            data[i].cRolename,
            data[i].cZt == "1" ? "有效" : "无效"
        ]);
        grid.setUserData(data[i].cRole,'data',data[i]);
    }
}

/**
 * 修改角色
 * @param id
 */
function f_upd(id){
    var data = grid.getUserData(id,"data");
    var win = top.$.MdiWindow(window, 500, 350, 0, 0, true);
    win.setTitle("修改系统用户角色");
    win.setWindowArguments(data);//参数
    win.btnClose(true);
    win.btnMax(false);
    win.btnMin(false);
    win.isResize(false);
    win.onClose(function (ret) {
        if (ret){
            loadGridData();
        }
    });
    win.load("/qxgl/edit", window, function (obj) { });
}
/*
角色授权
 */
function f_roleGrant(id){
    var data = grid.getUserData(id,"data");
    var win = top.$.MdiWindow(window, 900, 400, 0, 0, true);
    win.setTitle("角色【"+data.cRolename+"】授权");
    win.setWindowArguments(data);//参数
    win.btnClose(true);
    win.btnMax(false);
    win.btnMin(false);
    win.isResize(false);
    win.onClose(function (ret) {
        if (ret){
            loadGridData();
        }
    });
    win.load("/qxgl/jssq?cRole="+id, window, function (obj) { });
}
/*
角色授予用户列表
 */
function f_grantUser(id){
    var data = grid.getUserData(id,"data");
    var win = top.$.MdiWindow(window, 900, 500, 0, 0, true);
    win.setTitle("角色【"+data.cRolename+"】授予用户");
    win.setWindowArguments(data);//参数
    win.btnClose(true);
    win.btnMax(false);
    win.btnMin(false);
    win.isResize(false);
    win.onClose(function (ret) {
        if (ret){
            loadGridData();
        }
    });
    win.load("/qxgl/syyh?cRole="+id, window, function (obj) { });
}


/*
删除用户
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
                f_submitData('2',"/plate/delPlateUserRole",id);
            }
        }
    });
}

/**
 * 发送请求保存数据
 * type:操作类型，2删除/3重置密码
 * reqURL：服务地址
 * id：用户参数
 */
function f_submitData(type,reqURL,id){
    var sendRequest = new SendRequest(reqURL,"POST");//构造对象

    if("2" === type){
        sendRequest.addParamObj({
            "cRole":id
        });//构造请求参数
    }

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
                callback: function(){
                    loadGridData(-1);
                }
            });
        }
    });//发送请求并获取返回结果
}

/**
 * 初始化分页工具条
 */
function initPagerBar(){
    pagerbar = new PagerBar({
        scaleBgColor:"#f9f9f9",      //页码容器背景颜色
        scaleBorderColor:"#eaeaea",  //页码容器边框颜色
        textColor:"#00aaee",         //页码容器中文字颜色和当前选中的页码容器背景色
        text_clickedColor:"#ffffff", //选中页码容器中的文本颜色

        showScaleSize:7,             //页码容器的个数，可不设置，默认为7个，如果页码pageSize小于页码容器个数，将页码赋值给页码容器个数
        scaleLen:29,                 //页码容器边长，可不设置，默认为29px;
        pageSize:1,                  //页码大小，必须设置
        pageListSize : gPageSize,     //每页列表显示记录条数
        renderTo:document.getElementById("pagerbar"),  //要将页码控件渲染到哪个容器中
        clickEvent:function(page){ //点击页码事件, 参数为currentPage,当前页
            loadGridData(page);
        },
        pageListSizeEvent: function(){//输入每页显示记录数后回车触发
            loadGridData(-1);
        }
    });
}