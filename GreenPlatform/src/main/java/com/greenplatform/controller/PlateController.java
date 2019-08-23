package com.greenplatform.controller;

import com.alibaba.fastjson.JSON;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.util.GetcurrentLoginUser;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Luowenlv on 2019/5/7,11:25
 * 后台相关
 */
@RestController
@RequestMapping(value = "/plate")
public class PlateController {

    @Autowired
    PlateService plateService;

    @PostMapping(value = "/getLoginUser")
    public ReturnModel getLoginUser(){
        ReturnModel returnModel = new ReturnModel();
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateUser);
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("获取登录用户信息失败，"+e);
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @PostMapping(value = "/getDmmc")
    public ReturnModel getDmmc(String cDmlb,String cDm){
        ReturnModel returnModel = new ReturnModel();
        return returnModel;
    }

    @PostMapping(value = "/selectPlateuser")
    public ReturnModel selectPlateuser(PlateUser plateUser){
        ReturnModel returnModel = plateService.selectPlateuser(plateUser);
        return returnModel;
    }

    @PostMapping(value = "/selectWebUser")
    public ReturnModel selectWebUser(PlateUser plateUser){
        ReturnModel returnModel = plateService.selectWebUser(plateUser);
        return returnModel;
    }

    @PostMapping(value = "/insertPlateuser")
    public ReturnModel insertPlateuser(PlateUser plateUser){
        ReturnModel returnModel = plateService.insertPlateuser(plateUser);
        return returnModel;
    }

    @PostMapping(value = "/retsetPass")
    public ReturnModel retPass(PlateUser plateUser){
        ReturnModel returnModel = plateService.retsetPass(plateUser);
        return returnModel;
    }

    @PostMapping(value = "/updPlateuser")
    public ReturnModel updPlateuser(PlateUser plateUser){
        ReturnModel returnModel = plateService.updPlateuser(plateUser);
        return returnModel;
    }

    @PostMapping(value = "/delPlateuser")
    public ReturnModel delPlateuser(PlateUser plateUser){
        ReturnModel returnModel = plateService.delPlateuser(plateUser);
        return returnModel;
    }
    @PostMapping(value = "/selectPlateCodeDmz")
    public ReturnModel selectPlateCodeDmz(PlateCodeDmz plateCodeDmz){
        ReturnModel returnModel = plateService.selectPlateCodeDmz(plateCodeDmz);
        return returnModel;
    }

