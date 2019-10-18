$(function(){
    initEvent();
});

function initEvent() {

    $("#returnTop").click(function(){
        $('body,html').animate({scrollTop:0},300)
    });


    $(".navbar-nav li").click(function(){
        $(".navbar-nav li").removeClass("active");
        $(this).addClass("active");
    });

    $(".ct-action a,#mission a,#btnLike").click(function(){
        f_gotoLogin();
    });
}


function toStart(){
    $("#jsGold").css({
        "top":"0",
        "opacity":"1"
    });
}


function f_gotoLogin(){
    BootstrapDialog.confirm({
        type: BootstrapDialog.TYPE_WARNING,
        size: BootstrapDialog.SIZE_SMALL,
        title: '提示',
        message: "请登录系统后操作，是否跳转到登录页？",
        closeable: true,
        btnOKLabel: "确定",
        btnCancelLabel: "取消",
        callback: function (ret) {
            if(ret){
                window.location.href = "/base/login";
            }
        }
    });
}




