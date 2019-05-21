
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
 *获取登陆用户的信息
 */
function getLoginUser(){
    var sendRequest = new SendRequest("/plate/getLoginUser","POST");//构造对象
    sendRequest.sendRequest(function(ret){
        console.log(ret);
    });//发送请求并获取返回结果
}
