function SendRequest(requestURL,RequestMethod){
    this._paramObj = {};//参数
    this._requestURL = requestURL;//请求地址(不能为空)
    this._RequestMethod = RequestMethod;//请求方式(不能为空)
}

/*
方法
 */

//新增参数
SendRequest.prototype.addParamObj = function(paramObj){
    this._paramObj = paramObj;
}
//发送请求
SendRequest.prototype.sendRequest = function (callbackMethod) {
    var options = {
        url:this._requestURL,
        type:this._RequestMethod,
        data:this._paramObj,
        success:function(ret,textStatus){
            callbackMethod(ret);
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
            callbackMethod({"flag":"1","msg":"服务器端出错","object":""});
        }
    };
    $.ajax(options);
}







