/**
 * 入口函数btnSave
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
        $("#btnSave").click(function(){
            initParams();
        });
    }

    /**
     * 组装参数
     */
    function initParams(){
        var checkLen = $("input[type='checkbox']").length;
        var checkArr = [];
        for (var i=0;i<checkLen;i++){
            var tmpCheckJson = {};
            tmpCheckJson[$($("input[type='checkbox']")[i]).prop("id")] = $($("input[type='checkbox']")[i]).prop("checked");
            checkArr.push(tmpCheckJson);
        }

        var data = {
            "cRole":args.cRole,
            "permissionJson":checkArr
        }
        f_submitData(data,"/plate/saveUserRolePermission");
    }
    /**
     * 发送请求保存数据
     * type:操作类型，0新增/1修改/2删除
     * reqURL：服务地址
     */
    function f_submitData(data,reqURL){
        var options = {
            url : '/plate/saveUserRolePermission', 　
            type : 'post',　　　　　　　　
            data : JSON.stringify(data),
            contentType: 'application/json',
            dataType : 'json',
            success: function(ret){
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




        /*var sendRequest = new SendRequest(reqURL,"POST");//构造对象

        sendRequest.addParamObj({
            "cRole":"admin",
            "cPermission":[1,2,3,4,5]
        });//构造请求参数

        sendRequest.sendRequest(function(ret){
            console.log(ret);
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
        });//发送请求并获取返回结果*/
    }

}
