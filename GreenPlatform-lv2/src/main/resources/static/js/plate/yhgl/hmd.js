/**
 * 入口函数
 * @param args  父页面传入的参数
 * @param mdi
 * @param layerIdx
 * @param parentWindow  父页面对象
 * @returns
 */
function _init(args, mdi, layerIdx, parentWindow) {
    var cCzfs = "add";
    if(args.cCzfs){
        cCzfs = args.cCzfs;
    }

    if(args && args.data){
        $("#cUserid").val(args.data.cUserid);

        $(".cUsername").text(args.data.cUsername);
        $("#cUsername").val(args.data.cUsername);
        $(".cZjhm").text(args.data.cZjhm);
        $("#cZjhm").val(args.data.cZjhm);
        $(".cEmail").text(args.data.cEmail);
        $("#cEmail").val(args.data.cEmail);
        $(".cPhone").text(args.data.cPhone);
        $("#cPhone").val(args.data.cPhone);
    }
    var refresh = false;
    initEvent();
    $("#btnRet").click(function(){
        parentWindow.returnValue = refresh;
        parent.layer.close(layerIdx);
    });


    function initEvent(){
        $("#btnSave").click(function(){
            var bPass = requiredFieldCheck($("label .require"), top, function(){});
            if(!bPass){
                return;
            }else{
                f_submitData("add","/plate/insertPlateuserBlacklist");
            }
        });
    }
    /**
     * 发送请求保存数据
     * type：操作方式（add加入黑名单/remove移除黑名单）
     * reqURL：服务地址
     */
    function f_submitData(type,reqURL){
        var data = {
            "cUserid":$("#cUserid").val(),
            "cUsername":$("#cUsername").val(),
            "cZjhm":$("#cZjhm").val(),
            "cEmail":$("#cEmail").val(),
            "cPhone":$("#cPhone").val(),

            "cCzfs":cCzfs,
            "cCzyy":$("#cCzyy").val()
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
