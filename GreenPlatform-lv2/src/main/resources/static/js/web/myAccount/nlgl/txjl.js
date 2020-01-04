$(function(){
    //var currentYear = new Date().getFullYear();//当前年份
    //var currentMouth = new Date().getMonth()+1;//当前月份


    //$("#cMonth").val(currentYear+"-"+currentMouth);
    $("#loginoutBtn").click(function(){
        //window.parent.location整个页面跳转
        window.parent.location = "/base/loginout";
    });

    $("#btnSearch").click(function(){
        loadGridData("/web/selectTGreenNlTxjl");
    });
});


//检索数据
function loadGridData(reqUrl){
    $(".table tbody tr").remove();
    var data = {
        "cMonth":$("#cMonth").val()
    };

    var options = {
        url : reqUrl,
        type : 'post',
        data : JSON.stringify(data),
        contentType: 'application/json',
        dataType : 'json',
        success: function(ret){
            if("0" != ret.flag){
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "查询出错！"+ret.msg,
                    closeable: true,
                    buttonLabel: "确定",
                    callback: function () {

                    }
                });
            }else{
                if(ret.object.length > 0){
                    $("#commonInfo").hide();
                    var data = ret.object;

                    for (var i=0; i<data.length; i++){
                        $(".table tbody").append(
                            "<tr>" +
                            "<td>"+data[i].dSksj+"</td>" +
                            "<td>"+data[i].nFknl+"</td>" +
                            "<td>"+data[i].nSkje+"</td>" +
                            "<td>"+data[i].cFkzh+"</td>" +
                            "<td>"+(data[i].cSksfcg == '1' ? '成功' : '失败')+"</td>" +
                            "</tr>");
                    }

                }else{
                    $("#commonInfo").show();
                    $("#commonInfo").text("没有查询结果！");
                }
            }
        }
    };
    $.ajax(options);
}




