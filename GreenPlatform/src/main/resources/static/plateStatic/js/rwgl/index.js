var grid;
$(function(){
    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){
    initSelect();
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
    grid = new dhtmlXGridObject('gridbox');
    grid.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid.setHeader("序号,姓名,任务类别,任务完成时间,备注");
    grid.setInitWidthsP("10,25,20,20,24.5");
    grid.setColAlign("center,center,center,center,left");
    grid.setColTypes("ro,ro,ro,ro,ro");
    grid.enableMultiselect(false);
    grid.init();
}

/**
 * 查询数据
 */
function loadGridData(){
    grid.clearAll();
    var sendRequest = new SendRequest("/plate/selectTGreenRwRwmx","POST");//构造对象
    sendRequest.addParamObj({
        "cUsername":$("#cUsernameSearch").val(),
        "cRwlb":$("#cRwlbSearch").val()
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

        grid.addRow((i+1),[
            (i+1),
            data[i].cUserid,
            data[i].cRwlb,
            data[i].cRwsj,
            data[i].cBz
        ]);
        grid.setUserData((i+1),'data',data[i]);
    }
}


/**
 *
 * 初始化下拉框
 */
function initSelect(){
    initBaseCodeSelect($("#cRwlbSearch"),{cDmlb:"C_RW_RWLB"},null,"---请选择任务类别---");
    $("#cRwlbSearch").change(function () {
        grid.clearAll();
    });
}


