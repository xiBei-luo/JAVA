
/**
 * 1、初始化基础代码下拉列表：同步
 * @param $container 下拉框对象
 * @param args 调用服务参数
 * @param defVal 默认选中值
 * @param allFlag 显示全部时的字符
 */
function initBaseCodeSelect($container, args, defVal, allFlag){
    if($container){
        $container.empty();
    }

    var sendRequest = new SendRequest("/plate/selectPlateCodeDmz","POST");//构造对象
    sendRequest.addParamObj(args);//构造请求参数
    sendRequest.sendRequest(function(ret){

        if(ret.flag == "0" && ret.object.length>0){
            if(allFlag){
                $container.append("<option value=''>"+allFlag+"</option>");
            }else if("" == allFlag){
                $container.append("<option value=''>&nbsp;</option>");
            }

            for(var i=0; i<ret.object.length; i++){
                $container.append("<option value='"+ret.object[i].cDm+"' text='"+ret.object[i].cDmmc+"'>"+ret.object[i].cDmmc+"</option>");
            }
        }
        if(defVal && $container){
            $("option[value='"+defVal+"']", $container).attr({selected: true});
        }
    });//发送请求并获取返回结果

}


/**
 *根据代码类别和代码值获取代码名称
 */
function f_getDmmc(cmlb,cDm){
    var sendRequest = new SendRequest("/plate/selectPlateCodeDmz","POST");//构造对象
    sendRequest.addParamObj({
        cDmlb:cmlb,
        cDm:cDm
    });
    sendRequest.sendRequest(function(ret){

    });//发送请求并获取返回结果
}

/**
 * 必输项检查
 * @param $star
 * @param win
 * @param callbackFun
 * @returns {boolean}
 */
function requiredFieldCheck($star, win, callbackFun){
    var pass = true;
    $star.each(function(){
        var $label = $(this).parent();
        var _title = $label.text().replace(/[*:：]/g,"");
        var _id = $label.attr("for");
        if(_id && $("#"+_id).val() == ""){
            pass = false;
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: _title+"不能为空，请输入相应内容!",
                closeable: true,
                buttonLabel: "确定",
                callback: function () {
                    window.setTimeout(function(){$("#"+_id).focus();}, 100);
                }
            });
            return false;
        }
    });

    return pass;
}
/**
 * 加载公共页面
 * @param obj
 * @param url
 */
function load(obj, url){
    //alert($(url).attr("href"));
    $.ajaxSetup({cache: false });
    $(obj).load(url, function(result){
        $result = $(result);
        $result.find("script").appendTo(obj);
    });
}
