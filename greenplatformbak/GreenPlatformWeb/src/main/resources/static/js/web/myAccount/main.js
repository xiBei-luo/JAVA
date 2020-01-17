$(function(){
   $("#loginoutBtn").click(function(){
       //window.parent.location整个页面跳转
       window.parent.location = "/base/loginout";
   });

   $("#certificationBtn").click(function(){
       //window.parent.location整个页面跳转
       window.parent.location = "/base/certification";
   });

    $("#btnInviteUser").click(function () {
        $("#inviteUserQrcode").attr("src","/web/getInviteQrcode");
        $("#inviteUserModel").modal('show');
    });//邀请好友
});