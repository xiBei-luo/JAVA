package com.greenplatform.service.plateImpl;

import com.greenplatform.aop.OperationLog;
import com.greenplatform.dao.PlateDao;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

@Transactional
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

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateuser(PlateUser plateUser, HttpSession session) {
        List plateUserList;

        PlateUser plateUser1 = new PlateUser();
        //1.判断邮箱或用户名是否被注册
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
        //2.判断用户名是否被注册
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
        //3.新增用户
        String majorKey = UUID.randomUUID().toString().replaceAll("-", "");
        plateUser.setcPassword(MD5.md5(plateUser.getcPassword()));
        plateUser.setcUserid(majorKey);
        plateUser.setdCjsj(timestamp);
        plateUser.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
        plateDao.insertPlateuser(plateUser);
        //4.查询数据库查看是否新增成功
        plateUserList = plateDao.selectPlateuser(plateUser);
        if (plateUserList.isEmpty()){
            returnModel.setFlag(1);
            returnModel.setObject(null);
            if ("1".equals(plateUser.getcRylb())){
                returnModel.setMsg("新增用户失败,系统错误!");
            }else {
                returnModel.setMsg("注册失败，系统错误!");
            }
            return returnModel;
        }else{
            returnModel.setFlag(0);
            returnModel.setObject(null);
            if ("1".equals(plateUser.getcRylb())){
                returnModel.setMsg("新增用户成功!");
            }else {
                session.setAttribute("loginUser",plateUser);//前端用户注册成功后写入session
                returnModel.setMsg("注册成功!");
            }
            return  returnModel;
        }

    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateuser(PlateUser plateUser) {
        PlateUser plateUser1 = new PlateUser();
        plateUser1.setcUserid(plateUser.getcUserid());
        List plateUserList = plateDao.selectPlateuser(plateUser1);

        if (plateUserList.isEmpty()){
            returnModel.setFlag(1);
            returnModel.setMsg("删除用户失败，没有找到待删除的数据!");
            returnModel.setObject(null);
            return returnModel;
        }else{
            int ret = plateDao.delPlateuser(plateUser);
            if (1 == ret){
                returnModel.setFlag(0);
                returnModel.setMsg("删除用户成功!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                returnModel.setFlag(1);
                returnModel.setMsg("删除用户失败，服务器端错误!");
                returnModel.setObject(null);
                return returnModel;
            }
        }
    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateuser(PlateUser plateUser) {
        PlateUser plateUser1 = new PlateUser();
        plateUser1.setcUserid(plateUser.getcUserid());
        List plateUserList = plateDao.selectPlateuser(plateUser1);
        if (plateUserList.isEmpty()){
            returnModel.setFlag(1);
            returnModel.setMsg("修改用户失败，没有找到待修改的数据!");
            returnModel.setObject(null);
            return returnModel;
        }else{
            plateUser.setdXgsj(timestamp);
            plateUser.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            int ret = plateDao.updPlateuser(plateUser);
            if (1 == ret){
                returnModel.setFlag(0);
                returnModel.setMsg("修改用户成功!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                returnModel.setFlag(1);
                returnModel.setMsg("修改用户失败，服务器端错误!");
                returnModel.setObject(null);
                return returnModel;
            }
        }
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

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        //1.判断代码类别是否已存在
        PlateCodeDmlb plateCodeDmlb1 = new PlateCodeDmlb();
        plateCodeDmlb1.setcDmlb(plateCodeDmlb.getcDmlb());
        List plateCodeDmlbList = plateDao.selectPlateCodeDmlb(plateCodeDmlb1);
        if(!(plateCodeDmlbList.isEmpty())){
            returnModel.setFlag(1);
            returnModel.setMsg("新增出错，代码类别已存在！");
            returnModel.setObject(null);
            return returnModel;
        }
        //2.插入值
        plateCodeDmlb.setdCjsj(timestamp);
        plateCodeDmlb.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
        plateDao.insertPlateCodeDmlb(plateCodeDmlb);
        //3.判断是否插入成功
        plateCodeDmlbList = plateDao.selectPlateCodeDmlb(plateCodeDmlb);
        if (plateCodeDmlbList.isEmpty()){
            returnModel.setFlag(1);
            returnModel.setMsg("新增出错，系统错误！");
            returnModel.setObject(null);
            return returnModel;
        }else{
            returnModel.setFlag(0);
            returnModel.setMsg("新增成功！");
            returnModel.setObject(null);
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        //1.判断数据是否存在
        List plateCodeDmlbList = plateDao.selectPlateCodeDmlb(plateCodeDmlb);
        if (plateCodeDmlbList.isEmpty()){
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，待删除的数据不存在！");
            returnModel.setObject(null);
            return returnModel;
        }
        //2.执行删除
        plateDao.delPlateCodeDmlb(plateCodeDmlb);
        //3.判断删除是否成功
        plateCodeDmlbList = plateDao.selectPlateCodeDmlb(plateCodeDmlb);
        if (plateCodeDmlbList.isEmpty()){
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功！");
            returnModel.setObject(null);
            return returnModel;
        }else{
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            return returnModel;
        }

    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        plateCodeDmlb.setdXgsj(timestamp);
        plateCodeDmlb.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
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

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        return null;
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        return null;
    }

    @OperationLog(cCzfs = "U")
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
        plateDao.insertPlateLog(plateLog);
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

    @OperationLog(cCzfs = "I")
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

    @OperationLog(cCzfs = "D")
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

    @OperationLog(cCzfs = "U")
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

}
