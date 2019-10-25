var grid1,grid2,grid3;
var tmpClickLink;
$(function(){
    var curentLink = getQueryString("type");
    if(3 == curentLink){
        $("#cTxls").attr("class","loadGrid active");
        $("#gridbox_cTxls").show();
    }else if(2 == curentLink){
        $("#cCzls").attr("class","loadGrid active");
        $("#gridbox_cCzls").show();
    }else{
        $("#cJzjl").attr("class","loadGrid active");
        $("#gridbox_cJzjl").show();
    }
    tmpClickLink = $($(".loadGrid[class~='active']")).prop("id");//当前选中项
    initEvent();
    initGrid();
})

function initEvent() {
    $(".navbar-nav li").click(function(){
        $(".navbar-nav li").removeClass("active");
        $(this).addClass("active");
    });

    $(".loadGrid").click(function () {
        tmpClickLink = $($(".loadGrid[class~='active']")).prop("id");//当前选中项
        $(".gridbox").hide();
        $("#gridbox_"+this.id).show();
    });

    $("#dKssj").val("2019-01-01");

    $("#perInfo").click(function () {
        $("#perInfoModel").modal('show');
    });

    $("#btnReset").click(function(){
        $("#perInfoForm input,#perInfoForm textarea").val("");
    });

    $("#btnSearch").click(function(){
        if("cJzjl" == tmpClickLink){
            loadGridData("/web/selectTGreenZzJzjl");
        }else if("cCzls" == tmpClickLink){
            loadGridData("/web/selectTGreenNlCzjl");
        }else if("cTxls" == tmpClickLink){
            loadGridData("/web/selectTGreenNlTxjl");
        }
    });

}

/**
 * 初始化表格
 */
function initGrid(){
    $(".gridbox").attr({width:"100%",height:"100%"});
    grid1 = new dhtmlXGridObject('gridbox_cJzjl');
    grid1.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid1.setHeader("捐赠时间,捐赠人,捐赠种子,备注");
    grid1.setInitWidthsP("25,25,25,24.5");
    grid1.setColAlign("center,center,center,center");
    grid1.setColTypes("ro,ro,ro,ro");
    grid1.enableMultiselect(false);
    grid1.init();

    grid2 = new dhtmlXGridObject('gridbox_cCzls');
    grid2.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid2.setHeader("充值时间,充值金额,充值人,充值状态,备注");
    grid2.setInitWidthsP("20,20,20,20,19.5");
    grid2.setColAlign("center,center,center,center,center");
    grid2.setColTypes("ro,ro,ro,ro,ro");
    grid2.enableMultiselect(false);
    grid2.init();

    grid3 = new dhtmlXGridObject('gridbox_cTxls');
    grid3.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid3.setHeader("提现时间,提现能量,提现金额,提现操作人,提现状态,备注");
    grid3.setInitWidthsP("16,16,16,16,16,19.5");
    grid3.setColAlign("center,center,center,center,center,center");
    grid3.setColTypes("ro,ro,ro,ro,ro,ro");
    grid3.enableMultiselect(false);
    grid3.init();
}

function loadGridData(reqUrl){
    var frontGrid;
    if(tmpClickLink == "cJzjl"){
        frontGrid = grid1;
    }else if(tmpClickLink == "cCzls"){
        frontGrid = grid2;btnSearch
    }else if(tmpClickLink == "cTxls"){
        frontGrid = grid3;
    }
    frontGrid.clearAll();


    var data = {
        "dKssj":$("#dKssj").val()
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
                        if("cJzjl" == tmpClickLink){
                            frontGrid.addRow(data[i].cLsh,[
                                data[i].dJzsj,
                                data[i].cUsername,
                                data[i].cSpmc,
                                data[i].cBz
                            ]);
                            frontGrid.setUserData(data[i].cLsh,'data',data[i]);
                        }else if("cCzls" == tmpClickLink){
                            frontGrid.addRow(data[i].cLsh,[
                                data[i].dFksj,
                                data[i].nFkje,
                                data[i].cFkzh,
                                data[i].cFksfcg == "1" ? "成功" : "失败",
                                data[i].cBz
                            ]);
                            frontGrid.setUserData(data[i].cLsh,'data',data[i]);
                        }else if("cTxls" == tmpClickLink){
                            frontGrid.addRow(data[i].cLsh,[
                                data[i].dSksj,
                                data[i].nFknl,
                                data[i].nSkje,
                                data[i].cFkzh,
                                data[i].cSksfcg == "1" ? "成功" : "失败",
                                data[i].cBz
                            ]);
                            frontGrid.setUserData(data[i].cLsh,'data',data[i]);
                        }
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



function getQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
    if(r!=null)return  unescape(r[2]); return null;
}



