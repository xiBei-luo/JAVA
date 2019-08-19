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
    grid.setHeader("操作,姓名,登录名,性别,证件号码,人员性质,人员状态,是否实名制,账户等级,电话号码,账户能量");
    grid.setInitWidthsP("20,10,10,6,16,8,8,8,8,11,8");
    grid.setColAlign("center,left,left,center,left,center,center,center,center,center,center");
    grid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro");
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
        var opLinkBuff = new StringBuffer();
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-primary \" onclick=\"f_cz(\'"+data[i].cUserid+"\');\" id=\"cz_link_"+data[i].cUserid+"\" >充值</button>&nbsp&nbsp&nbsp");
        opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-info \" onclick=\"f_tx(\'"+data[i].cUserid+"\');\" id=\"tx_link_"+data[i].cUserid+"\" >提现</button>&nbsp&nbsp&nbsp");

        if("1" == data[i].cRyxz){
            opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-danger \" onclick=\"f_hmd('add',\'"+data[i].cUserid+"\');\" >加入黑名单</button>");
        }else if("-1" == data[i].cRyxz){
            opLinkBuff.append("<button type=\"button\" class=\"btn btn-sm btn-warning \" onclick=\"f_hmd('remove',\'"+data[i].cUserid+"\');\" >移除黑名单</button>");
        }



        var xbSm = "";
        if ("1" == data[i].cSex){
            xbSm = "男";
        } else if ("2" == data[i].cSex){
            xbSm = "女";
        }

        grid.addRow(data[i].cUserid,[
            opLinkBuff.toString(),
            data[i].cUsername,
            data[i].cLoginname,
            xbSm,
            data[i].cZjhm,
            data[i].cRyxzsm,
            data[i].cRyztsm,
            data[i].cIssmz == '1' ? '是' : '否',
            data[i].cRydj+'级',
            data[i].cPhone,
            data[i].nNlhz
        ]);
        grid.setUserData(data[i].cUserid,'data',data[i]);
    }
}

/**
 * 账户充值
 * @param cUserid
 */
function f_cz(cUserid){
    var data = grid.getUserData(cUserid,"data");
    var win = top.$.MdiWindow(window, 800, 600, 0, 0, true);
    win.setTitle("账户能量充值");
    win.setWindowArguments(data);//参数
    win.btnClose(true);
    win.btnMax(false);
    win.btnMin(false);
    win.isResize(false);
    win.onClose(function (ret) {
        if(ret){
            loadGridData();
        }
    });
    win.load("/yhgl/nlcz", window, function (obj) { });
}

/**
 * 账户能量体现
 * @param cUserid
 */
function f_tx(cUserid) {
    var data = grid.getUserData(cUserid,"data");
    var win = top.$.MdiWindow(window, 800, 600, 0, 0, true);
    win.setTitle("账户能量提现");
    win.setWindowArguments(data);//参数
    win.btnClose(true);
    win.btnMax(false);
    win.btnMin(false);
    win.isResize(false);
    win.onClose(function (ret) {
        if(ret){
            loadGridData();
        }
    });
    win.load("/yhgl/nltx", window, function (obj) { });
}

/**
 * 加入黑名单
 * @param type (add加入/remove移除)
 * @param cUserid
 */
function f_hmd(type,cUserid){
    var data = grid.getUserData(cUserid,"data");
    var args = {
        data:data,
        cCzfs:type
    }
    var tmpTxt = "";
    if("add" == type){
        tmpTxt = "加入";
    }else if("remove" == type){
        tmpTxt = "移除";
    }
    var win = top.$.MdiWindow(window, 800, 300, 0, 0, true);
    win.setTitle("【"+data.cUsername+"】"+tmpTxt+"黑名单");
    win.setWindowArguments(args);//参数
    win.btnClose(true);
    win.btnMax(false);
    win.btnMin(false);
    win.isResize(false);
    win.onClose(function (ret) {
        if(ret){
            loadGridData();
        }
    });
    win.load("/yhgl/hmd", window, function (obj) { });
}
