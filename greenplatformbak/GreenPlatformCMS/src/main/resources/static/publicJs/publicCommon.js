//=================================================================================
// 目录
// 1. 处理值：转null为空串     						nullToEmpty(val)
// 2. 处理对象值：转null为空串                 				nullToEmptyForObject(obj)
// 3. 置光标         									setFocusToLast($obj)
// 4. 处理回车转移焦点                  						shiftFocusWhenEnter($objs)
// 5. 必输入域检查                 							requiredFieldCheck(starCls, win, callbackFun)
// 6. 置页面数据，显示用                     					setPageShowData(obj)
// 7. 设置未经渲染的输入域值                          				setInputArea(obj)
// 8. 组织机构为纯数字时，格式化为带分隔符                          	formatZzjgdm(zzjgdm)
// 9. 数字格式化为本地字符串						numberFormatToStr(_number)
// 10. 数据格式化为人民币显示格式					numToRMBFormat(_number, _color, _prev)
// 11. 数字格式化 									fnumber(s, n)
// 11. 数字格式化金额								fmoney(s, n)
// 11. toFixed方法重写，toFixed四舍五入在数值很小时的精度问题
// 12. 加载样式块									includeStyleElement(styles, styleId)
// 13. 返回空格字符串								getSpaceNum(num)
// 14. js获取项目根路径(上下文)						getContextPath()
// 15. js获取项目域名路径							getDomainPath()
// 16. 以post方式提交数据到servlet					openPostWindow(url, data, name)
// 17. 为grid列表取合适的页记录条数					getFittingPageSize(listId, lineHeight, defautVal)
// 18. 取url中"?"符后的字串，以MAP形式返回			GetRequest()
// 19. 取资源URL地址								getBinContentURL(argObj)
// 20. 取数据库时间								getSysDate()
// 21. 将指定日期加月份                           					strDateAddMonth
// 22. 将指定日期加天数                           					strDateAddDays
//=================================================================================

/**
 * 处理值：转null为空串
 * @return val
 */
function nullToEmpty(val){
    if(typeof val == 'undefined'
        || val == null || (""+val).replace(/^(\s+)|(\s+)$/,'') == 'null'){
        return "";
    }else{
        return val;
    }
}

/**
 * 处理对象值：转null为空串
 * @return object
 */
function nullToEmptyForObject(obj){
    var _obj = obj;
    try{
        $.each(obj, function(k, v){
            _obj[k] = nullToEmpty(v);
            if(v != null && typeof v == 'object'){
                nullToEmptyForObject(v);
            };
        });
    }catch(e){}

    return _obj;
}

/**
 * 置光标
 */
function setFocusToLast($obj){
    if($obj.length == 0) return;
    if($obj.attr("type") != 'text'){
        $obj.focus();
        return;
    }else{
        $obj[0].focus();
        var r = $obj[0].createTextRange();
        r.moveStart("character",$obj[0].value.length);
        r.collapse(true);
        r.select();
    }
}

/**
 * 处理回车转移焦点
 */
function shiftFocusWhenEnter($objs){
    $objs.keyup(function(event){
        var keycode = (event.keyCode ? event.keyCode : (event.which ? event.which : event.charCode));
        var $this = $(this);
        var _id = $this.attr("id");
        var _name = $this.attr("name");

        if(keycode == 13){
            var curIndex = -1;
            $objs.each(function(index,ele){
                if(_id && ele.id == _id || _name && ele.name == _name){
                    curIndex = index;
                    return false;
                }
            });

            if(curIndex != -1 && curIndex != $objs.length-1){
                $objs[curIndex+1].focus();
                var val = $objs[curIndex+1].value;
                if(null != val){
                    $objs[curIndex+1].value = val;//让光标在最后
                }
            }
        }
    });
}

/**
 * 必输入域检查
 * @param starCls
 * 		星号样式
 * @param win
 *      dhtmx.Alert所在窗口
 * 结构：<label for="C_HTLYDM" class="control-label"><span class="required-field">*</span>名称：</label>
 */
