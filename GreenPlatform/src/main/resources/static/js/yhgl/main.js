var grid;
$(function(){

    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){
    initBaseCodeSelect($("#cRydj"),{cDmlb:"C_USER_RYDJ"},null,"全部");

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
    grid.setHeader("序号,姓名,性别,证件号码,人员性质,人员状态,账户等级,注册方式,账户总能量");
    grid.setInitWidthsP("11,10,6,20,8,11,11,11,11.5");
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
    var sendRequest = new SendRequest("/plate/selectWebUser","POST");//构造对象
    sendRequest.addParamObj({
        "cRydj":$("#cRydj").val(),
        "cUsername":$("#cUsername").val(),
        "cZjhm":$("#cZjhm").val()
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
            (i+1),
            data[i].cUsername,
            data[i].cSex,
            data[i].cZjhm,
            data[i].cRyxzsm,
            data[i].cRyztsm,
            data[i].cRydj,
            data[i].cZcfssm,
            data[i].cNlhz
        ]);
        grid.setUserData(data[i].cUserid,'data',data[i]);
    }
}
