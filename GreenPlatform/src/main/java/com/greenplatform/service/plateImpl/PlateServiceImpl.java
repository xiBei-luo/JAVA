package com.greenplatform.service.plateImpl;

import com.greenplatform.dao.PlateDao;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

@Service
public class PlateServiceImpl implements PlateService {
    ReturnModel returnModel = new ReturnModel();
    @Autowired
    PlateDao plateDao;

    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());


    @Override
    public ReturnModel selectPlateuser(PlateUser plateUser, HttpSession session) {
        plateUser.setcPassword(MD5.md5(plateUser.getcPassword()));
        List plateUserList = plateDao.selectPlateuser(plateUser);

        if (plateUserList.isEmpty()){
            returnModel.setFlag(1);
            returnModel.setMsg("登录名或密码错误");
            returnModel.setObject(null);
        }else{
            returnModel.setFlag(0);
            returnModel.setMsg("登陆成功");
            returnModel.setObject(plateUserList);
            PlateUser plateUser1 = (PlateUser) plateUserList.get(0);

            session.setAttribute("loginUser",plateUser1);
        }
        return returnModel;
    }

    @Override
    public ReturnModel selectPlateuser(PlateUser plateUser) {
        System.out.println(plateUser);
        List plateUserList;
        try{
            plateUserList = plateDao.selectPlateuser(plateUser);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateUserList);
        }catch(Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("系统错误");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel insertPlateuser(PlateUser plateUser, HttpSession session) {
        List plateUserList;

        PlateUser plateUser1 = new PlateUser();
        //1.判断邮箱或用户名是否被注册
        try{
            plateUser1.setcRylb(plateUser.getcRylb());

            plateUser1.setcEmail(plateUser.getcEmail());
            plateUserList = plateDao.selectPlateuser(plateUser1);
            if (!(plateUserList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                if ("1".equals(plateUser.getcRylb())){
                    returnModel.setMsg("新增用户失败，邮箱已经被注册!");
                }else {
                    returnModel.setMsg("注册失败，邮箱已经被注册!");
                }
                return returnModel;
            }
            plateUser1.setcEmail("");
            plateUser1.setcLoginname(plateUser.getcLoginname());
            plateUserList = plateDao.selectPlateuser(plateUser1);
            if (!(plateUserList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                if ("1".equals(plateUser.getcRylb())){
                    returnModel.setMsg("新增用户失败，用户名已经被注册!");
                }else {
                    returnModel.setMsg("注册失败，用户名已经被注册!");
                }
                return returnModel;
            }
            String majorKey = UUID.randomUUID().toString().replaceAll("-", "");
            plateUser.setcPassword(MD5.md5(plateUser.getcPassword()));
            plateUser.setcUserid(majorKey);
            plateUser.setdCjsj(timestamp);
            plateDao.insertPlateuser(plateUser);
            returnModel.setFlag(0);
            returnModel.setObject(null);
            if ("1".equals(plateUser.getcRylb())){
                returnModel.setMsg("新增用户成功!");
            }else {
                session.setAttribute("loginUser",plateUser);
                returnModel.setMsg("注册成功!");
            }
        }catch( Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setObject(null);
            if ("1".equals(plateUser.getcRylb())){
                returnModel.setMsg("新增用户失败!");
            }else {
                returnModel.setMsg("注册失败!");
            }
        }

        return returnModel;
    }

    @Override
    public ReturnModel delPlateuser(PlateUser plateUser, HttpSession session) {
        System.out.println("---"+getLoginUser(session));
        try{
            plateDao.delPlateuser(plateUser);
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("删除失败，系统错误!");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel updPlateuser(PlateUser plateUser) {
        try{
            plateUser.setdXgsj(timestamp);
            plateDao.updPlateuser(plateUser);
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("修改用户失败，系统错误!");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel selectPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        List plateCodeDmlbList;
        try {
            plateCodeDmlbList = plateDao.selectPlateCodeDmlb(plateCodeDmlb);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateCodeDmlbList);
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel insertPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        plateCodeDmlb.setdCjsj(timestamp);
        try {
            plateDao.insertPlateCodeDmlb(plateCodeDmlb);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(null);
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("新增出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel delPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        try {
            plateDao.delPlateCodeDmlb(plateCodeDmlb);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功！");
            returnModel.setObject(null);
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel updPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        plateCodeDmlb.setdXgsj(timestamp);
        try {
            plateDao.updPlateCodeDmlb(plateCodeDmlb);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功！");
            returnModel.setObject(null);
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel selectPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        List plateCodeDmzList;
        try{
            plateCodeDmzList = plateDao.selectPlateCodeDmz(plateCodeDmz);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功!");
            returnModel.setObject(plateCodeDmzList);
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误!");
            returnModel.setObject(null);
        }

        return returnModel;
    }

    @Override
    public ReturnModel insertPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        return null;
    }

    @Override
    public ReturnModel delPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        return null;
    }

    @Override
    public ReturnModel updPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        return null;
    }

    @Override
    public ReturnModel selectPlateLog(PlateLog plateLog) {
        return null;
    }

    @Override
    public ReturnModel insertPlateLog(PlateLog plateLog) {
        return null;
    }

    @Override
    public ReturnModel selectTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        List tGreenSpmxList;
        try {
            tGreenSpmxList = plateDao.selectTGreenSpSpmx(tGreenSpSpmx);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(tGreenSpmxList);
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel insertTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        tGreenSpSpmx.setcSpbh(UUID.randomUUID().toString().replaceAll("-", ""));
        tGreenSpSpmx.setdCjsj(timestamp);
        try {
            plateDao.insertTGreenSpSpmx(tGreenSpSpmx);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(null);
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("新增出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel delTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try {
            plateDao.delTGreenSpSpmx(tGreenSpSpmx);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功！");
            returnModel.setObject(null);
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel updTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        tGreenSpSpmx.setdXgsj(timestamp);
        try {
            plateDao.updTGreenSpSpmx(tGreenSpSpmx);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功！");
            returnModel.setObject(null);
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel selectTGreenRwRwmx(TGreenRwRwmx tGreenRwRwmx) {
        List tGreenRwRwmxList;
        try {
            tGreenRwRwmxList = plateDao.selectTGreenRwRwmx(tGreenRwRwmx);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(tGreenRwRwmxList);
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    public PlateUser getLoginUser(HttpSession session){
        return (PlateUser) session.getAttribute("loginUser");
    }


}
