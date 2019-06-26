package com.greenplatform.service.systemImpl;

import com.greenplatform.aop.OperationLog;
import com.greenplatform.dao.*;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.SystemService;
import com.greenplatform.util.GetcurrentLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class SystemServiceImpl implements SystemService {
    /*@Autowired
    SystemDao systemDao;*/
    @Autowired
    TGreenSpSpmxMapper tGreenSpSpmxMapper;
    @Autowired
    TGreenRwRwmxMapper tGreenRwRwmxMapper;
    @Autowired
    PlateUserMapper plateUserMapper;
    @Autowired
    TGreenNlHzMapper tGreenNlHzMapper;
    @Autowired
    TGreenZzZjzzmxMapper tGreenZzZjzzmxMapper;
    @Autowired
    TGreenNlJsnlmxMapper tGreenNlJsnlmxMapper;


    ReturnModel returnModel = new ReturnModel();


    @Override
    public ReturnModel selectTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        List tGreenSpmxList;
        try {
            tGreenSpmxList = tGreenSpSpmxMapper.selectTGreenSpSpmx(tGreenSpSpmx);
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

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        tGreenSpSpmx.setcSpbh(UUID.randomUUID().toString().replaceAll("-", ""));
        tGreenSpSpmx.setdCjsj(getTimestamp(new Date()));
        tGreenSpSpmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
        try {
            tGreenSpSpmxMapper.insert(tGreenSpSpmx);
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
            TGreenSpSpmx tGreenSpSpmx1 = tGreenSpSpmxMapper.selectByPrimaryKey(tGreenSpSpmx.getcSpbh());
            if (null == tGreenSpSpmx1 || "".equals(tGreenSpSpmx1)){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，没有找到待删除的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                tGreenSpSpmxMapper.deleteByPrimaryKey(tGreenSpSpmx.getcSpbh());
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
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try {
            TGreenSpSpmx tGreenSpSpmx1 = tGreenSpSpmxMapper.selectByPrimaryKey(tGreenSpSpmx.getcSpbh());
            if (null == tGreenSpSpmx1 || "".equals(tGreenSpSpmx1)){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，没有找到待修改的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                tGreenSpSpmx.setdXgsj(getTimestamp(new Date()));
                tGreenSpSpmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                tGreenSpSpmxMapper.updateByPrimaryKey(tGreenSpSpmx);
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
            return returnModel;
        }
    }

    @Override
    public ReturnModel selectTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

    @Override
    public ReturnModel selectTGreenNlZjnlmx(TGreenNlZjnlmx tGreenNlZjnlmx) {
        return null;
    }

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertTGreenNlZjnlmx(TGreenNlZjnlmx tGreenNlZjnlmx) {
        return null;
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delTGreenNlZjnlmx(TGreenNlZjnlmx tGreenNlZjnlmx) {
        return null;
    }

    @OperationLog(cCzfs = "U")
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
            tGreenRwRwmx.setcUserid(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenRwRwmx.setcRwday(localDateDay);
            List tGreenRwRwmxList = tGreenRwRwmxMapper.selectTGreenRwRwmx(tGreenRwRwmx);
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
                tGreenRwRwmxMapper.insert(tGreenRwRwmx);
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

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delTGreenRwRwmx(TGreenRwRwmx tGreenRwRwmx) {
        return null;
    }

    @OperationLog(cCzfs = "U")
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
        System.out.println(tGreenZzZjzzmx);
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
            List tGreenZzZjzzmxList = tGreenZzZjzzmxMapper.selectTGreenZzZjzzmx(tGreenZzZjzzmx1);
            int tGreenZzZjzzmxCount = tGreenZzZjzzmxList.size();
            System.out.println("指定账户下未捐赠的种子数量为--"+tGreenZzZjzzmxCount);
            if (tGreenZzZjzzmxCount > 3){
                returnModel.setFlag(1);
                returnModel.setMsg("您正在种植的植物数量已经有三种，无法进行兑换！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                TGreenNlHz tGreenNlHz = new TGreenNlHz();//获取指定用户的能量总量
                tGreenNlHz.setcUserid(plateUser.getcUserid());
                List tGreenNlHzList = tGreenNlHzMapper.selectTGreenNlHz(tGreenNlHz);
                Integer userNlzl = Integer.parseInt(((TGreenNlHz) tGreenNlHzList.get(0)).getcNlhz());//获取指定账户的能量总量

                TGreenSpSpmx tGreenSpSpmx = new TGreenSpSpmx();//获取用户点击兑换种子的价格
                tGreenSpSpmx.setcSpbh(tGreenZzZjzzmx.getcSpbh());
                List tGreenSpSpmxList = tGreenSpSpmxMapper.selectTGreenSpSpmx(tGreenSpSpmx);
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
                    tGreenNlJsnlmxMapper.insert(tGreenNlJsnlmx);

                    tGreenNlHz.setcNlhz(String.valueOf((userNlzl-zzPrice)));
                    tGreenNlHz.setcXguser(plateUser.getcUserid());
                    tGreenNlHz.setdXgsj(getTimestamp(new Date()));
                    System.out.println("修改能量汇总表"+tGreenNlHz);
                    tGreenNlHzMapper.updateByPrimaryKey(tGreenNlHz);

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
                    tGreenZzZjzzmxMapper.insert(tGreenZzZjzzmx);
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

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delTGreenZzZjzzmx(TGreenZzZjzzmx tGreenZzZjzzmx) {
        return null;
    }

    @OperationLog(cCzfs = "U")
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

                List plateuserList = plateUserMapper.selectPlateuser(plateUser);//人员姓名与人员等级

                List tGreenNlHzList = tGreenNlHzMapper.selectTGreenNlHz(tGreenNlHz);//查询能量总量

                List tGreenZzZjzzmxList = tGreenZzZjzzmxMapper.selectTGreenZzZjzzmx(tGreenZzZjzzmx);//查询种子明细

                List tGreenRwRwmxList = tGreenRwRwmxMapper.selectTGreenRwRwmx(tGreenRwRwmx);//查询当日任务完成情况明细

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
