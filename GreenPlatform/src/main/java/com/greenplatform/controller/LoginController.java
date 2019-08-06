package com.greenplatform.controller;

import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.LoginService;
import com.greenplatform.util.sendMsg.GetMessageCode;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    LoginService loginService;


    /**
     * 账号密码登陆
     * @param plateUser
     * @param session
     * @return
     */
    @PostMapping(value = "/login")
    public ReturnModel login(PlateUser plateUser, HttpSession session){
        ReturnModel returnModel = loginService.checkLogin(plateUser,session);
        System.out.println(returnModel);
        return returnModel;
    }

    @PostMapping(value = "/register")
    public ReturnModel register(@RequestBody String jsonObject, HttpSession session){

        ReturnModel returnModel = loginService.doRegister(jsonObject,session);
        return returnModel;
    }


    /**
     * 调用短信接口发送验证码
     * @param plateUser
     * @param session
     * @return
     */
    @PostMapping(value = "/getVerificationCode")
    public ReturnModel getVerificationCode(PlateUser plateUser, HttpSession session){
        System.out.println(plateUser);
        ReturnModel returnModel = new ReturnModel();
        returnModel = GetMessageCode.getCode(plateUser.getcPhone(),session);
        System.out.println(session.getAttribute("smsCodeObj"));
        return returnModel;
    }


    /**
     * 验证手机验证码
     * @param jsonObject
     * @param session
     * @return
     */
    @PostMapping(value = "/checkSmsCode")
    public ReturnModel checkSmsCode(@RequestBody String jsonObject, HttpSession session){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        Map hashMap = new HashMap();
        hashMap.put("cPhone",jsonParams.getString("cPhone"));
        hashMap.put("smsCode",jsonParams.getString("smsCode"));
        System.out.println("in controller params:"+jsonParams);
        ReturnModel returnModel = loginService.checkSmsCode(hashMap,session);
        System.out.println(returnModel);
        return returnModel;
    }

    /**
     * 修改账户密码
     * @param jsonObject
     * @param session
     * @return
     */
    @PostMapping(value = "/retWebUserPassowrd")
    public ReturnModel retWebUserPassowrd(@RequestBody String jsonObject, HttpSession session){
        ReturnModel returnModel = loginService.retWebUserPassowrd(jsonObject,session);
        System.out.println(returnModel);
        return returnModel;
    }


    /**
     * 手机验证码登陆
     * @param jsonObject
     * @param session
     * @return
     */
    @PostMapping(value = "/loginByPhone")
    public ReturnModel loginByPhone(@RequestBody String jsonObject, HttpSession session){
        return loginService.loginByPhone(jsonObject,session);
    }

}
