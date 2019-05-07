$(function(){
    initEvent();
})

function initEvent(){
    //$("#btnSave").click(f_save);
}

function f_save() {
    $.ajax({
        type:"POST",
        url:"/plate/login",
        data:{
            "loginname":$("#inputEmail3").val(),
            "password":$("#inputPassword3").val()
        }
    });
}