function requiredFieldCheck(starCls, win, callbackFun){
    var pass = true;
    $("span."+starCls).each(function(){
        var $label = $(this).closest("label");
        var _title = $label.text().replace(/[*:：]/g,"");
        var _id = $label.attr("for");
        if(_id && $("#"+_id).val() == ""){
            pass = false;
            win.dhtmlx.alert({
                title:"提示信息",
                type:"alert-error",
                ok:"确 定",
                text:_title+"不能为空，请输入相应内容!",
                callback:function(result){
                    callbackFun();
                    window.setTimeout(function(){$("#"+_id).focus();}, 100);
                }
            });
            return false;
        }
    });

    return pass;
}

/**
 * 必输入域检查
 * @param $star
 * 		星号必输标志所在的HTML标签
 * @param win
 *      dhtmx.Alert所在窗口
 * 如：<span for="C_HTLYDM" class="control-label"><span class="required-field">*</span>名称：</span>
 */
function requiredFieldCheck2($star, win, callbackFun){
    var pass = true;
    $star.each(function(){
        var $label = $(this).parent();
        var _title = $label.text().replace(/[*:：]/g,"");
        var _id = $label.attr("for");
        if(_id && $("#"+_id).val() == ""){
            pass = false;
            win.dhtmlx.alert({
                title:"提示信息",
                type:"alert-error",
                ok:"确 定",
                text:_title+"不能为空，请输入相应内容!",
                callback:function(result){
                    callbackFun();
                    window.setTimeout(function(){$("#"+_id).focus();}, 100);
                }
            });
            return false;
        }
    });

    return pass;
}

/*
 * 输入域检查
 * 结构：
 * if (!IsNotNul($("#N_HGS"),"合格数")||
	   !IsNotNul($("#N_SZS"),"试制数")
   ) return;
 */
function IsNotNul(obj,eMsg){
    var val = $(obj).val();
    if($.trim(val) == ""){
        top.dhtmlx.alert({
            title:"提示信息",
            type:"alert-error",
            ok:"确 定",
            text:eMsg+"不能为空，请输入相应内容!",
            callback:function(result){
                $(obj).focus();
            }
        });
        try{
            $(obj).focus();
        }catch(e){
        }
        return false;
    }
    return true;
}

/**
 * 置页面数据，显示用
 */
function setPageShowData(obj){
    $.each(obj, function(k, v){
        var $this = $("#"+k);
        if($this.length > 0){
            $this.text(v == null || v == undefined ? "" : v);
        }
        if(v != null && typeof v == 'object'){
            if(v instanceof Date){
                $this.text(DateTime.toString(v));
            }else if(v instanceof Object){
                setPageShowData(v);
            }
        }
    });
}

/**
 * 设置未经渲染的输入域值
 */
function setInputArea(obj){
    $.each(obj, function(k, v){
        if($("#"+k).length>0){
            var $this = $("#"+k);
            var type = $this.attr("type");
            if(type != "radio" && type != "checkbox"){
                $this.val(v==null || v==undefined ? "" : v);
            }
        }
        if($(":radio[name="+k+"]").length > 0){
            $(":radio[name="+k+"][value="+v+"]").attr('checked', true);
        }
    });
}

/**
 * 组织机构为纯数字时，格式化为带分隔符
 */
function formatZzjgdm(zzjgdm){
    if(typeof(zzjgdm) == "undefined" || zzjgdm == null){
        return "";
    }
    if(zzjgdm.indexOf("-") != -1 || zzjgdm.length != 9){
        return zzjgdm;
    }

    return zzjgdm.substring(0,8)+"-"+zzjgdm.substring(8,9);
}

/**
 * 数字格式化为本地字符串
 */
function numberFormatToStr(_number){
    if(isNaN(_number)) return "";
    if(_number == 0) return "0.00";

    return parseFloat(_number).toLocaleString();
}

/**
 * 数据格式化为人民币显示格式
 */
function numToRMBFormat(_number, _color, _prev){
    var ret = numberFormatToStr(_number);
    if(ret == "") return "";

    //if(!!!_prev)  _prev = "￥";
    _prev = "";
    if(!!!_color) _color = "green";
    if(_color){
        ret = "<font color='"+_color+"' style='font-weight:bold;'>"+_prev+ret+"</font>";
    }
    return ret;
}

/**
 * 数字格式化：
 * 1）整数默认保留两位小数，
 * 2）小数：小数位数不足2位的，补足两位，默认保留2位
 * 3）小数：小数位数超过2位，并低于n位，则有多少位，显示（保留）多少位，
 * 4）小数：若超过指定位数n则四舍五入
 */
