package com.greenplatform.service.webImpl;

import com.greenplatform.aop.OperationLog;
import com.greenplatform.dao.*;
import com.greenplatform.dao.owerMapper.OwerTGreenNlHzMapper;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.WebService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class WebServiceImpl implements WebService {
    @Autowired
    TGreenSpSpmxMapper tGreenSpSpmxMapper;
    @Autowired
    TGreenRwRwmxMapper tGreenRwRwmxMapper;
    @Autowired
    PlateUserMapper plateUserMapper;
    @Autowired
    TGreenNlHzMapper tGreenNlHzMapper;
    @Autowired
    OwerTGreenNlHzMapper owerTGreenNlHzMapper;
    @Autowired
    TGreenZzZjzzmxMapper tGreenZzZjzzmxMapper;
    @Autowired
    TGreenNlJsnlmxMapper tGreenNlJsnlmxMapper;


    ReturnModel returnModel = new ReturnModel();


    //完成每日任务
    @Override
    @OperationLog(cCzfs = "I")
    public ReturnModel accomplishRw(TGreenRwRwmx tGreenRwRwmx) {
        try{
            String localDateDay = (TimeUtil.getLocalDate(new Date()).substring(0,10));
            String localDateMonth = (TimeUtil.getLocalDate(new Date()).substring(0,7));

            TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
            TGreenRwRwmxExample.Criteria criteria = tGreenRwRwmxExample.createCriteria();
            criteria.andCUseridEqualTo(GetcurrentLoginUser.getCurrentUser().getcUserid());
            criteria.andCRwlbEqualTo(tGreenRwRwmx.getcRwlb());
            criteria.andCRwdayEqualTo(localDateDay);
            criteria.andCZtEqualTo("1");

            List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);
            if(!(tGreenRwRwmxList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setMsg("您今天已完成该项任务了！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                tGreenRwRwmx.setcUserid(GetcurrentLoginUser.getCurrentUser().getcUserid());
                tGreenRwRwmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                tGreenRwRwmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
                tGreenRwRwmx.setcZt("1");
                tGreenRwRwmx.setcRwmouth(localDateMonth);
                tGreenRwRwmx.setcRwday(localDateDay);
                tGreenRwRwmx.setdRwsj(TimeUtil.getTimestamp(new Date()));

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

    /**
     * 能量兑换种子业务
     * @param tGreenZzZjzzmx（要兑换的商品编号不能为空）
     * @return
     */
    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel buySeeds(TGreenZzZjzzmx tGreenZzZjzzmx) {
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

            TGreenZzZjzzmxExample tGreenZzZjzzmxExample = new TGreenZzZjzzmxExample();
            TGreenZzZjzzmxExample.Criteria criteria = tGreenZzZjzzmxExample.createCriteria();
            criteria.andCUseridEqualTo(plateUser.getcUserid());
            criteria.andCSfjzEqualTo("0");//未捐赠
            criteria.andCZtEqualTo("1");

            List tGreenZzZjzzmxList = tGreenZzZjzzmxMapper.selectByExample(tGreenZzZjzzmxExample);
            int tGreenZzZjzzmxCount = tGreenZzZjzzmxList.size();
            System.out.println("指定账户下未捐赠的种子数量为--"+tGreenZzZjzzmxCount);
            if (tGreenZzZjzzmxCount > 3){
                returnModel.setFlag(1);
                returnModel.setMsg("您正在种植的植物数量已经有三种，无法进行兑换！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //获取指定用户的能量总量
                TGreenNlHzExample tGreenNlHzExample = new TGreenNlHzExample();
                TGreenNlHzExample.Criteria criteriaTGreenNlHzExample = tGreenNlHzExample.createCriteria();
                criteriaTGreenNlHzExample.andCUseridEqualTo(plateUser.getcUserid());
                criteriaTGreenNlHzExample.andCZtEqualTo("1");
                List tGreenNlHzList = tGreenNlHzMapper.selectByExample(tGreenNlHzExample);

                Integer userNlzl = Integer.parseInt(((TGreenNlHz) tGreenNlHzList.get(0)).getcNlhz());//获取指定账户的能量总量
                //获取用户点击兑换种子的价格
                TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
                TGreenSpSpmxExample.Criteria criteriaTGreenSpSpmxExample = tGreenSpSpmxExample.createCriteria();
                criteriaTGreenSpSpmxExample.andCZtEqualTo("1");
                criteriaTGreenSpSpmxExample.andCSpbhEqualTo(tGreenZzZjzzmx.getcSpbh());
                List tGreenSpSpmxList = tGreenSpSpmxMapper.selectByExample(tGreenSpSpmxExample);

                if (tGreenSpSpmxList.size() != 1){
                    returnModel.setFlag(1);
                    returnModel.setMsg("操作失败，系统错误！");
                    returnModel.setObject(null);
                    return returnModel;
                }

                Integer zzPrice = Integer.parseInt(((TGreenSpSpmx) tGreenSpSpmxList.get(0)).getcSpjg());//获取种子的价格
                System.out.println("账户能量总量为："+userNlzl);
                System.out.println("种子价格为："+zzPrice);
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
                    tGreenNlJsnlmx.setdJssj(TimeUtil.getTimestamp(new Date()));
                    tGreenNlJsnlmx.setcZt("1");
                    tGreenNlJsnlmx.setcCjuser(plateUser.getcUserid());
                    tGreenNlJsnlmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
                    tGreenNlJsnlmxMapper.insert(tGreenNlJsnlmx);

                    TGreenNlHz tGreenNlHz = (TGreenNlHz) tGreenNlHzList.get(0);
                    tGreenNlHz.setcNlhz(String.valueOf((userNlzl-zzPrice)));
                    tGreenNlHz.setcXguser(plateUser.getcUserid());
                    tGreenNlHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
                    System.out.println("修改能量汇总表"+tGreenNlHz);
                    tGreenNlHzMapper.updateByPrimaryKey(tGreenNlHz);

                    tGreenZzZjzzmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
                    tGreenZzZjzzmx.setcUserid(plateUser.getcUserid());
                    tGreenZzZjzzmx.setcZjyy("1");
                    tGreenZzZjzzmx.setdZjsj(TimeUtil.getTimestamp(new Date()));
                    tGreenZzZjzzmx.setcKjz("0");
                    tGreenZzZjzzmx.setcSfjz("0");
                    tGreenZzZjzzmx.setcZt("1");
                    tGreenZzZjzzmx.setcCjuser(plateUser.getcUserid());
                    tGreenZzZjzzmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
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

    /**
     * 查询我的账户信息（人员姓名，人员等级，能量总量，种子汇总，今日任务）
     * @return
     */
    @Override
    public ReturnModel selectLoginuserAccount() {
        Map loginuserAccountMap;
        try{
            String loginUserId = GetcurrentLoginUser.getCurrentUser().getcUserid();
            if ("".equals(loginUserId) || null == loginUserId){
                returnModel.setFlag(1);
                returnModel.setMsg("查询失败，人员编号不能为空");
                returnModel.setObject(null);
                return returnModel;
            }else {
                PlateUserExample plateUserExample = new PlateUserExample();
                PlateUserExample.Criteria criteriaPlateuser = plateUserExample.createCriteria();
                criteriaPlateuser.andCUseridEqualTo(loginUserId);
                criteriaPlateuser.andCZtEqualTo("1");//数据状态
                criteriaPlateuser.andCRyxzEqualTo("1");//人员性质
                criteriaPlateuser.andCRylbEqualTo("2");//人员类别
                criteriaPlateuser.andCRyztEqualTo("1");//人员状态


                TGreenNlHzExample tGreenNlHzExample = new TGreenNlHzExample();
                TGreenNlHzExample.Criteria criteriaTGreenNlHzExample = tGreenNlHzExample.createCriteria();
                criteriaTGreenNlHzExample.andCZtEqualTo("1");
                criteriaTGreenNlHzExample.andCUseridEqualTo(loginUserId);

                TGreenZzZjzzmxExample tGreenZzZjzzmxExample = new TGreenZzZjzzmxExample();
                TGreenZzZjzzmxExample.Criteria criteriaTGreenZzZjzzmxExample = tGreenZzZjzzmxExample.createCriteria();
                criteriaTGreenZzZjzzmxExample.andCUseridEqualTo(loginUserId);
                criteriaTGreenZzZjzzmxExample.andCZtEqualTo("1");
                criteriaTGreenZzZjzzmxExample.andCSfjzEqualTo("0");

                TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
                TGreenRwRwmxExample.Criteria criteriaTGreenRwRwmxExample = tGreenRwRwmxExample.createCriteria();
                criteriaTGreenRwRwmxExample.andCUseridEqualTo(loginUserId);
                criteriaTGreenRwRwmxExample.andCZtEqualTo("1");
                criteriaTGreenRwRwmxExample.andCRwdayEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,10));

                List plateuserList = plateUserMapper.selectByExample(plateUserExample);//人员姓名与人员等级

                List tGreenNlHzList = tGreenNlHzMapper.selectByExample(tGreenNlHzExample);//查询能量总量

                List tGreenZzZjzzmxList = tGreenZzZjzzmxMapper.selectByExample(tGreenZzZjzzmxExample);//查询种子明细

                List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);//查询当日任务完成情况明细

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
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 查询首页所需信息（当前人当日任务完成情况，能量汇总排行前十，商品明细）
     * @return
     */
    @Override
    public ReturnModel selectLoginuserHome() {
        try{
            Map loginUserHomeMap = new HashMap();
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            if (("").equals(plateUser) || null == plateUser){
                returnModel.setFlag(1);
                returnModel.setMsg("暂未登陆，无法进行操作！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
                TGreenSpSpmxExample.Criteria criteriaTGreenSpSpmxExample = tGreenSpSpmxExample.createCriteria();
                criteriaTGreenSpSpmxExample.andCZtEqualTo("1");
                List tGreenSpSpmxList = tGreenSpSpmxMapper.selectByExample(tGreenSpSpmxExample);
                loginUserHomeMap.put("tGreenSpSpmxList",tGreenSpSpmxList);

                List tGreenNlHzList = owerTGreenNlHzMapper.selectTGreenNlHzRank(new HashMap());
                loginUserHomeMap.put("tGreenNlNlhzList",tGreenNlHzList);

                TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
                TGreenRwRwmxExample.Criteria criteriaTGreenRwRwmxExample = tGreenRwRwmxExample.createCriteria();
                criteriaTGreenRwRwmxExample.andCUseridEqualTo(plateUser.getcUserid());
                criteriaTGreenRwRwmxExample.andCRwdayEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,10));
                criteriaTGreenRwRwmxExample.andCZtEqualTo("1");
                List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);//查询当日任务完成情况明细
                Map rwmxMap = new HashMap();
                rwmxMap.put("1",false);
                rwmxMap.put("2",false);
                rwmxMap.put("3",false);

                for (int i=0;i<tGreenRwRwmxList.size();i++){
                    TGreenRwRwmx tGreenRwRwmx = (TGreenRwRwmx) tGreenRwRwmxList.get(i);
                    rwmxMap.put(tGreenRwRwmx.getcRwlb(),true);
                }

                loginUserHomeMap.put("tGreenRwRwmx",rwmxMap);

                System.out.println(loginUserHomeMap);

                returnModel.setFlag(0);
                returnModel.setMsg(null);
                returnModel.setObject(loginUserHomeMap);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("查询失败，系统错误");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }



}
