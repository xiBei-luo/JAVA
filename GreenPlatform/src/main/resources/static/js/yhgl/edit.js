/**
 * 入口函数
 * @param args  父页面传入的参数
 * @param mdi
 * @param layerIdx
 * @param parentWindow  父页面对象
 * @returns
 */
function _init(args, mdi, layerIdx, parentWindow) {
    var refresh = false;
    initEvent();
    $("#btnRet").click(function(){
        parentWindow.returnValue = refresh;
        parent.layer.close(layerIdx);
    });


    function initEvent(){
        initBaseCodeSelect($("#cSex"),{cDmlb:"C_USER_SEX"},null,"---请选择性别---");
        initBaseCodeSelect($("#cZjlx"),{cDmlb:"C_USER_ZJLX"},null,"---请选择证件类型---");
        $("#btnSave").click(function(){
            var bPass = requiredFieldCheck($("label .require"), top, function(){});
            if(!bPass){
                return;
            }else{
                f_submitData("0","/plate/insertPlateuser");
            }
        });
    }
    /**
     * 发送请求保存数据
     * type:操作类型，0新增/1修改/2删除
     * reqURL：服务地址
     */
    function f_submitData(type,reqURL){
        var sendRequest = new SendRequest(reqURL,"POST");//构造对象

        if ("0" === type) {
            sendRequest.addParamObj({
                "cUsername":$("#cUsername").val(),
                "cSex":$("#cSex").val(),
                "cEmail":$("#cEmail").val(),
                "cPhone":$("#cPhone").val(),
                "cWxhm":$("#cWxhm").val(),
                "cZjhm":$("#cZjhm").val(),
                "cLoginname":$("#cLoginname").val(),
                "cRylb":'1',
                "cPassword":$("#cPassword").val(),
                "cZt":'1',
            });//构造请求参数
        }else if("1" === type){
            sendRequest.addParamObj({
                "cUserid":$("#cUserid").val(),
                "cUsername":$("#cUsername").val(),
                "cSex":$("#cSex").val(),
                "cEmail":$("#cEmail").val(),
                "cPhone":$("#cPhone").val(),
                "cWxhm":$("#cWxhm").val(),
                "cZjhm":$("#cZjhm").val(),
                "cLoginname":$("#cLoginname").val(),
                "cRylb":'1',
                "cPassword":$("#cPassword").val(),
                "cZt":'1'
            });//构造请求参数
        }

        sendRequest.sendRequest(function(ret){
            $("#btnSave").attr("disabled",false);
            if("0" != ret.flag){
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_WARNING,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "操作失败！"+ret.msg,
                    closeable: true,
                    buttonLabel: "确定",
                    callback: function () {

                    }
                });
            }else{
                BootstrapDialog.alert({
                    type: BootstrapDialog.TYPE_PRIMARY,
                    size: BootstrapDialog.SIZE_SMALL,
                    title: '提示',
                    message: "操作成功",
                    closeable: true,
                    buttonLabel: "确定",
                    callback: function () {
                        refresh = true;
                        parentWindow.returnValue = refresh;
                        parent.layer.close(layerIdx);
                    }
                });
            }
        });//发送请求并获取返回结果
    }

}
