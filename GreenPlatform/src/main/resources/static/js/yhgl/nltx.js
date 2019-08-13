/**
 * 入口函数
 * @param args  父页面传入的参数
 * @param mdi
 * @param layerIdx
 * @param parentWindow  父页面对象
 * @returns
 */
function _init(args, mdi, layerIdx, parentWindow) {
    if(args){
        $("#cUserid").val(args.cUserid);

        $(".cUsername").text(args.cUsername);
        $("#cUsername").val(args.cUsername);
        $(".cZjhm").text(args.cZjhm);
        $("#cZjhm").val(args.cZjhm);
        $(".cEmail").text(args.cEmail);
        $("#cEmail").val(args.cEmail);
        $(".cPhone").text(args.cPhone);
        $("#cPhone").val(args.cPhone);
    }
    var refresh = false;
    initEvent();
    $("#btnRet").click(function(){
        parentWindow.returnValue = refresh;
        parent.layer.close(layerIdx);
    });


    function initEvent(){
        initBaseCodeSelect($("#cSfcg"),{cDmlb:"C_JC_SF"},null,"---请选择是否成功---");
        initBaseCodeSelect($("#cCzfs"),{cDmlb:"C_NLCZ_ZFFS"},null,"---请选择充值方式---");
        $("#btnSave").click(function(){
            var bPass = requiredFieldCheck($("label .require"), top, function(){});
            if(!bPass){
                return;
            }else{
                f_submitData("/plate/insertTGreenNlCzjl");
            }
        });
    }
    /**
     * 发送请求保存数据
     * reqURL：服务地址
     */
    function f_submitData(reqURL){
        var data = {
            "cUserid":$("#cUserid").val(),
            "cUsername":$("#cUsername").val(),
            "cZjhm":$("#cZjhm").val(),
            "cEmail":$("#cEmail").val(),
            "cPhone":$("#cPhone").val(),


            "nCzje":$("#nCzje").val(),
            "dDzsj":$("#dDzsj").val(),
            "cSfcg":$("#cSfcg").val(),
            "cCzfs":$("#cCzfs").val(),
            "cCzyh":$("#cCzyh").val(),
            "cZfzh":$("#cZfzh").val(),
            "cDzzh":$("#cDzzh").val(),
            "cZzdh":$("#cZzdh").val(),
            "cBz":$("#cBz").val()
        };

        var options = {
            url : reqURL,
            type : 'post',
            data : JSON.stringify(data),
            contentType: 'application/json',
            dataType : 'json',
            success: function(ret){
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
            }
        };
        $.ajax(options);
    }

}
