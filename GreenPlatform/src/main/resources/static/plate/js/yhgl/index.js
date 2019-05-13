var grid;
$(function(){
    initEvent();
    initGrid();
});

function initEvent(){
    $(".navList").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        if ($(a).attr("href") === location.pathname) {
            $(this).addClass("active");
        } else {
            $(this).removeClass("active");
        }
    });
    $("#btnSearch").click(function(){
        loadGridData();
    });

    $("#cUsername,#cPhone").keyup(function(){
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if(keycode == '13'){// 回车触发查询
            $("#btnSearch").triggerHandler("click");
        }
    });
}

function initGrid(){
    grid = new dhtmlXGridObject('gridbox');
    grid.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid.setHeader("操作,姓名,性别,证件号码,人员状态,电话号码,微信号码,QQ号码,状态");
    grid.setInitWidthsP("15,10,6,16,8,11,11,11,11.5");
    grid.setColAlign("center,center,center,center,center,center,center,center,center");
    grid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro,ro");
    grid.enableMultiselect(false);
    grid.init();
}

function loadGridData(){
    grid.clearAll();
    var paramObj = {
        "cUsername":$("#cUsername").val(),
        "cPhone":$("#cPhone").val()
    };

    var options = {
        url:"/plate/selectPlateuser",
        type:"POST",
        data:paramObj,
        success:function(ret){
            if (ret.flag!=0){
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: ret.msg,
                    closeable: true,
                    buttonLabel: "确定"
                });
            }
            if(ret.object.length > 0){
                $("#commonInfo").hide();
                initData(ret.object);
            }else{
                $("#commonInfo").show();
                $("#commonInfo").text("没有查询结果！");
            }
        }
    };

    $.ajax(options);

}

function initData(data){
    for (var i=0; i<data.length; i++){
        var opLinkBuff = new StringBuffer();
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-primary \" onclick=\"f_xg(\'"+data.C_RYID+"\');\" id=\"xg_link_"+data.C_RYID+"\" >修改</button>")
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-warning \" onclick=\"f_del(\'"+data.C_RYID+"\');\" id=\"del_link_"+data.C_RYID+"\" >删除</button>")

        grid.addRow(data[i].cUserid,[
            opLinkBuff.toString(),
            data[i].cUsername,
            data[i].cUsername,
            data[i].cUsername,
            data[i].cUsername,
            data[i].cUsername,
            data[i].cUsername,
            data[i].cUsername,
            data[i].cUsername
        ]);
    }
}
