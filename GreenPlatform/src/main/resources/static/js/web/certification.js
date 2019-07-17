$(function(){
    $("#btnCertification").click(function(){
        var sendRequest = new SendRequest("/web/certification","POST");//构造对象
        sendRequest.addParamObj({
            cUserid:""
        });//构造请求参数

        sendRequest.sendRequest(function(ret){
            if("0" != ret.flag){
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "操作失败！"+ret.msg,
                    closeable: true,
                    buttonLabel: "确定"
                });
            }else{
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_PRIMARY,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "操作成功",
                    closeable: true,
                    buttonLabel: "确定"
                });
            }

        });//发送请求并获取返回结果
    });
})