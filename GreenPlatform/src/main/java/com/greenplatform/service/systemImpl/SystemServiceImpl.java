package com.greenplatform.service.systemImpl;

import com.greenplatform.dao.SystemDao;
import com.greenplatform.model.PlateUser;
import com.greenplatform.model.SystemUser;
import com.greenplatform.model.TGreenSpSpmx;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.SystemService;
import com.greenplatform.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    SystemDao systemDao;
    ReturnModel returnModel = new ReturnModel();
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    @Override
    public ReturnModel selectSystemuser(SystemUser systemUser) {
        systemUser.setcPassword(MD5.md5(systemUser.getcPassword()));
        List systemUserList = systemDao.selectSystemuser(systemUser);
        if (!systemUserList.isEmpty()){
            returnModel.setFlag(0);
            returnModel.setMsg("登陆成功");
            returnModel.setObject(systemUserList);
        }else{
            returnModel.setFlag(1);
            returnModel.setMsg("登录名或密码错误");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel insertSystemUser(SystemUser systemUser) {
        SystemUser systemUser1 = new SystemUser();
        try{
            systemUser1.setcEmail(systemUser.getcEmail());
            List systemUserList1 = systemDao.selectSystemuser(systemUser1);
            if (!systemUserList1.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("注册失败，邮箱已经被注册!");
                returnModel.setObject(null);
                return returnModel;
            }
            systemUser1.setcEmail(null);
            systemUser1.setcLoginname(systemUser.getcLoginname());
            List systemUserList = systemDao.selectSystemuser(systemUser1);
            if (!systemUserList.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("注册失败，用户名已存在!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("注册失败，系统错误!");
            returnModel.setObject(null);
            return returnModel;
        }
        String majorKey = UUID.randomUUID().toString().replaceAll("-", "");
        systemUser.setcUserid(majorKey);
        systemUser.setcPassword(MD5.md5(systemUser.getcPassword()));
        systemUser.setdCjsj(timestamp);
        try{
            systemDao.insertSystemUser(systemUser);
            returnModel.setFlag(0);
            returnModel.setMsg("注册成功!");
            returnModel.setObject(null);
        }catch(Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("注册失败，系统错误!");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel delSystemuser(SystemUser systemUser) {
        return null;
    }

    @Override
    public ReturnModel updSystemuser(SystemUser systemUser) {
        return null;
    }

    @Override
    public ReturnModel selectTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        List tGreenSpmxList;
        try {
            tGreenSpmxList = systemDao.selectTGreenSpSpmx(tGreenSpSpmx);
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
            systemDao.insertTGreenSpSpmx(tGreenSpSpmx);
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
            systemDao.delTGreenSpSpmx(tGreenSpSpmx);
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
            systemDao.updTGreenSpSpmx(tGreenSpSpmx);
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
}
