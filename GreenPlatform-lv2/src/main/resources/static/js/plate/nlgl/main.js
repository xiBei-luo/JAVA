var grid;
$(function(){
    initEvent();
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
 * 查询数据
 */
function loadGridData(){
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
        $("#dataTbl tbody").append("<tr>" +
            "<td>"+(i+1)+"</td>" +
            "<td>"+data[i].cUsername+"</td>" +
            "<td>"+data[i].nNlhz+"</td>" +
            "<td>"+data[i].cBz+"</td>" +
            "</tr>");
    }
}




