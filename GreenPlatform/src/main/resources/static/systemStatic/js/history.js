var grid1,grid2,grid3;
$(function(){
    initEvent();
    initGrid();
})

function initEvent() {
    $(".navbar-nav li").click(function(){
        $(".navbar-nav li").removeClass("active");
        $(this).addClass("active");
        $(".gridbox").hide();
        $("#gridbox_"+this.id).show();
    });

    $("#btnSearch").click(function(){
        loadGridData();
    });

}

/**
 * 初始化表格
 */
function initGrid(){
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

function loadGridData(){
    alert(1)
}


