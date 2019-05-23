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
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class PlateServiceImpl implements PlateService {
    //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

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
        try{
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
            //3.新增用户（注册用户）
            String majorKey = UUID.randomUUID().toString().replaceAll("-", "");
            plateUser.setcPassword(MD5.md5(plateUser.getcPassword()));
            plateUser.setcUserid(majorKey);
            plateUser.setdCjsj(timestamp);
            if("1".equals(plateUser.getcRylb())){
                plateUser.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            }
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
                //平台用户注册成功则对应账户账户增加100能量
                if ("2".equals(plateUser.getcRylb())){
                    TGreenNlZjnlmx tGreenNlZjnlmx = new TGreenNlZjnlmx();
                    tGreenNlZjnlmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
                    tGreenNlZjnlmx.setcUserid(plateUser.getcUserid());
                    tGreenNlZjnlmx.setcZjsl("100");
                    tGreenNlZjnlmx.setdZjsj(timestamp);
                    tGreenNlZjnlmx.setcZjyy("1");
                    tGreenNlZjnlmx.setcZt("1");
                    tGreenNlZjnlmx.setcCjuser(plateUser.getcUserid());
                    tGreenNlZjnlmx.setdCjsj(timestamp);

                    TGreenNlHz tGreenNlHz = new TGreenNlHz();
                    tGreenNlHz.setcUserid(plateUser.getcUserid());
                    tGreenNlHz.setcNlzl("100");
                    tGreenNlHz.setcZt("1");
                    tGreenNlHz.setcCjuser(plateUser.getcUserid());
                    tGreenNlHz.setdCjsj(timestamp);

                    plateDao.insertTGreenNlZjnlmx(tGreenNlZjnlmx);
                    plateDao.insertTGreenNlHz(tGreenNlHz);
                    session.setAttribute("loginUser",plateUser);//前端用户注册成功后写入session
                    returnModel.setFlag(0);
                    returnModel.setObject(null);
                    returnModel.setMsg("注册成功!");
                }else{
                    returnModel.setFlag(0);
                    returnModel.setObject(null);
                    returnModel.setMsg("新增用户成功!");
                }
                return  returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setObject(null);
            if ("1".equals(plateUser.getcRylb())){
                returnModel.setMsg("新增用户失败,系统错误!");
            }else {
                returnModel.setMsg("注册失败，系统错误!");
            }
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateuser(PlateUser plateUser) {
        try{
            PlateUser plateUser1 = new PlateUser();
            plateUser1.setcUserid(plateUser.getcUserid());
            List plateUserList = plateDao.selectPlateuser(plateUser1);
            if (plateUserList.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("删除用户失败，没有找到待删除的数据!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateDao.delPlateuser(plateUser);
                returnModel.setFlag(1);
                returnModel.setMsg("删除成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("删除用户失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateuser(PlateUser plateUser) {
        try{
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
                plateDao.updPlateuser(plateUser);
                returnModel.setFlag(0);
                returnModel.setMsg("修改用户成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("修改用户失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
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
        try{
            //1.判断代码类别是否已存在
            PlateCodeDmlb plateCodeDmlb1 = new PlateCodeDmlb();
            plateCodeDmlb1.setcDmlb(plateCodeDmlb.getcDmlb());
            List plateCodeDmlbList = plateDao.selectPlateCodeDmlb(plateCodeDmlb1);
            if(!(plateCodeDmlbList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setMsg("新增出错，代码类别已存在！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //2.插入值
                plateCodeDmlb.setdCjsj(timestamp);
                plateCodeDmlb.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateDao.insertPlateCodeDmlb(plateCodeDmlb);
                returnModel.setFlag(0);
                returnModel.setMsg("新增成功！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("新增出错，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        try{
            //1.判断数据是否存在
            List plateCodeDmlbList = plateDao.selectPlateCodeDmlb(plateCodeDmlb);
            if (plateCodeDmlbList.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，待删除的数据不存在！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //2.执行删除
                plateDao.delPlateCodeDmlb(plateCodeDmlb);
                returnModel.setFlag(0);
                returnModel.setMsg("操作成功！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        try{
            //1.判断数据是否存在
            PlateCodeDmlb plateCodeDmlb1 = new PlateCodeDmlb();
            plateCodeDmlb1.setcDmlb(plateCodeDmlb.getcDmlb());
            List plateCodeDmlbList = plateDao.selectPlateCodeDmlb(plateCodeDmlb1);
            if (!(plateCodeDmlbList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，待修改的数据不存在！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateCodeDmlb.setdXgsj(timestamp);
                plateCodeDmlb.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateDao.updPlateCodeDmlb(plateCodeDmlb);
                returnModel.setFlag(0);
                returnModel.setMsg("操作成功！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(0);
            returnModel.setMsg("操作失败，服务器端出错！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
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
        try{
            PlateCodeDmz plateCodeDmz1 = new PlateCodeDmz();
            plateCodeDmz1.setcDmlb(plateCodeDmz.getcDmlb());
            plateCodeDmz1.setcDm(plateCodeDmz.getcDm());
            //1.判断插入的数据是否有重复
            List plateCodeDmzList = plateDao.selectPlateCodeDmz(plateCodeDmz1);
            if (!(plateCodeDmzList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setMsg("新增出错，该代码类别下的代码值已存在！");
                returnModel.setObject(null);
                return returnModel;
            }else{

                plateCodeDmz.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmz.setdCjsj(timestamp);
                plateDao.insertPlateCodeDmz(plateCodeDmz);
                returnModel.setFlag(0);
                returnModel.setMsg("新增成功！");
                returnModel.setObject(plateCodeDmz);
                return returnModel;
            }
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("新增出错，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        try{
            //1.判断数据是否存在
            List plateCodeDmzList = plateDao.selectPlateCodeDmz(plateCodeDmz);
            if (plateCodeDmzList.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("删除失败，没有找到待删除的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateDao.delPlateCodeDmz(plateCodeDmz);
                returnModel.setFlag(0);
                returnModel.setMsg("删除成功");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("删除失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        try{
            //1.判断数据是否存在
            PlateCodeDmz plateCodeDmz1 = new PlateCodeDmz();
            plateCodeDmz1.setcDmlb(plateCodeDmz.getcDmlb());
            plateCodeDmz1.setcDm(plateCodeDmz.getcDm());
            List plateCodeDmzList = plateDao.selectPlateCodeDmz(plateCodeDmz1);
            if (plateCodeDmzList.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("修改失败，没有找到待修改的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //2.执行修改
                plateCodeDmz.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmz.setdXgsj(timestamp);
                plateDao.updPlateCodeDmz(plateCodeDmz);
                returnModel.setFlag(0);
                returnModel.setMsg("修改成功");
                returnModel.setObject(plateCodeDmz);
                return returnModel;
            }
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("修改失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @Override
    public ReturnModel insertPlateLog(PlateLog plateLog) {
        try{
            plateDao.insertPlateLog(plateLog);
        }catch (Exception e){
            e.printStackTrace();
        }
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
        try{
            tGreenSpSpmx.setcSpbh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenSpSpmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenSpSpmx.setdCjsj(timestamp);
            plateDao.insertTGreenSpSpmx(tGreenSpSpmx);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功");
            returnModel.setObject(tGreenSpSpmx);
            return returnModel;
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("新增出错，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try{
            List tGreenSpSpmxList = plateDao.selectTGreenSpSpmx(tGreenSpSpmx);
            if (tGreenSpSpmxList.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，没有找到待删除的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateDao.delTGreenSpSpmx(tGreenSpSpmx);
                returnModel.setFlag(0);
                returnModel.setMsg("操作成功！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }

    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try {
            //1.判断修改数据是否存在
            TGreenSpSpmx tGreenSpSpmx1 = new TGreenSpSpmx();
            tGreenSpSpmx.setcSpbh(tGreenSpSpmx.getcSpbh());
            List tGreenSpSpmxList = plateDao.selectTGreenSpSpmx(tGreenSpSpmx1);
            if (tGreenSpSpmxList.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，没有找到待删除的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                tGreenSpSpmx.setdXgsj(timestamp);
                plateDao.updTGreenSpSpmx(tGreenSpSpmx);
                returnModel.setFlag(0);
                returnModel.setMsg("操作成功！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            System.out.println(e);
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
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
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel selectTGreenNlHz(TGreenNlHz tGreenNlHz) {
        List tGreenNlHzList;
        try{
            tGreenNlHzList = plateDao.selectTGreenNlHz(tGreenNlHz);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(tGreenNlHzList);
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel insertTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

    @Override
    public ReturnModel delTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

    @Override
    public ReturnModel updTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

}
