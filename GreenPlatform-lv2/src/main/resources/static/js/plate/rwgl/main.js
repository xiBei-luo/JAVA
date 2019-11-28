var grid;
var pagerbar;
var gPageSize = 20;//每页显示数量
$(function(){
    initPagerBar();//初始化分页控件
    initEvent();
    initGrid();
});

/**
 * 初始化事件
 */
function initEvent(){
    initSelect();

    $("#btnSearch").click(function(){
        loadGridData(-1);
    });
}

/**
 * 初始化表格
 */
function initGrid(){
    $("#gridbox").attr({width:"100%",height:"100%"});
    grid = new dhtmlXGridObject('gridbox');
    grid.setImagePath("/publicFrame/dhtmlx-4.5/skins/web/imgs/");
    grid.setHeader("姓名,任务类别,任务完成时间,备注");
    grid.setInitWidthsP("25,20,30,24.5");
    grid.setColAlign("center,center,center,left");
    grid.setColTypes("ro,ro,ro,ro");
    grid.enableMultiselect(false);
    grid.init();
}



/**
 * 查询数据
 */
function loadGridData(page){
    grid.clearAll();
    var sendRequest = new SendRequest("/plate/selectTGreenRwRwmx","POST");//构造对象
    sendRequest.addParamObj({
        "pageNum":page,
        "pageSize":gPageSize,
        "cUsername":$("#cUsername").val(),
        "cRwlb":""
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
            var pages = ret.object.pages;
            var totalRows = ret.object.totalRows;

            if(page <= 0){
                //设置总页数
                pagerbar.setPageSize(pages * 1);
                //设置总条数
                pagerbar.setTotalCount(totalRows * 1);
            }

            if(ret.object.retDatas.length > 0){
                $("#commonInfo").hide();
                initData(ret.object.retDatas);
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
            data[i].cUsername,
            data[i].cRwlbsm,
            data[i].dRwsj,
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
    initBaseCodeSelect($("#cRwlb"),{cDmlb:"C_RW_RWLB"},null,"---请选择任务类别---");
    $("#cRwlb").change(function () {
        grid.clearAll();
    });
}



/**
 * 初始化分页工具条
 */
function initPagerBar(){
    pagerbar = new PagerBar({
        scaleBgColor:"#f9f9f9",      //页码容器背景颜色
        scaleBorderColor:"#eaeaea",  //页码容器边框颜色
        textColor:"#00aaee",         //页码容器中文字颜色和当前选中的页码容器背景色
        text_clickedColor:"#ffffff", //选中页码容器中的文本颜色

        showScaleSize:7,             //页码容器的个数，可不设置，默认为7个，如果页码pageSize小于页码容器个数，将页码赋值给页码容器个数
        scaleLen:29,                 //页码容器边长，可不设置，默认为29px;
        pageSize:1,                  //页码大小，必须设置
        pageListSize : gPageSize,     //每页列表显示记录条数
        renderTo:document.getElementById("pagerbar"),  //要将页码控件渲染到哪个容器中
        clickEvent:function(page){ //点击页码事件, 参数为currentPage,当前页
            loadGridData(page);
        },
        pageListSizeEvent: function(){//输入每页显示记录数后回车触发
            loadGridData(-1);
        }
    });
}



