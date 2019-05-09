package com.greenplatform.service.plateImpl;

import com.greenplatform.dao.PlateDao;
import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
public class PlateServiceImpl implements PlateService {
    ReturnModel returnModel = new ReturnModel();;
    @Autowired
    PlateDao plateDao;
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());


    @Override
    public ReturnModel checkLogin(PlateUser plateUser) {

        PlateUser plateUser1 = plateDao.checkLogin(plateUser);
        System.out.println(plateUser1);

        if (null != plateUser1 && "" != plateUser1.getCUserid()){
            returnModel.setFlag(0);
            returnModel.setMsg("登陆成功");
            returnModel.setObject(plateUser1);
        }else if(null == plateUser1){
            returnModel.setFlag(1);
            returnModel.setMsg("登录名或密码错误");
            returnModel.setObject(null);
        }
        System.out.println( returnModel);
        return returnModel;
    }

    @Override
    public ReturnModel selectUserByEmail(PlateUser plateUser) {
        PlateUser plateUser1 = plateDao.selectUserByEmail(plateUser);
        if (null != plateUser1){
            returnModel.setFlag(1);
            returnModel.setMsg("邮箱已经被注册!");
            returnModel.setObject(null);
        }else{
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel selectUserByLoginname(PlateUser plateUser) {
        PlateUser plateUser1 = plateDao.selectUserByLoginname(plateUser);
        if (null != plateUser1){
            returnModel.setFlag(1);
            returnModel.setMsg("会员名已经被注册!");
            returnModel.setObject(null);
        }else{
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel insertUser(PlateUser plateUser) {

        PlateUser plateUser1 = plateDao.insertUser(plateUser);
        if (null != plateUser1){
            returnModel.setFlag(1);
            returnModel.setMsg("用户名已存在，请更换!");
            returnModel.setObject(null);
        }/*else{
            PlateUser plateUser2 = plateDao.register(plateUser);
            String majorKey = getUUID();
            plateUser2.setCUserid(majorKey);
            plateUser2.setDCjsj(timestamp);
            PlateUser plateUser3 = plateDao.checkRegister(plateUser2);
            if (null != plateUser3 && ("" != plateUser3.getCUserid())){
                returnModel.setFlag(0);
                returnModel.setMsg("注册成功!");
                returnModel.setObject(plateUser3);
            }else{
                returnModel.setFlag(1);
                returnModel.setMsg("注册失败!");
                returnModel.setObject(null);
            }
        }*/
        return returnModel;
    }


    public String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
        return uuid;
    }
}
