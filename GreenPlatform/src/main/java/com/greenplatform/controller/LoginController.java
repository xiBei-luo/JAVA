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
        ReturnModel returnModel = new ReturnModel();
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        JSONObject jsonSessionParams = JSONObject.fromObject(session.getAttribute("smsCodeObj"));
        System.out.println(jsonParams);
        System.out.println(jsonSessionParams);

        String sessionSmsCode = jsonSessionParams.getString("smsCode");//session域中的验证码
        String smsCode = jsonParams.getString("smsCode");//传入的验证码

        System.out.println("页面传入的code"+smsCode);
        System.out.println("session中的code"+sessionSmsCode);

        //验证：手机号码是否匹配
        if (jsonParams.getString("cPhone").equals("")){
            returnModel.setFlag(1);
            returnModel.setMsg("手机号码不能为空！");
            returnModel.setObject(null);
            return returnModel;
        }else{
            if (!(jsonParams.getString("cPhone").equals(jsonSessionParams.getString("cPhone")))){
                returnModel.setFlag(1);
                returnModel.setMsg("当前手机号码与验证手机号码不一致");
                returnModel.setObject(null);
                return returnModel;
            }else{
                if(!(smsCode.equals(sessionSmsCode))){
                    returnModel.setFlag(1);
                    returnModel.setMsg("验证码错误！");
                    returnModel.setObject(null);
                    return returnModel;
                }
                if((System.currentTimeMillis() - jsonSessionParams.getLong("createTime")) > 1000 * 60 * 5){
                    returnModel.setFlag(1);
                    returnModel.setMsg("验证码已过期，请重新获取！");
                    returnModel.setObject(null);
                    return returnModel;
                }
            }

        }

        session.removeAttribute("smsCodeObj");
        PlateUser plateUser = new PlateUser();
        plateUser.setcZcfs("1");
        plateUser.setcPhone(jsonParams.getString("cPhone"));
        plateUser.setcLoginname(jsonParams.getString("cLoginname"));
        plateUser.setcPassword(jsonParams.getString("cPassword"));
        plateUser.setcRylb(jsonParams.getString("cRylb"));
        returnModel = loginService.doRegister(plateUser,session);
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
        if (false == loginService.checkUser("loginname",plateUser.getcLoginname())){
            returnModel.setFlag(1);
            returnModel.setMsg("用户名已经被注册");
            returnModel.setObject(null);
        }else if (false == loginService.checkUser("phone",plateUser.getcPhone())){
            returnModel.setFlag(1);
            returnModel.setMsg("手机号已经被注册");
            returnModel.setObject(null);
        }else{
            returnModel = GetMessageCode.getCode(plateUser.getcPhone(),session);
            System.out.println(session.getAttribute("smsCodeObj"));
        }
        return returnModel;
    }
}
