package com.greenplatform.controller;

import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Luowenlv on 2019/5/15,14:44
 * 基础控制，页面跳转
 */
@Controller
@RequestMapping(value = "/base")
public class BaseController {
    @Autowired
    PlateService plateService;

    @Autowired
    WebService webService;

    //公用
    @GetMapping(value = "/login")
    public String login() {
        return "login/login";
    }

    @GetMapping(value = "/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("loginUser");
        session.invalidate();//真正销毁session
        return "login/login";
    }

    //后台
    //后台-业务功能
    /**
     * 查询登陆用户权限
     * @param model
     * @return
     */
    @GetMapping(value = "/index")
    public String index(HttpSession session,Model model) {
        ReturnModel returnModel = plateService.selectLoginuserYwqx();
        if (0 != returnModel.getFlag()){
            session.removeAttribute("loginUser");
            return "login/login";
        }else{
            model.addAttribute("loginuserYwqxMap",returnModel.getObject());
            return "plate/index";
        }
    }

    @GetMapping(value = "/yhgl")
    public String yhgl(){
        return "plate/yhgl/main";
    }
    @GetMapping(value = "/yhgl/nlcz")
    public String yhglNlcz(){
        return "plate/yhgl/nlcz";
    }
    @GetMapping(value = "/yhgl/nltx")
    public String yhglNltx(){
        return "plate/yhgl/nltx";
    }
    @GetMapping(value = "/yhgl/hmd")
    public String yhglHmd(){
        return "plate/yhgl/hmd";
    }
    @GetMapping(value = "/rwgl")
    public String rwgl(){
        return "plate/rwgl/main";
    }
    @GetMapping(value = "/nlgl")
    public String nlgl(){
        return "plate/nlgl/main";
    }
    @GetMapping(value = "/spgl")
    public String spgl(){
        return "plate/spgl/main";
    }
    @GetMapping(value = "/spgl/edit")
    public String spglEdit(){
        return "plate/spgl/edit";
    }
    @GetMapping(value = "/stgl")
    public String stgl(){
        return "plate/stgl/main";
    }
    @GetMapping(value = "/zhsjgl")
    public String zhsjgl(){
        return "plate/zhsjgl/main";
    }
    //后台-系统配置
    @GetMapping(value = "/ywjcdm")
    public String ywjcdm(){
        return "plate/ywjcdm/main";
    }
    @GetMapping(value = "/ywjcdm/edit")
    public String ywjcdmEdit(){
        return "plate/ywjcdm/edit";
    }
    @GetMapping(value = "/plateYhgl")
    public String plateYhgl(){
        return "plate/plateYhgl/main";
    }
    @GetMapping(value = "/plateYhgl/edit")
    public String plateYhglEdit(){
        return "plate/plateYhgl/edit";
    }
    @GetMapping(value = "/plateYhgl/ddsq")
    public String plateYhglddsq(){
        return "plate/plateYhgl/ddsq";
    }
    @GetMapping(value = "/qxgl")
    public String qxgl(){
        return "plate/qxgl/main";
    }
    @GetMapping(value = "/qxgl/edit")
    public String qxglEdit(){
        return "plate/qxgl/edit";
    }
    @GetMapping(value = "/qxgl/jssq")//查询指定角色拥有的业务功能权限
    public String jssq(@RequestParam(name = "cRole", required = true) String cRole,Model model){
        ReturnModel returnModel = plateService.selectPermissionByRole(cRole);
        model.addAttribute("rolePermissionList",returnModel.getObject());
        return "plate/qxgl/jssq";
    }

    @GetMapping(value = "/qxgl/syyh")//查询指定角色授予给了哪些用户
    public String syyh(@RequestParam(name = "cRole", required = true) String cRole,Model model){
        ReturnModel returnModel = plateService.selectPlateuserByRole(cRole);
        model.addAttribute("plateuserRoleList",returnModel.getObject());

        return "plate/qxgl/syyh";
    }
    @GetMapping(value = "/xtcssz")
    public String xtcssz(){
        return "plate/xtcssz/main";
    }
    @GetMapping(value = "/xtcssz/edit")
    public String xtcsszEdit(){
        return "plate/xtcssz/edit";
    }
    @GetMapping(value = "/yypz")
    public String yypz(){
        return "plate/yypz/main";
    }
    @GetMapping(value = "/yypz/edit")
    public String yypzEdit(){
        return "plate/yypz/edit";
    }
    @GetMapping(value = "/online")
    public String online(){
        return "plate/online/main";
    }


