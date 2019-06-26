var grid;
$(function(){
    load("#headerNav","/base/header");
    load("#footer","/base/footer");
    load("#center_main_left","/base/menu");
    load("#addJcdmModel","/base/addJcdmModel");

    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){
    initSelect();
    $("#btnAdd").click(function(){
        $("#addJcdmModel").modal('show');
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
    grid.setHeader("操作,代码类别,代码类别名称,代码值,代码值名称,排序号,状态");
    grid.setInitWidthsP("15,15,15,15,15,10,14.5");
    grid.setColAlign("center,center,center,center,center,center,center");
    grid.setColTypes("ro,ro,ro,ro,ro,ro,ro");
    grid.enableMultiselect(false);
    grid.init();
}

/**
 * 查询数据
 */
function loadGridData(){
    grid.clearAll();
    var sendRequest = new SendRequest("/plate/selectPlateCodeDmz","POST");//构造对象
    sendRequest.addParamObj({
        "cDmlb":$("#cDmlbSeatch").val(),
        "cDm":$("#cDmSearch").val()
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
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-primary \" onclick=\"f_upd(\'"+(i+1)+"\');\" id=\"xg_link_"+(i+1)+"\" >修改</button>")
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-warning \" onclick=\"f_del(\'"+(i+1)+"\');\" id=\"del_link_"+(i+1)+"\" >删除</button>")

        grid.addRow((i+1),[
            opLinkBuff.toString(),
            data[i].cDmlb,
            data[i].cDmlbmc,
            data[i].cDm,
            data[i].cDmmc,
            data[i].cSort,
            data[i].cZt
        ]);
        grid.setUserData((i+1),"data",data[i]);
    }
}


/*
修改用户,页面赋值
 */
function f_upd(id){
    console.log(id);
    var data = grid.getUserData(id,"data");
    console.log(data);
    $("#btnAdd").click();//触发新增按钮点击事件（设置人员id为空，清空输入框，打开模态框，初始化下拉框）
    $("#myModalLabel").html("修改基础代码");
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
    initBaseCodeSelect($("#cZt"),{cDmlb:"C_JC_ZT"},null,"---请选择状态---")
}


