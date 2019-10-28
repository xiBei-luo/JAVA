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
        $("#cFkfs").change(function(){
            $(".fk_yhk input").val("");
            if ("3" == $("#cFkfs").val()){
                $(".fk_yhk input").attr("disabled",false);
            } else {
                $(".fk_yhk input").attr("disabled",true);
            }
        });
        $("#cSkfs").change(function(){
            $(".sk_yhk input").val("");
            if ("3" == $("#cSkfs").val()){
                $(".sk_yhk input").attr("disabled",false);
            } else {
                $(".sk_yhk input").attr("disabled",true);
            }
        });

        initBaseCodeSelect($("#cFksfcg,#cSksfcg"),{cDmlb:"C_JC_SF"},null,"---请选择是否成功---");
        initBaseCodeSelect($("#cFkfs,#cSkfs"),{cDmlb:"C_NLCZ_ZFFS"},null,"---请选择支付方式---");
        $("#btnSave").click(function(){
            var bPass = requiredFieldCheck($("label .require"), top, function(){});
            if(!bPass){
                return;
            }else{
                checkParms();
            }
        });
    }


    /**
     * 参数验证
     */
    function checkParms() {
        var aParams = ["#cFkzh","#cSkzh","#cFkdh","#cSkdh","#nFknl"];
        for (var i=0;i<aParams.length;i++){
            if (!f_checkNumObj(aParams[i])) {
                return;
            }
        }
        f_submitData("/plate/insertTGreenNlTxjl");
    }

    function f_checkNumObj(obj) {
        var cFkzhReg = /^\d+(\.\d{1,2})?$/;

        if (!cFkzhReg.test($(obj).val())){
            BootstrapDialog.alert({
                type: BootstrapDialog.TYPE_WARNING,
                size: BootstrapDialog.SIZE_SMALL,
                title: '提示',
                message: "输入格式有误！",
                closeable: true,
                buttonLabel: "确定",
                callback: function () {
                    $(obj).focus();
                }
            });
            return false;
        }
        return true;
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


            "cFkzh":$("#cFkzh").val(),
            "cFkfs":$("#cFkfs").val(),
            "dFksj":$("#dFksj").val(),
            "cFkyh":$("#cFkyh").val(),
            "cFkkh":$("#cFkkh").val(),
            "cFksfcg":$("#cFksfcg").val(),
            "cFkdh":$("#cFkdh").val(),

            "cSkzh":$("#cSkzh").val(),
            "cSkfs":$("#cSkfs").val(),
            "dSksj":$("#dSksj").val(),
            "cSkyh":$("#cSkyh").val(),
            "cSkkh":$("#cSkkh").val(),
            "cSksfcg":$("#cSksfcg").val(),
            "cSkdh":$("#cSkdh").val(),

            "nFknl":$("#nFknl").val(),
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
