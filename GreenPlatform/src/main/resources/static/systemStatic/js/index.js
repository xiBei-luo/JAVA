$(function(){
    initEvent();
})

function initEvent() {
    $("#myAccount").click(function(){
        $("#myAccountModel").modal('show');
    });


    $(".navbar-nav li").click(function(){
        $(".navbar-nav li").removeClass("active");
        $(this).addClass("active");
    });
}