function fnumber(s, n){
    if( s == null || s === "" || isNaN(s) ){
        return "";
    }
    var negative = false;
    if(parseFloat(s) < 0 ){//若是负数，则将-截掉
        negative = true;
        s = (s + "").substring(1,(s + "").length);
    }

    n = n > 0 && n <= 20 ? n: 2;

    if((s + "").indexOf(".") < 0 && n > 2){//整数，则默认保留后两位小数
        n = 2;
    }
    if((s + "").indexOf(".") > 0){//小数
        var temp_r = s.split(".")[1];
        if(temp_r.length <= 2){
            n = 2;
        }
        if(temp_r.length > 2 && temp_r.length < n){//若超过2未而未超过n位则有多少位保留多少位
            n = temp_r.length;
        }

    }

    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = s.split(".")[0].split("").reverse(),
        r = s.split(".")[1];

    t = "";
    for (i = 0; i < l.length; i++) {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ",": "");
    }

    return (negative ? "-" : "") + t.split("").reverse().join("") + "." + r;
}

/**
 * 数字格式化金额:
 * 1）整数默认保留两位小数，
 * 2）小数：小数位数不足2位的，补足两位，默认保留2位
 * 3）小数：小数位数超过2位，并低于n位，则有多少位，显示（保留）多少位，
 * 4）小数：若超过指定位数n则四舍五入
 */
function fmoney(s, n) {
    if( s == null || s === "" || isNaN(s) ){
        return "";
    }
    var negative = false;
    if(parseFloat(s) < 0 ){//若是负数，则将-截掉
        negative = true;
        s = (s + "").substring(1,(s + "").length);
    }
    n = n > 0 && n <= 20 ? n: 2;

    if((s + "").indexOf(".") < 0 && n > 2){//整数，则默认保留后两位小数
        n = 2;
    }
    if((s + "").indexOf(".") > 0){//小数
        var temp_r = (s + "").split(".")[1];
        if(temp_r.length <= 2){
            n = 2;
        }
        if(temp_r.length > 2 && temp_r.length < n){//若超过2未而未超过n位则有多少位保留多少位
            n = temp_r.length;
        }

    }

    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = (s + "").split(".")[0].split("").reverse(),
        r = (s + "").split(".")[1];
    t = "";
    for (i = 0; i < l.length; i++) {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ",": "");
    }
    return (negative ? "-" : "") + t.split("").reverse().join("") + "." + r;
}
/**
 * toFixed方法重写，toFixed四舍五入在数值很小时的精度问题
 * eg:在对数值0.005进行四舍五入保留2为数字时，在ie8会发现0.005.toFixed(2)=0.00
 */
Number.prototype.toFixed = function(s) {
    var changenum = (parseInt(this * Math.pow(10, s) + 0.5) / Math.pow(10, s)).toString();
    index = changenum.indexOf(".");
    if (index < 0 && s > 0) {
        changenum = changenum + ".";
        for (i = 0; i < s; i++) {
            changenum = changenum + "0";
        }
    } else {
        index = changenum.length - index;
        for (i = 0; i < (s - index) + 1; i++) {
            changenum = changenum + "0";
        }
    }
    return changenum;
}

/**
 * 数字格式化:固定n位小数
 */
function fnumber_old(s, n){
//    if( s == null || s == "" ){
//        return "";
//    }
    if( s == null || s === "" || isNaN(s) ){
        return "";
    }
    n = n > 0 && n <= 20 ? n: 2;
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = s.split(".")[0].split("").reverse(),
        r = s.split(".")[1];
    t = "";
    for (i = 0; i < l.length; i++) {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ",": "");
    }
    return t.split("").reverse().join("") + "." + r;
}

/**
 * 数字格式化金额:固定n位小数
 */
function fmoney_old(s, n) {
//	if( s == null || s == "" ){
//		return "";
//	}
    if( s == null || s === "" || isNaN(s) ){
        return "";
    }
    n = n > 0 && n <= 20 ? n: 2;
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = s.split(".")[0].split("").reverse(),
        r = s.split(".")[1];
    t = "";
    for (i = 0; i < l.length; i++) {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ",": "");
    }
    return t.split("").reverse().join("") + "." + r;
}

/**
 * 加载样式块
 */
