function SendRequest(requestURL,RequestMethod){
    this._paramObj = {};//参数
    this._requestURL = requestURL;//请求地址(不能为空)
    this._RequestMethod = RequestMethod;//请求方式(不能为空)

    this._retObj = "";//返回对象
}

/*
方法
 */

//构造参数
SendRequest.prototype.addParamObj = function(paramName,paramValue){
    var paramObj = {
        "cUsername":$("#cUsernameSearch").val(),
        "cPhone":$("#cPhoneSearch").val()
    };
}
//发送请求
SendRequest.prototype.sendRequest = function () {
    console.log(this._paramObj);
    console.log(this._RequestMethod);
    console.log(this._RequestMethod);
    var options = {
        url:this._requestURL,
        type:this._RequestMethod,
        data:this._paramObj,
        success:function(ret){
            this._retObj = ret;
            console.log(ret);
        },
        error:function(ret){
            this._retObj = ret;
            console.log(ret);
        }
    };
    $.ajax(options);

    return this._retObj;
}


