var grid;
$(function(){
    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){
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
    grid.setHeader("序号,姓名,能量总量,备注");
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
    var data = {
      "cUsername" : $("#cUsername").val(),
      "nNlzlQ" : $("#nNlzlQ").val(),
      "nNlzlZ" : $("#nNlzlZ").val()
    };
    var options = {
        url : '/plate/selectTGreenNlHz',
        type : 'post',
        data : JSON.stringify(data),
        contentType: 'application/json',
        dataType : 'json',
        success: function(ret){
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
        }
    };
    $.ajax(options);//传递参数为json格式，不使用公共调用方式
}

/**
 * 表格赋值
 * @param data
 */
function initData(data){
    for (var i=0; i<data.length; i++){

        grid.addRow((i+1),[
            (i+1),
            data[i].cUsername,
            data[i].nNlhz,
            data[i].cBz
        ]);
        grid.setUserData((i+1),'data',data[i]);
    }
}