function includeStyleElement(styles, styleId){
    var style = document.getElementById(styleId);
    if(style){
        document.body.removeChild(style);
    }

    style = document.createElement("style");
    style.id = styleId;
    //为ie设置属性
    /*
    if (isIE()) {
    style.type = "text/css";
    style.media = "screen"
    }
    */
    (document.getElementsByTagName("head")[0] || document.body).appendChild(style);
    if (style.styleSheet) { //for ie
        style.styleSheet.cssText = styles;
    } else {//for w3c
        style.appendChild(document.createTextNode(styles));
    }
}

/**
 * 返回空格字符串
 * @param num
 * @returns {String}
 */
function getSpaceNum(num){
    var space="";
    for(var i=0;i<num;i++){
        space+="&nbsp;";
    }
    return space;
}

/**
 * js获取项目根路径(上下文)
 */
function getContextPath(){
    var href=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=href.indexOf(pathName);
    var rootPath=href.substring(0, pos);
    var appName=pathName.substring(0, pathName.substr(1).indexOf('/')+1);
    return(rootPath+appName);
}

/**
 * js获取项目域名路径
 */
function getDomainPath(){
    var href=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=href.indexOf(pathName);
    return href.substring(0, pos);
}

/**
 * 以post方式提交数据到servlet
 * @param url
 * 		提交地址
 * @param data
 * 		提交字符串
 * @param name
 * 		target名称
 */
function openPostWindow(url, data, name){
    var frm = document.createElement("form");
    frm.id="frm";
    frm.method="post";
    frm.action=url;
    frm.target=name;

    var hideIpt = document.createElement("input");
    hideIpt.type="hidden";
    hideIpt.name= "data"
    hideIpt.value= data;
    frm.appendChild(hideIpt);
    document.body.appendChild(frm);

    if(frm.fireEvent)frm.fireEvent("onsubmit");
    frm.submit();
    document.body.removeChild(frm);
}

/**
 * 为grid列表取合适的页记录条数
 * @param listId
 * 		容器列表Id
 * @param lineHeight
 *      行高
 * @param defaultVal
 *      默认值
 */
function getFittingPageSize(listId, lineHeight, defautVal){
    try{
        var list = document.getElementById(listId);
        var height = list.offsetHeight;
        var pageSize = Math.ceil(height/lineHeight);
        if(pageSize > defautVal){
            return pageSize;
        }else{
            return defautVal;
        }
    }catch(e){
        return defautVal;
    }
}

/**
 * 取url中"?"符后的字串，以MAP形式返回
 * @return
 */
