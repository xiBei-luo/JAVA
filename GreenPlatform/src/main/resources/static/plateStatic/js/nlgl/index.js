var grid;
$(function(){
    load("#headerNav","/base/header");
    load("#footer","/base/footer");
    load("#center_main_left","/base/menu");

    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){
    initMenu();

    $("#btnSearch").click(function(){
        loadGridData();
    });
}

function initMenu(){
    $(".center_main_left").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        if ($(a).attr("href") === location.pathname) {
            $(this).addClass("active");
        } else {
            $(this).removeClass("active");
        }
    });
}

/**
 * 初始化表格
 */
function initGrid(){
    $("#gridbox").attr({width:"100%",height:"100%"});
    grid = new dhtmlXGridObject('gridbox');
    grid.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid.setHeader("姓名,能量总量,备注,状态");
    grid.setInitWidthsP("25,25,25,24.5");
    grid.setColAlign("center,center,center,center");
    grid.setColTypes("ro,ro,ro,ro");
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
        "cUsername":$("#cUsernameSearch").val()
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

        grid.addRow(data[i].cUserid,[
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

