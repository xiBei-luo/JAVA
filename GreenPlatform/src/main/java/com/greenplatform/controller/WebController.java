package com.greenplatform.controller;

import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.WebService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.ReadFileUtil;
import com.greenplatform.util.returnUtil.ReturnModelHandler;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * Created by Luowenlv on 2019/5/7,11:25
 * 网站前端相关
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {
    @Autowired
    WebService webService;

    /**
     * 查询首页所需信息（当前人当日任务完成情况，能量汇总排行前十，商品明细）
     * @param model
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model) {
        ReturnModel returnModel = webService.selectLoginuserHome();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "web/index";
    }

    /**
     * 查询登录用户信息（人员姓名，人员等级，能量总量，种子汇总，今日任务）
     * @return
     */
    @RequestMapping(value = "/selectLoginuserAccount",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel selectLoginuserAccount(){
        ReturnModel returnModel = new ReturnModel();
        returnModel = webService.selectLoginuserAccount();
        return returnModel;
    }

    //能量种子商店兑换种子
    @RequestMapping(value = "/buySeeds",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel buySeeds(TGreenZzZjzzmx tGreenZzZjzzmx){
        ReturnModel returnModel = new ReturnModel();
        returnModel = webService.buySeeds(tGreenZzZjzzmx);
        return returnModel;
    }

    //完成每日基础任务
    @RequestMapping(value = "/accomplishRw",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel accomplishRw(TGreenRwRwmx tGreenRwRwmx){
        ReturnModel returnModel = new ReturnModel();
        returnModel = webService.accomplishRw(tGreenRwRwmx);
        return returnModel;
    }

    //点赞业务
    @RequestMapping(value = "/doLike",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel doLike(){
        ReturnModel returnModel = webService.doLike();
        return returnModel;
    }

    //实名认证（调用支付宝或微信接口）
    @RequestMapping(value = "/certification",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel certification(PlateUser plateUser, HttpSession session){
        PlateUser plateUser1 = GetcurrentLoginUser.getCurrentUser();
        plateUser1.setcUsername(plateUser.getcUsername());
        plateUser1.setcPhone(plateUser.getcPhone());
        plateUser1.setcZjhm(plateUser.getcZjhm());

        ReturnModel returnModel = webService.certification(plateUser1,session);
        return returnModel;
    }

    //捐赠业务
    @RequestMapping(value = "/contributeSeed",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel contributeSeed(String cLsh,String cSpbh){
        return webService.contributeSeed(cLsh,cSpbh);
    }

    //查询充值历史
    @RequestMapping(value = "/selectTGreenNlCzjl",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel selectTGreenNlCzjl(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        return webService.selectTGreenNlCzjl(jsonParams);
    }
    //查询提现历史
    @RequestMapping(value = "/selectTGreenNlTxjl",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel selectTGreenNlTxjl(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        return webService.selectTGreenNlTxjl(jsonParams);
    }
    //查询捐赠历史
    @RequestMapping(value = "/selectTGreenZzJzjl",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel selectTGreenZzJzjl(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        return webService.selectTGreenZzJzjl(jsonParams);
    }

    //测试瓜分能量接口
    @RequestMapping(value = "/divideNl",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel divideNl(){
        try {
            webService.divideNl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ReturnModelHandler.success(null);
    }

    //获取邀请二维码
    @GetMapping(value = "/getInviteQrcode")
    public void getInviteQrcode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ReturnModel returnModel = webService.getInviteQrcode(httpServletRequest);

        String filePath = returnModel.getObject().toString();
        try{
            byte data[] = ReadFileUtil.readFile(filePath);
            httpServletResponse.setContentType("image/jpg"); //设置返回的文件类型
            OutputStream os = httpServletResponse.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }



}