function GetRequest() {
    var url = location.search; // 获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for ( var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

/**
 * 取资源URL地址
 * @param argObj
 *    argObj.binbh 资源编号
 *    argObj.userid当前登录人ID
 *    argObj.ywlx  业务类型
 *    argObj.getMode 取数模式(0 - 普通、1 - 下载)
 *    argObj.clientSSO 用户是否单点登录( 1 - 是、0 - 否)
 */
function getBinContentURL(argObj){
    var retURL = "";

    try{
        if(!AjaxProxy) return "";
        if(!argObj.binbh || !argObj.userid || !argObj.ywlx
            || !argObj.getMode){
            alert("请检查参数！");
            return "";
        }

        var ajax = new AjaxProxy();
        ajax.setCacheData(false);
        ajax.addParm("PC_YYFWDM", "000001");
        ajax.addParm("PN_BINBH", argObj.binbh);

        ajax.addParm("PN_USERID", argObj.userid);
        ajax.addParm("PC_YWLX", argObj.ywlx);
        ajax.addParm("PC_GETMODE", argObj.getMode);
        ajax.addParm("PC_CLIENTSSO", (argObj.clientSSO?argObj.clientSSO:"0"));

        ajax.addParm("PC_CHECKLOGIN", "0");
        ajax.addParm("PC_GETFILETYPE", "0");
        ajax.addParm("PC_THUMBCREATEFS", "");
        ajax.addParm("PN_THUMBWIDTH", 0);
        ajax.addParm("PN_THUMBHEIGHT", 0);

        ajax.invokeProc("APPUSER.PLATE_PUBLIC.PF_PLATE_GETBINCONTENT_URL", false);

        var ret = ajax.getInt("PN_RET")*1;
        var msg = ajax.getString("PC_MSG");
        if(ret == 0){
            retURL = ajax.getString("PC_URL");
        }
    }catch(e){
        alert("取资源URL时出错！");
    }

    return retURL;
}

/**取数据库时间**/
function getSysDate(){
    var result = "";

    try{
        if(!AjaxProxy) return "";

        var ajax = new AjaxProxy();
        ajax.setCacheData(false);
        ajax.addParm("PC_FORMAT", "YYYY-MM-DD");

        ajax.invokeProc("APPUSER.PLATE_PUBLIC.PF_GET_CURRENT_DATETIME", false);

        var ret = ajax.getInt("PN_RET")*1;
        var msg = ajax.getString("PC_MSG");
        if(ret == 0){
            result = ajax.getString("PC_DATESTR");
        }
    }catch(e){
        alert("取数据库当前时间出错！");
    }

    return result;

}

/**
 * 初始化用户指定流程待处理节点下拉列表：同步
 * @param $container 下拉列表
 * @param args 调用过程参数
 * @param defVal 默认选中值
 */
function initUserWaitTaskNodeDropdown($container, args, defVal){
    var ajax=new AjaxProxy();
    ajax.addParm("PN_USERID", args.N_USERID);  //当前操作用户Id
    ajax.addParm("PC_WF_KEY", args.C_WF_KEY);  //流程标志
    ajax.invokeProc("APPUSER.CTRI_PUB_YWLC.PF_CTRI_PUB_YWLC_DBRW_NODES", false);
    var row=ajax.getRowCount("P_RESULT");

    //$container.append("<option value=''></option>");
    if(row>0){
        for(var i=1;i<=row;i++){
            data={
                C_WF_TASKNODE    : ajax.getString("P_RESULT",i,"C_WF_TASKNODE"),
                C_WF_TASKNODENAME: ajax.getString("P_RESULT",i,"C_WF_TASKNODENAME")
            }

            $container.append("<option value='"+data.C_WF_TASKNODE+"'>"+data.C_WF_TASKNODENAME+"</option>");
        }
    }

    if(defVal){
        $("option[value='"+defVal+"']", $container).attr({selected: true});
    }
}

//*********************************************************************************
//21. 将指定日期加月份                           strDateAddMonth
//*********************************************************************************
function strDateAddMonth(strDate,iMonths){
    var thisYear = parseFloat(strDate.substring(0,4));
    var thisMonth = parseFloat(strDate.substring(5,7));
    var thisDate = parseFloat(strDate.substring(8,10));
    var d =thisYear *12 + thisMonth + parseFloat(iMonths);

    var newMonth = d % 12;
    if (newMonth==0) {
        newMonth=12;
    }
    var newYear = (d - newMonth) /12;
    var newDate = thisDate;
    var iMonthLastDate = getMonthLastDate(newYear,newMonth)
    if (newDate>iMonthLastDate) newDate=iMonthLastDate;
    var newDay="";

    newDay += newYear;
    if (newMonth<10) {
        newDay +="-" + "0" + newMonth;
    }else{
        newDay +="-" + newMonth;
    }

    if (newDate<10) {
        newDay +="-" + "0" + newDate;
    }else{
        newDay +="-" + newDate;
    }
    return(newDay);
}

function getMonthLastDate(iYear,iMonth){
    var dateArray= new Array(31,28,31,30,31,30,31,31,30,31,30,31);
    var days=dateArray[iMonth-1];
    if ((((iYear % 4 == 0) && (iYear % 100 != 0)) || (iYear % 400 == 0)) && iMonth==2){
        days=29;
    }
    return days;
}

//*********************************************************************************
//22. 将指定日期加天数                           strDateAddDays
//*********************************************************************************
function strDateAddDays(strDate, iDays){
    var  dateVal;

    var DyMilli = 1000 * 60 * 60 * 24;

    strDate = strDate.substr(5,2) + "-" + strDate.substr(8,2) + "-" + strDate.substr(0,4);
    dateVal = Date.parse(strDate);
    dateVal = dateVal + parseFloat(iDays) * DyMilli;

    var dateObj = new Date(dateVal);
    var newDay="";
    var newMonth = dateObj.getMonth() +1;
    var newDate = dateObj.getDate() ;
    newDay += dateObj.getFullYear();

    if (newMonth<10) {
        newDay +="-" + "0" + newMonth;
    }else{
        newDay +="-" + newMonth;
    }

    if (newDate<10) {
        newDay +="-" + "0" + newDate;
    }else{
        newDay +="-" + newDate;
    }
    return(newDay);
}