    //网站
    @GetMapping(value = "/register")
    public String register() {
        return "login/register";
    }
    @GetMapping(value = "/loginByPhone")
    public String loginByPhone() {
        return "login/loginByPhone";
    }
    @GetMapping(value = "/getBackPassword")
    public String getBackPassword(HttpSession session) {
        session.removeAttribute("loginUser");
        return "login/getBackPassword";
    }
    @GetMapping(value = "/tipPage")
    public String tipPage(@RequestParam(name = "cPhone",required = true) String cPhone,Model model) {
        ReturnModel returnModel = webService.selectUserByPhone(cPhone);
        model.addAttribute("plateUser",returnModel.getObject());
        return "login/tipPage";
    }
    @GetMapping(value = "/loginByWx")
    public String loginByWx() {
        return "login/loginByWx";
    }
    @GetMapping(value = "/registerByWx")
    public String registerByWx() {
        return "login/registerByWx";
    }
    @GetMapping(value = "/history")
    public String history(Integer type){
        return "web/history";
    }
    @GetMapping(value = "/certification")
    public String certification(String type){
        return "web/certification";
    }
    @GetMapping(value = "/home")
    public String home(Model model){
        ReturnModel returnModel = webService.selectLoginuserHome();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "web/home";
    }
    @GetMapping(value = "/doLike")
    public String doLike(Model model){
        ReturnModel returnModel = webService.selectLoginuserHome();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "web/doLike";
    }
    @GetMapping(value = "/nlRank")
    public String nlRank(Model model){
        ReturnModel returnModel = webService.selectLoginuserHome();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "web/nlRank";
    }
    @GetMapping(value = "/shop")
    public String shop(Model model){
        ReturnModel returnModel = webService.selectLoginuserHome();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "web/shop";
    }

    //我的账户
    @GetMapping(value = "/myAccount")
    public String myAccount(Model model){
        ReturnModel returnModel = webService.selectLoginuserAccount();
        Map retMap = (Map) returnModel.getObject();


        model.addAttribute("loginuserAccount", retMap.get("plateUser"));
        return "web/myAccount/main";
    }
    @GetMapping(value = "/myAccount/jbxx")
    public String myAccountJbxx(Model model){
        ReturnModel returnModel = webService.selectLoginuserAccountJbxx();
        model.addAttribute("loginuserAccountJbxx", returnModel.getObject());
        return "web/myAccount/jbxx";
    }
    @GetMapping(value = "/myAccount/wdrw")
    public String myAccountWdrw(Model model){
        ReturnModel returnModel = webService.selectLoginuserAccountWdrw();
        model.addAttribute("loginuserAccountWdrw", returnModel.getObject());
        return "web/myAccount/wdrw";
    }
    @GetMapping(value = "/myAccount/wdzw")
    public String myAccountWdzw(Model model){
        ReturnModel returnModel = webService.selectLoginuserAccountWdzw();
        model.addAttribute("loginuserAccountWdzw", returnModel.getObject());
        return "web/myAccount/wdzw";
    }
    @GetMapping(value = "/myAccount/wdtd")
    public String myAccountWdtd(Model model){
        ReturnModel returnModel = webService.selectLoginuserAccountWdtd();
        model.addAttribute("loginuserAccountWdtd", returnModel.getObject());
        return "web/myAccount/wdtd";
    }
    @GetMapping(value = "/myAccount/nlgl")
    public String myAccountNlgl(Model model){
        ReturnModel returnModel = webService.selectLoginuserAccountJbxx();
        model.addAttribute("loginuserAccountNlgl", returnModel.getObject());
        return "web/myAccount/nlgl";
    }


    //维护页面
    @GetMapping(value = "/safeguard")
    public String safeguard(){
        return "safeguard";
    }


    //扫描二维码注册
    @GetMapping(value = "/qrcodeRegister")
    public String qrcodeRegister(@RequestParam(name = "user", required = true) String user,Model model){
        model.addAttribute("cYqm",user);
        return "login/qrcodeRegister";
    }





















}