    @PostMapping(value = "/selectTGreenSpSpmx")
    public ReturnModel selectTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx){
        ReturnModel returnModel = plateService.selectTGreenSpSpmx(tGreenSpSpmx);
        return returnModel;
    }

    @PostMapping(value = "/insertTGreenSpSpmx")
    public ReturnModel insertTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx){
        ReturnModel returnModel = plateService.insertTGreenSpSpmx(tGreenSpSpmx);
        return returnModel;
    }

    @PostMapping(value = "/delTGreenSpSpmx")
    public ReturnModel delTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx){
        ReturnModel returnModel = plateService.delTGreenSpSpmx(tGreenSpSpmx);
        return returnModel;
    }

    @PostMapping(value = "/updTGreenSpSpmx")
    public ReturnModel updTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx){
        ReturnModel returnModel = plateService.updTGreenSpSpmx(tGreenSpSpmx);
        return returnModel;
    }

    @PostMapping(value = "/selectTGreenRwRwmx")
    public ReturnModel selectTGreenRwRwmx(@RequestParam("cUsername") String cUsername,
                                          @RequestParam("cRwlb") String cRwlb){
        Map paramsMap = new HashMap();
        paramsMap.put("cUsername",cUsername);
        paramsMap.put("cRwlb",cRwlb);
        ReturnModel returnModel = plateService.selectTGreenRwRwmx(paramsMap);
        return returnModel;
    }

    @PostMapping(value = "/insertYwjcdm")
    public ReturnModel insertYwjcdm(PlateCodeDmlb plateCodeDmlb,PlateCodeDmz plateCodeDmz){
        ReturnModel returnModel = plateService.insertYwjcdm(plateCodeDmlb,plateCodeDmz);
        return returnModel;
    }

    @PostMapping(value = "/selectYwjcdm")
    public ReturnModel selectYwjcdm(@RequestParam("cDmlb") String cDmlb,
                                    @RequestParam("cDm") String cDm){
        Map params = new HashMap();
        params.put("cDmlb",cDmlb);
        params.put("cDm",cDm);
        ReturnModel returnModel = plateService.selectPlateCodeDmz(params);
        return returnModel;
    }

    @PostMapping(value = "/updYwjcdm")
    public ReturnModel updYwjcdm(PlateCodeDmlb plateCodeDmlb,PlateCodeDmz plateCodeDmz){
        ReturnModel returnModel = plateService.updYwjcdm(plateCodeDmlb,plateCodeDmz);
        return returnModel;
    }

    @PostMapping(value = "/delYwjcdm")
    public ReturnModel delYwjcdm(PlateCodeDmz plateCodeDmz){
        ReturnModel returnModel = plateService.delPlateCodeDmz(plateCodeDmz);
        return returnModel;
    }

    @PostMapping(value = "/selectPlateUserRole")
    public ReturnModel selectPlateUserRole(PlateUserRole plateUserRole){
        ReturnModel returnModel = plateService.selectPlateUserRole(plateUserRole);
        return returnModel;
    }

    @PostMapping(value = "/insertPlateUserRole")
    public ReturnModel insertPlateUserRole(PlateUserRole plateUserRole){
        ReturnModel returnModel = plateService.insertPlateUserRole(plateUserRole);
        return returnModel;
    }

    @PostMapping(value = "/updPlateUserRole")
    public ReturnModel updatePlateUserRole(PlateUserRole plateUserRole){
        ReturnModel returnModel = plateService.updPlateUserRole(plateUserRole);
        return returnModel;
    }
    @PostMapping(value = "/delPlateUserRole")
    public ReturnModel delPlateUserRole(PlateUserRole plateUserRole){
        ReturnModel returnModel = plateService.delPlateUserRole(plateUserRole);
        return returnModel;
    }

    @PostMapping(value = "/selectPlateYwLxMenu")
    public ReturnModel selectPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu){
        ReturnModel returnModel = plateService.selectPlateYwLxMenu(plateYwLxMenu);
        return returnModel;
    }
    @PostMapping(value = "/insertPlateYwLxMenu")
    public ReturnModel insertPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu){
        ReturnModel returnModel = plateService.insertPlateYwLxMenu(plateYwLxMenu);
        return returnModel;
    }
    @PostMapping(value = "/updPlateYwLxMenu")
    public ReturnModel updPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu){
        ReturnModel returnModel = plateService.updPlateYwLxMenu(plateYwLxMenu);
        return returnModel;
    }
    @PostMapping(value = "/delPlateYwLxMenu")
    public ReturnModel delPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu){
        ReturnModel returnModel = plateService.delPlateYwLxMenu(plateYwLxMenu);
        return returnModel;
    }

    @PostMapping(value = "/saveUserRolePermission")
    public ReturnModel saveUserRolePermission(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        ReturnModel returnModel = plateService.saveUserRolePermission(jsonParams);
        return returnModel;
    }

    @PostMapping(value = "/saveUserRoleMid")
    public ReturnModel saveUserRoleMid(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        ReturnModel returnModel = plateService.saveUserRoleMid(jsonParams);
        return returnModel;
    }
    @PostMapping(value = "/selectTGreenNlHz")
    public ReturnModel selectTGreenNlHz(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        ReturnModel returnModel = plateService.selectTGreenNlHz(jsonParams);
        return returnModel;
    }
    @PostMapping(value = "/selectPlateCodeXtcs")
    public ReturnModel selectPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs){
        ReturnModel returnModel = plateService.selectPlateCodeXtcs(plateCodeXtcs);
        return returnModel;
    }
    @PostMapping(value = "/insertPlateCodeXtcs")
    public ReturnModel insertPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs){
        ReturnModel returnModel = plateService.insertPlateCodeXtcs(plateCodeXtcs);
        return returnModel;
    }
    @PostMapping(value = "/updPlateCodeXtcs")
    public ReturnModel updPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs){
        ReturnModel returnModel = plateService.updPlateCodeXtcs(plateCodeXtcs);
        return returnModel;
    }
    @PostMapping(value = "/delPlateCodeXtcs")
    public ReturnModel delPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs){
        ReturnModel returnModel = plateService.delPlateCodeXtcs(plateCodeXtcs);
        return returnModel;
    }

    @PostMapping(value = "/insertTGreenNlCzjl")
    public ReturnModel insertTGreenNlCzjl(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        ReturnModel returnModel = plateService.insertTGreenNlCzjl(jsonParams);
        return returnModel;
    }

    @PostMapping(value = "/insertTGreenNlTxjl")
    public ReturnModel insertTGreenNlTxjl(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        ReturnModel returnModel = plateService.insertTGreenNlTxjl(jsonParams);
        return returnModel;
    }

    @PostMapping(value = "/insertPlateuserBlacklist")
    public ReturnModel insertPlateuserBlacklist(@RequestBody String jsonObject){
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);
        ReturnModel returnModel = plateService.insertPlateuserBlacklist(jsonParams);
        return returnModel;
    }


}
