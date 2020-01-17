package com.greenplatform.controller;

import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    WebService webService;

    //公用
    @GetMapping(value = "/login")
    public String login() {
        return "login/login";
    }
    @GetMapping(value = "/loginAdmin")
    public String loginAdmin() {
        return "login/loginAdmin";
    }

    @GetMapping(value = "/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("loginUser");
        session.invalidate();//真正销毁session
        return "login/login";
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
    //能量管理(捐赠记录、充值记录、提现记录)
    @GetMapping(value = "/myAccount/nlgl/jzjl")
    public String myAccountNlglJzjl(Model model){
        return "web/myAccount/nlgl/jzjl";
    }
    @GetMapping(value = "/myAccount/nlgl/czjl")
    public String myAccountNlglCzjl(Model model){
        ReturnModel returnModel = webService.selectLoginuserAccountJbxx();
        model.addAttribute("loginuserAccountNlgl", returnModel.getObject());
        return "web/myAccount/nlgl/czjl";
    }
    @GetMapping(value = "/myAccount/nlgl/txjl")
    public String myAccountNlglTxjl(Model model){
        ReturnModel returnModel = webService.selectLoginuserAccountJbxx();
        model.addAttribute("loginuserAccountNlgl", returnModel.getObject());
        return "web/myAccount/nlgl/txjl";
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
