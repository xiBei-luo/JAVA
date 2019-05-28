package com.greenplatform.service.systemImpl;

import com.greenplatform.aop.OperationLog;
import com.greenplatform.dao.SystemDao;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.SystemService;
import com.greenplatform.util.GetcurrentLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    SystemDao systemDao;


    ReturnModel returnModel = new ReturnModel();
   /* Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String localDate = df.format(date);
*/

    /*@Override
    public ReturnModel selectSystemuser(SystemUser systemUser) {
        systemUser.setcPassword(MD5.md5(systemUser.getcPassword()));
        List systemUserList = systemDao.selectPlateuser(systemUser);
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
    }*/

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
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return returnModel;
    }

    @Override
    public ReturnModel insertTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        tGreenSpSpmx.setcSpbh(UUID.randomUUID().toString().replaceAll("-", ""));
        tGreenSpSpmx.setdCjsj(getTimestamp(new Date()));
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
        tGreenSpSpmx.setdXgsj(getTimestamp(new Date()));
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

    @Override
    public ReturnModel selectTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
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

    @Override
    public ReturnModel selectTGreenNlZjnlmx(TGreenNlZjnlmx tGreenNlZjnlmx) {
        return null;
    }

    @Override
    public ReturnModel insertTGreenNlZjnlmx(TGreenNlZjnlmx tGreenNlZjnlmx) {
        return null;
    }

    @Override
    public ReturnModel delTGreenNlZjnlmx(TGreenNlZjnlmx tGreenNlZjnlmx) {
        return null;
    }

    @Override
    public ReturnModel updTGreenNlZjnlmx(TGreenNlZjnlmx tGreenNlZjnlmx) {
        return null;
    }

    @Override
    public ReturnModel selectTGreenRwRwmx(TGreenRwRwmx tGreenRwRwmx) {
        return null;
    }

    @Override
    @OperationLog(cCzfs = "I")
    public ReturnModel insertTGreenRwRwmx(TGreenRwRwmx tGreenRwRwmx) {
        try{
            String localDateDay = (getLocalDate(new Date())).substring(0,10);
            String localDateMonth = (getLocalDate(new Date())).substring(0,7);
            System.out.println(localDateDay+"==="+localDateMonth);
            tGreenRwRwmx.setcUserid(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenRwRwmx.setcRwday(localDateDay);
            List tGreenRwRwmxList = systemDao.selectTGreenRwRwmx(tGreenRwRwmx);
            if(!(tGreenRwRwmxList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setMsg("您今天已完成该项任务了！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                tGreenRwRwmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                tGreenRwRwmx.setdCjsj(getTimestamp(new Date()));
                tGreenRwRwmx.setcRwmouth(localDateMonth);
                tGreenRwRwmx.setdRwsj(getTimestamp(new Date()));

                System.out.println("任务明细对象--"+tGreenRwRwmx);
                systemDao.insertTGreenRwRwmx(tGreenRwRwmx);
                returnModel.setFlag(0);
                returnModel.setMsg("恭喜你，完成任务！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作出错，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @Override
    public ReturnModel delTGreenRwRwmx(TGreenRwRwmx tGreenRwRwmx) {
        return null;
    }

    @Override
    public ReturnModel updTGreenRwRwmx(TGreenRwRwmx tGreenRwRwmx) {
        return null;
    }

    @Override
    public ReturnModel selectTGreenZzZjzzmx(TGreenZzZjzzmx tGreenZzZjzzmx) {
        return null;
    }

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertTGreenZzZjzzmx(TGreenZzZjzzmx tGreenZzZjzzmx) {
        //tGreenZzZjzzmx  商品编号必传
        if (null == tGreenZzZjzzmx.getcSpbh() || "".equals(tGreenZzZjzzmx)){
            returnModel.setFlag(1);
            returnModel.setMsg("兑换种子编号不能为空！");
            returnModel.setObject(null);
            return returnModel;
        }
        try{
            PlateUser plateUser = new PlateUser();
            plateUser.setcUserid(GetcurrentLoginUser.getCurrentUser().getcUserid());
            TGreenZzZjzzmx tGreenZzZjzzmx1 = new TGreenZzZjzzmx();
            tGreenZzZjzzmx1.setcUserid(plateUser.getcUserid());
            tGreenZzZjzzmx1.setcSfjz("0");
            List tGreenZzZjzzmxList = systemDao.selectTGreenZzZjzzmx(tGreenZzZjzzmx1);
            int tGreenZzZjzzmxCount = tGreenZzZjzzmxList.size();
            System.out.println("指定账户下没有捐赠的种子数量--"+tGreenZzZjzzmxCount);
            if (tGreenZzZjzzmxCount > 3){
                returnModel.setFlag(1);
                returnModel.setMsg("您正在种植的植物数量已经有三种，无法进行兑换！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                TGreenNlHz tGreenNlHz = new TGreenNlHz();//获取指定用户的能量总量
                tGreenNlHz.setcUserid(plateUser.getcUserid());
                List tGreenNlHzList = systemDao.selectTGreenNlHz(tGreenNlHz);
                Integer userNlzl = Integer.parseInt(((TGreenNlHz) tGreenNlHzList.get(0)).getcNlhz());//获取指定账户的能量总量

                TGreenSpSpmx tGreenSpSpmx = new TGreenSpSpmx();//获取用户点击兑换种子的价格
                tGreenSpSpmx.setcSpbh(tGreenZzZjzzmx.getcSpbh());
                List tGreenSpSpmxList = systemDao.selectTGreenSpSpmx(tGreenSpSpmx);
                Integer zzPrice = Integer.parseInt(((TGreenSpSpmx) tGreenSpSpmxList.get(0)).getcSpjg());//获取种子的价格

                if (tGreenNlHzList.isEmpty()){
                    returnModel.setFlag(1);
                    returnModel.setMsg("您的能量不足，快去完成任务获取能量吧！");
                    returnModel.setObject(null);
                }else if(userNlzl < zzPrice) {
                    returnModel.setFlag(1);
                    returnModel.setMsg("您的能量不足，快去完成任务获取能量吧！");
                    returnModel.setObject(null);
                }else{
                    System.out.println("进行兑换");
                    TGreenNlJsnlmx tGreenNlJsnlmx = new TGreenNlJsnlmx();
                    tGreenNlJsnlmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
                    tGreenNlJsnlmx.setcUserid(plateUser.getcUserid());
                    tGreenNlJsnlmx.setcJssl(zzPrice.toString());
                    tGreenNlJsnlmx.setcJsyy("1");//减少原因：兑换商品
                    tGreenNlJsnlmx.setdJssj(getTimestamp(new Date()));
                    tGreenNlJsnlmx.setcZt("1");
                    tGreenNlJsnlmx.setcCjuser(plateUser.getcUserid());
                    tGreenNlJsnlmx.setdCjsj(getTimestamp(new Date()));
                    systemDao.insertTGreenNlJsnlmx(tGreenNlJsnlmx);

                    tGreenNlHz.setcNlhz(String.valueOf((userNlzl-zzPrice)));
                    tGreenNlHz.setcXguser(plateUser.getcUserid());
                    tGreenNlHz.setdXgsj(getTimestamp(new Date()));
                    System.out.println("修改能量汇总表"+tGreenNlHz);
                    systemDao.updTGreenNlHz(tGreenNlHz);

                    tGreenZzZjzzmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
                    tGreenZzZjzzmx.setcUserid(plateUser.getcUserid());
                    tGreenZzZjzzmx.setcZjyy("1");
                    tGreenZzZjzzmx.setdZjsj(getTimestamp(new Date()));
                    tGreenZzZjzzmx.setcKjz("0");
                    tGreenZzZjzzmx.setcSfjz("0");
                    tGreenZzZjzzmx.setcZt("1");
                    tGreenZzZjzzmx.setcCjuser(plateUser.getcUserid());
                    tGreenZzZjzzmx.setdCjsj(getTimestamp(new Date()));
                    System.out.println("新增种子增加明细表"+tGreenZzZjzzmx);
                    systemDao.insertTGreenZzZjzzmx(tGreenZzZjzzmx);
                    returnModel.setFlag(0);
                    returnModel.setMsg("");
                    returnModel.setObject(tGreenZzZjzzmx);
                }
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("兑换失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @Override
    public ReturnModel delTGreenZzZjzzmx(TGreenZzZjzzmx tGreenZzZjzzmx) {
        return null;
    }

    @Override
    public ReturnModel updTGreenZzZjzzmx(TGreenZzZjzzmx tGreenZzZjzzmx) {
        return null;
    }

    @Override
    public ReturnModel selectLoginuserAccount() {
        PlateUser plateUser = new PlateUser();
        TGreenNlHz tGreenNlHz = new TGreenNlHz();
        TGreenZzZjzzmx tGreenZzZjzzmx = new TGreenZzZjzzmx();
        TGreenRwRwmx tGreenRwRwmx = new TGreenRwRwmx();
        Map loginuserAccountMap;
        try{
            String loginUserId = GetcurrentLoginUser.getCurrentUser().getcUserid();
            if ("".equals(loginUserId) || null == loginUserId){
                returnModel.setFlag(1);
                returnModel.setMsg("查询失败，人员编号不能为空");
                returnModel.setObject(null);
                return returnModel;
            }else {
                plateUser.setcUserid(loginUserId);
                tGreenNlHz.setcUserid(loginUserId);
                tGreenZzZjzzmx.setcUserid(loginUserId);
                tGreenZzZjzzmx.setcSfjz("0");
                tGreenRwRwmx.setcUserid(loginUserId);
                tGreenRwRwmx.setcRwday(getLocalDate(new Date()).substring(0,10));

                System.out.println("登陆用户基本信息参数--"+plateUser);
                System.out.println("登陆用户能量信息参数--"+tGreenNlHz);
                System.out.println("登陆用户种子信息参数--"+tGreenZzZjzzmx);
                System.out.println("登陆用户任务信息参数--"+tGreenRwRwmx);

                List plateuserList = systemDao.selectPlateuser(plateUser);//人员姓名与人员等级

                List tGreenNlHzList = systemDao.selectTGreenNlHz(tGreenNlHz);//查询能量总量

                List tGreenZzZjzzmxList = systemDao.selectTGreenZzZjzzmx(tGreenZzZjzzmx);//查询种子明细

                List tGreenRwRwmxList = systemDao.selectTGreenRwRwmx(tGreenRwRwmx);//查询当日任务完成情况明细

                System.out.println("登陆用户基本信息--"+plateuserList);
                System.out.println("登陆用户能量信息--"+tGreenNlHzList);
                System.out.println("登陆用户种子信息--"+tGreenZzZjzzmxList);
                System.out.println("登陆用户任务信息--"+tGreenRwRwmxList);
                loginuserAccountMap = new HashMap();
                loginuserAccountMap.put("plateUser",plateuserList);
                loginuserAccountMap.put("tGreenNlHz",tGreenNlHzList);
                loginuserAccountMap.put("tGreenZzZjzzmx",tGreenZzZjzzmxList);
                loginuserAccountMap.put("tGreenRwRwmx",tGreenRwRwmxList);

                returnModel.setFlag(0);
                returnModel.setMsg("查询成功");
                returnModel.setObject(loginuserAccountMap);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("查询失败，系统错误");
            returnModel.setObject(null);
            return returnModel;
        }
    }

    //获取当前系统时间timestamp
    public Timestamp getTimestamp(Date date){
        if (null == date){
            date = new Date();
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
    //获取系统当前时间   2019-05-22 16:35:01
    public String getLocalDate(Date date){
        if (null == date){
            date = new Date();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String localDate = df.format(date);
        return localDate;
    }


}
