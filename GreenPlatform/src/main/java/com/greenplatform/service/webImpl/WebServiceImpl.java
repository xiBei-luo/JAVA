package com.greenplatform.service.webImpl;

import com.greenplatform.aop.YwOperationCheckAndLog;
import com.greenplatform.dao.*;
import com.greenplatform.dao.owerMapper.*;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.WebService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.TimeUtil;
import com.greenplatform.util.returnUtil.ReturnModelHandler;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
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
    TGreenRwRwhzMapper tGreenRwRwhzMapper;
    @Autowired
    PlateUserMapper plateUserMapper;
    @Autowired
    TGreenNlHzMapper tGreenNlHzMapper;
    @Autowired
    OwerTGreenNlHzMapper owerTGreenNlHzMapper;
    @Autowired
    TGreenZzZjzzmxMapper tGreenZzZjzzmxMapper;
    @Autowired
    OwerTGreenZzZjzzmxMapper owerTGreenZzZjzzmxMapper;
    @Autowired
    TGreenNlJsnlmxMapper tGreenNlJsnlmxMapper;
    @Autowired
    TGreenGoldDzmxMapper tGreenGoldDzmxMapper;
    @Autowired
    TGreenGoldJsmxMapper tGreenGoldJsmxMapper;
    @Autowired
    TGreenGoldHzMapper tGreenGoldHzMapper;
    @Autowired
    TGreenGoldDzhzMapper tGreenGoldDzhzMapper;
    @Autowired
    TGreenGoldZjmxMapper tGreenGoldZjmxMapper;
    @Autowired
    OwerTGreenGoldDzhzMapper owerTGreenGoldDzhzMapper;
    @Autowired
    PlateCodeXtcsMapper plateCodeXtcsMapper;
    @Autowired
    TGreenZzJzjlMapper tGreenZzJzjlMapper;
    @Autowired
    OwerTGreenZzJzjlMapper owerTGreenZzJzjlMapper;
    @Autowired
    PlateCodeDmzMapper plateCodeDmzMapper;
    @Autowired
    TGreenNlZjnlmxMapper tGreenNlZjnlmxMapper;
    @Autowired
    TGreenNlCzjlMapper tGreenNlCzjlMapper;
    @Autowired
    TGreenNlTxjlMapper tGreenNlTxjlMapper;
    @Autowired
    OwerTGreenNlCzjlMapper owerTGreenNlCzjlMapper;
    @Autowired
    OwerTGreenNlTxjlMapper owerTGreenNlTxjlMapper;

    /**
     * 查询用户
     * @param cPhone
     * @return
     */
    @Override
    public ReturnModel selectUserByPhone(String cPhone) {
        try{
            PlateUser plateUser = new PlateUser();
            plateUser.setcRylb("2");
            plateUser.setcPhone(cPhone);
            plateUser.setcZt("1");
            plateUser.setcRyzt("1");
            plateUser.setcRyxz("1");

            PlateUserExample plateUserExample = new PlateUserExample();
            PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
            criteria.andCZtEqualTo(plateUser.getcZt());
            criteria.andCRyxzEqualTo(plateUser.getcRyxz());
            criteria.andCRylbEqualTo(plateUser.getcRylb());
            criteria.andCRyztEqualTo(plateUser.getcRyzt());
            criteria.andCPhoneEqualTo(plateUser.getcPhone());

            List plateUserList = plateUserMapper.selectByExample(plateUserExample);
            PlateUser plateUser1 = (PlateUser) plateUserList.get(0);
            return ReturnModelHandler.success(plateUser1);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }

    }

    //完成每日任务
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel accomplishRw(TGreenRwRwmx tGreenRwRwmx) {
        System.out.println("正在调用目标方法");
        try{

            checkAddGoldOperation();//调用前验证

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
                return ReturnModelHandler.error("您今天已完成该项任务了！");
            }else{
                //1.任务明细中增加一条记录
                tGreenRwRwmx.setcUserid(GetcurrentLoginUser.getCurrentUser().getcUserid());
                tGreenRwRwmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                tGreenRwRwmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
                tGreenRwRwmx.setcZt("1");
                tGreenRwRwmx.setcRwmouth(localDateMonth);
                tGreenRwRwmx.setcRwday(localDateDay);
                tGreenRwRwmx.setdRwsj(TimeUtil.getTimestamp(new Date()));

                tGreenRwRwmxMapper.insert(tGreenRwRwmx);

                addGoldOperation("C_GOLD_ZJYY_1");//调用后增加对金币表相关的操作


                return ReturnModelHandler.success(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    /**
     * 能量兑换种子业务
     * @param tGreenZzZjzzmx（要兑换的商品编号不能为空）
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel buySeeds(TGreenZzZjzzmx tGreenZzZjzzmx) {
        //tGreenZzZjzzmx  商品编号必传
        if (null == tGreenZzZjzzmx.getcSpbh() || "".equals(tGreenZzZjzzmx)){
            return ReturnModelHandler.error("兑换种子编号不能为空！");
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

            //1.同一账户下只能同时种植一类植物
            for (int i=0;i<tGreenZzZjzzmxList.size();i++){
                TGreenZzZjzzmx tGreenZzZjzzmx1 = (TGreenZzZjzzmx) tGreenZzZjzzmxList.get(i);
                if (tGreenZzZjzzmx1.getcSpbh().equals(tGreenZzZjzzmx.getcSpbh())){
                    return ReturnModelHandler.error("您已经有这类种子正在种植中，无法进行兑换！");
                }
            }


            int tGreenZzZjzzmxCount = tGreenZzZjzzmxList.size();
            if (tGreenZzZjzzmxCount > 3){
                return ReturnModelHandler.error("您正在种植的植物数量已经有三种，无法进行兑换！");
            }else{
                //获取指定用户的能量总量
                TGreenNlHzExample tGreenNlHzExample = new TGreenNlHzExample();
                TGreenNlHzExample.Criteria criteriaTGreenNlHzExample = tGreenNlHzExample.createCriteria();
                criteriaTGreenNlHzExample.andCUseridEqualTo(plateUser.getcUserid());
                criteriaTGreenNlHzExample.andCZtEqualTo("1");
                List tGreenNlHzList = tGreenNlHzMapper.selectByExample(tGreenNlHzExample);

                BigDecimal userNlzl = ((TGreenNlHz) tGreenNlHzList.get(0)).getnNlhz();//获取指定账户的能量总量
                //获取用户点击兑换种子的价格
                TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
                TGreenSpSpmxExample.Criteria criteriaTGreenSpSpmxExample = tGreenSpSpmxExample.createCriteria();
                criteriaTGreenSpSpmxExample.andCZtEqualTo("1");
                criteriaTGreenSpSpmxExample.andCSpbhEqualTo(tGreenZzZjzzmx.getcSpbh());
                List tGreenSpSpmxList = tGreenSpSpmxMapper.selectByExample(tGreenSpSpmxExample);

                if (tGreenSpSpmxList.size() != 1){
                    return ReturnModelHandler.systemError();
                }

                BigDecimal zzPrice = ((TGreenSpSpmx) tGreenSpSpmxList.get(0)).getnSpjg();//获取种子的价格
                if (tGreenNlHzList.isEmpty()){
                    return ReturnModelHandler.error("您的能量不足，快去完成任务获取能量吧！");
                }else if(userNlzl.compareTo(zzPrice) == -1) {
                    return ReturnModelHandler.error("您的能量不足，快去完成任务获取能量吧！");
                }else{
                    TGreenNlJsnlmx tGreenNlJsnlmx = new TGreenNlJsnlmx();
                    tGreenNlJsnlmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
                    tGreenNlJsnlmx.setcUserid(plateUser.getcUserid());
                    tGreenNlJsnlmx.setnJssl(zzPrice);
                    tGreenNlJsnlmx.setcJsyy("1");//减少原因：兑换商品
                    tGreenNlJsnlmx.setdJssj(TimeUtil.getTimestamp(new Date()));
                    tGreenNlJsnlmx.setcZt("1");
                    tGreenNlJsnlmx.setcCjuser(plateUser.getcUserid());
                    tGreenNlJsnlmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
                    tGreenNlJsnlmxMapper.insert(tGreenNlJsnlmx);

                    TGreenNlHz tGreenNlHz = (TGreenNlHz) tGreenNlHzList.get(0);
                    tGreenNlHz.setnNlhz(userNlzl.subtract(zzPrice));
                    tGreenNlHz.setcXguser(plateUser.getcUserid());
                    tGreenNlHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
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
                    tGreenZzZjzzmxMapper.insert(tGreenZzZjzzmx);
                    return ReturnModelHandler.success(tGreenZzZjzzmx);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    /**
     * 查询我的账户信息（人员姓名，人员等级，能量总量,金币总量,点赞总量，种子汇总，今日任务）
     * @return
     */
    @Override
    public ReturnModel selectLoginuserAccount() {
        Map loginuserAccountMap;
        try{
            String loginUserId = GetcurrentLoginUser.getCurrentUser().getcUserid();
            if ("".equals(loginUserId) || null == loginUserId){
                return ReturnModelHandler.error("查询失败，人员编号不能为空");
            }else {
                //人员信息
                PlateUserExample plateUserExample = new PlateUserExample();
                PlateUserExample.Criteria criteriaPlateuser = plateUserExample.createCriteria();
                criteriaPlateuser.andCUseridEqualTo(loginUserId);
                criteriaPlateuser.andCZtEqualTo("1");//数据状态
                criteriaPlateuser.andCRyxzEqualTo("1");//人员性质
                criteriaPlateuser.andCRylbEqualTo("2");//人员类别
                criteriaPlateuser.andCRyztEqualTo("1");//人员状态

                //能量汇总
                TGreenNlHzExample tGreenNlHzExample = new TGreenNlHzExample();
                TGreenNlHzExample.Criteria criteriaTGreenNlHzExample = tGreenNlHzExample.createCriteria();
                criteriaTGreenNlHzExample.andCZtEqualTo("1");
                criteriaTGreenNlHzExample.andCUseridEqualTo(loginUserId);

                //任务完成情况
                TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
                TGreenRwRwmxExample.Criteria criteriaTGreenRwRwmxExample = tGreenRwRwmxExample.createCriteria();
                criteriaTGreenRwRwmxExample.andCUseridEqualTo(loginUserId);
                criteriaTGreenRwRwmxExample.andCZtEqualTo("1");
                criteriaTGreenRwRwmxExample.andCRwdayEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,10));

                //点赞总量
                TGreenGoldDzhzExample tGreenGoldDzhzExample = new TGreenGoldDzhzExample();
                TGreenGoldDzhzExample.Criteria criteria = tGreenGoldDzhzExample.createCriteria();
                criteria.andCZtEqualTo("1");
                criteria.andCUseridEqualTo(loginUserId);

                //金币总量
                TGreenGoldHzExample tGreenGoldHzExample = new TGreenGoldHzExample();
                TGreenGoldHzExample.Criteria criteria1 = tGreenGoldHzExample.createCriteria();
                criteria1.andCZtEqualTo("1");
                criteria1.andCUseridEqualTo(loginUserId);

                List plateuserList = plateUserMapper.selectByExample(plateUserExample);//人员姓名与人员等级

                List tGreenNlHzList = tGreenNlHzMapper.selectByExample(tGreenNlHzExample);//查询能量总量

                List tGreenGoldDzhzList = tGreenGoldDzhzMapper.selectByExample(tGreenGoldDzhzExample);//点赞总量

                List tGreenGoldJbhzList = tGreenGoldHzMapper.selectByExample(tGreenGoldHzExample);//金币总量


                //种子明细
                Map paramsMap = new HashMap();
                paramsMap.put("cUserid",loginUserId);
                paramsMap.put("cSfjz","0");

                List tGreenZzZjzzmxList = owerTGreenZzZjzzmxMapper.selectTGreenZzZjzzmx(paramsMap);//查询种子明细

                List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);//查询当日任务完成情况明细

                loginuserAccountMap = new HashMap();
                loginuserAccountMap.put("plateUser",plateuserList);
                loginuserAccountMap.put("tGreenNlHz",tGreenNlHzList);
                loginuserAccountMap.put("tGreenZzZjzzmx",tGreenZzZjzzmxList);
                loginuserAccountMap.put("tGreenRwRwmx",tGreenRwRwmxList);
                loginuserAccountMap.put("tGreenDzzl",tGreenGoldDzhzList);
                loginuserAccountMap.put("tGreenJbzl",tGreenGoldJbhzList);

                System.out.println(tGreenGoldDzhzList);
                System.out.println(tGreenGoldJbhzList);

                return ReturnModelHandler.success(loginuserAccountMap);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    /**
     * 查询首页所需信息（当前登录用户，当前人当日任务完成情况，点赞排行榜前十，能量汇总排行前十，商品明细）
     * @return
     */
    @Override
    public ReturnModel selectLoginuserHome() {
        try{
            Map loginUserHomeMap = new HashMap();
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            if (("").equals(plateUser) || null == plateUser){
                return ReturnModelHandler.error("暂未登陆，无法进行操作！");
            }else{
                //1.商品
                TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
                TGreenSpSpmxExample.Criteria criteriaTGreenSpSpmxExample = tGreenSpSpmxExample.createCriteria();
                criteriaTGreenSpSpmxExample.andCZtEqualTo("1");
                tGreenSpSpmxExample.setOrderByClause("n_spjg");
                List tGreenSpSpmxList = tGreenSpSpmxMapper.selectByExample(tGreenSpSpmxExample);
                loginUserHomeMap.put("tGreenSpSpmxList",tGreenSpSpmxList);


                //2.能量排行榜前十
                List tGreenNlHzList = owerTGreenNlHzMapper.selectTGreenNlHzRank(new HashMap());
                loginUserHomeMap.put("tGreenNlNlhzList",tGreenNlHzList);


                //3.任务完成情况
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
                //3-1当前月任务完成次数
                TGreenRwRwmxExample tGreenRwRwmxExample1 = new TGreenRwRwmxExample();
                TGreenRwRwmxExample.Criteria criteria = tGreenRwRwmxExample1.createCriteria();
                criteria.andCUseridEqualTo(plateUser.getcUserid());
                criteria.andCZtEqualTo("1");
                criteria.andCRwmouthEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,7));
                List tGreenRwRwmxList1 = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample1);
                int countRank =  tGreenRwRwmxList1.size()/3;
                String tmpTxt = "";
                if(countRank > 20){
                    tmpTxt = "big";
                }else if(countRank > 10 && countRank < 20){
                    tmpTxt = "mid";
                }else {
                    tmpTxt = "sm";
                }

                rwmxMap.put("endRwCountDay",tmpTxt);//完成任务天数

                loginUserHomeMap.put("tGreenRwRwmx",rwmxMap);

                //4.点赞排行榜前十
                List tGreenGoldDzhzList = owerTGreenGoldDzhzMapper.selectGreenGoldDzhzRank();
                loginUserHomeMap.put("tGreenGoldDzhzList",tGreenGoldDzhzList);

                //5.当前登陆人信息
                loginUserHomeMap.put("plateUser",plateUser);

                //6.当前登陆人的能量排名
                Map tGreenNlHzMap = owerTGreenNlHzMapper.selectTGreenNlHzBycUserid(plateUser.getcUserid());
                tGreenNlHzMap.put("cUsername",plateUser.getcUsername());
                tGreenNlHzMap.put("nRank",Math.round((Double) tGreenNlHzMap.get("rank")));
                loginUserHomeMap.put("owerTGreenNlHz",tGreenNlHzMap);

                //7.当前登陆人的点赞排名
                Map tGreenGoldDzhzMap = owerTGreenGoldDzhzMapper.selectTGreenGoldDzhzBycUserid(plateUser.getcUserid());
                tGreenGoldDzhzMap.put("cUsername",plateUser.getcUsername());
                tGreenGoldDzhzMap.put("nRank",Math.round((Double) tGreenNlHzMap.get("rank")));
                loginUserHomeMap.put("owerTGreenGoldDzhz",tGreenGoldDzhzMap);


                //System.out.println(loginUserHomeMap);
                System.out.println(rwmxMap);
                System.out.println(tGreenNlHzMap);
                System.out.println(tGreenGoldDzhzMap);


                return ReturnModelHandler.success(loginUserHomeMap);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    /**
     * 金币点赞业务（调用aop环绕通知验证当前系统中点赞数有无达到10万），环绕通知注解未写（2019-07-17）
     * 1.判断当前账户下金币是否足够
     * 2.调用此业务前后都要判断金币点赞数是否达到10万（达到10万关闭此业务，等待系统清空数据并瓜分能量）
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel doLike() {
        try{
            //系统能量值是否达到十万
            Map enabledDivideNlMap = enabledDivideNl();
            if ((boolean)enabledDivideNlMap.get("isAbled")){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ReturnModelHandler.error("系统正在准备瓜分能量，暂时不能进行点赞！");
            }

            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            //1.判断账户金币是否足够点赞一次
            TGreenGoldHzExample tGreenGoldHzExample1 = new TGreenGoldHzExample();
            TGreenGoldHzExample.Criteria criteria3 = tGreenGoldHzExample1.createCriteria();
            criteria3.andCZtEqualTo("1");
            criteria3.andCUseridEqualTo(plateUser.getcUserid());
            List tGreenGoldHzList1 = tGreenGoldHzMapper.selectByExample(tGreenGoldHzExample1);

            if (tGreenGoldHzList1.size() < 1){
                return ReturnModelHandler.error("金币不足，快去做任务获取金币吧！");
            }

            TGreenGoldHz tGreenGoldHz1 = (TGreenGoldHz) tGreenGoldHzList1.get(0);

            if(tGreenGoldHz1.getnJbzl().compareTo(new BigDecimal(getDmzByDm("C_DZSL_ONE_1"))) == -1){
                return ReturnModelHandler.error("金币不足，快去做任务获取金币吧！");
            }

            //2.如果当前人是第一次点赞，则在点赞汇总表中增加一条记录，否则不加
            TGreenGoldDzmxExample tGreenGoldDzmxExample = new TGreenGoldDzmxExample();
            TGreenGoldDzmxExample.Criteria criteria2 = tGreenGoldDzmxExample.createCriteria();
            criteria2.andCZtEqualTo("1");
            criteria2.andCUseridEqualTo(plateUser.getcUserid());
            List tGreenGoldDzmxList = tGreenGoldDzmxMapper.selectByExample(tGreenGoldDzmxExample);
            if (tGreenGoldDzmxList.size() < 1){
                TGreenGoldDzhz tGreenGoldDzhz = new TGreenGoldDzhz();
                tGreenGoldDzhz.setcUserid(plateUser.getcUserid());
                tGreenGoldDzhz.setnDzzl(new BigDecimal("0"));
                tGreenGoldDzhz.setcZt("1");
                tGreenGoldDzhz.setcCjuser(plateUser.getcUserid());
                tGreenGoldDzhz.setdCjsj(TimeUtil.getTimestamp(new Date()));
                tGreenGoldDzhzMapper.insert(tGreenGoldDzhz);
            }

            //3.点赞明细表中新增一条记录
            TGreenGoldDzmx tGreenGoldDzmx = new TGreenGoldDzmx();
            tGreenGoldDzmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenGoldDzmx.setcUserid(plateUser.getcUserid());
            tGreenGoldDzmx.setnDzsl(new BigDecimal("1"));
            tGreenGoldDzmx.setdDzsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldDzmx.setcZt("1");
            tGreenGoldDzmx.setcCjuser(plateUser.getcUserid());
            tGreenGoldDzmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldDzmxMapper.insert(tGreenGoldDzmx);

            //4.金币减少明细表中增加一条记录
            TGreenGoldJsmx tGreenGoldJsmx = new TGreenGoldJsmx();
            tGreenGoldJsmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenGoldJsmx.setcUserid(plateUser.getcUserid());
            tGreenGoldJsmx.setnJssl(new BigDecimal(getDmzByDm("C_DZSL_ONE_1")));
            tGreenGoldJsmx.setcJsyy("1");
            tGreenGoldJsmx.setdJssj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldJsmx.setcJsyysm("点赞");
            tGreenGoldJsmx.setcZt("1");
            tGreenGoldJsmx.setcCjuser(plateUser.getcUserid());
            tGreenGoldJsmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldJsmxMapper.insert(tGreenGoldJsmx);

            //5.修改金币汇总表(原金币总量-一次点赞花费的金币数)
            TGreenGoldHzExample tGreenGoldHzExample = new TGreenGoldHzExample();
            TGreenGoldHzExample.Criteria criteria = tGreenGoldHzExample.createCriteria();
            criteria.andCUseridEqualTo(plateUser.getcUserid());
            criteria.andCZtEqualTo("1");
            List tGreenGoldHzList = tGreenGoldHzMapper.selectByExample(tGreenGoldHzExample);
            TGreenGoldHz tGreenGoldHz = (TGreenGoldHz) tGreenGoldHzList.get(0);
            tGreenGoldHz.setnJbzl(tGreenGoldHz.getnJbzl().subtract(new BigDecimal(getDmzByDm("C_DZSL_ONE_1"))));
            tGreenGoldHz.setcXguser(plateUser.getcUserid());
            tGreenGoldHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldHzMapper.updateByPrimaryKey(tGreenGoldHz);

            //6.修改点赞汇总表
            TGreenGoldDzhzExample tGreenGoldDzhzExample = new TGreenGoldDzhzExample();
            TGreenGoldDzhzExample.Criteria criteria1 = tGreenGoldDzhzExample.createCriteria();
            criteria1.andCZtEqualTo("1");
            criteria1.andCUseridEqualTo(plateUser.getcUserid());
            List tGreenGoldDzhzList = tGreenGoldDzhzMapper.selectByExample(tGreenGoldDzhzExample);
            TGreenGoldDzhz tGreenGoldDzhz = (TGreenGoldDzhz) tGreenGoldDzhzList.get(0);
            tGreenGoldDzhz.setnDzzl(tGreenGoldDzhz.getnDzzl().add(new BigDecimal("1")));
            tGreenGoldDzhz.setcXguser(plateUser.getcUserid());
            tGreenGoldDzhz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldDzhzMapper.updateByPrimaryKey(tGreenGoldDzhz);

            //系统能量值是否达到10万
            Map afterEnableDivideMap = enabledDivideNl();
            if ((boolean)afterEnableDivideMap.get("isAbled")){
                //关闭点赞服务,开启瓜分能量
                divideNl();
                System.out.println("能量达到十万啦~~~现在开始瓜分能量");
            }

            return ReturnModelHandler.success(null);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    /**
     * 实名制服务，还需要调整（2019-07-17）
     * @param plateUser
     * @return
     */
    @Override
    public ReturnModel certification(PlateUser plateUser) {

        //1.验证身份证号，手机号码

        //1.验证账户，查询平台表中是否有记录，若没有则新增一条，若有则修改各个参数状态
        PlateUser plateUser1 = plateUserMapper.selectByPrimaryKey(plateUser.getcUserid());
        plateUser1.setcIssmz("1");
        plateUser1.setcUsername(plateUser.getcUsername());
        plateUser1.setcPhone(plateUser.getcPhone());
        plateUser1.setcZjhm(plateUser.getcZjhm());
        plateUser1.setcXguser(plateUser.getcUserid());
        plateUser1.setdXgsj(TimeUtil.getTimestamp(new Date()));
        plateUserMapper.updateByPrimaryKey(plateUser1);


        //2.实名制完成后要更新session域中的值或强制退出重新登陆


        //3.将该账户下的种子状态设为有效
        TGreenZzZjzzmxExample tGreenZzZjzzmxExample = new TGreenZzZjzzmxExample();
        TGreenZzZjzzmxExample.Criteria criteria = tGreenZzZjzzmxExample.createCriteria();
        criteria.andCUseridEqualTo(plateUser.getcUserid());
        criteria.andCKjzEqualTo("0");
        criteria.andCSfjzEqualTo("0");
        criteria.andCSpbhEqualTo("1");//注册赠送仙人掌种子
        List tGreenZzZjzzmxList = tGreenZzZjzzmxMapper.selectByExample(tGreenZzZjzzmxExample);
        TGreenZzZjzzmx tGreenZzZjzzmx = (TGreenZzZjzzmx) tGreenZzZjzzmxList.get(0);
        tGreenZzZjzzmx.setcZt("1");
        tGreenZzZjzzmx.setcXguser(plateUser.getcUserid());
        tGreenZzZjzzmx.setdXgsj(TimeUtil.getTimestamp(new Date()));
        tGreenZzZjzzmxMapper.updateByPrimaryKey(tGreenZzZjzzmx);



        //4.将该账户下能量汇总表的状态设为有效(如果该账户下无增加种子记录则增加一条新的有效种子记录)
        TGreenNlHz tGreenNlHz = tGreenNlHzMapper.selectByPrimaryKey(plateUser.getcUserid());
        tGreenNlHz.setcZt("1");
        tGreenNlHz.setcXguser(plateUser.getcUserid());
        tGreenNlHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
        tGreenNlHzMapper.updateByPrimaryKey(tGreenNlHz);


        return ReturnModelHandler.success(null);
    }


    /**
     * 金币点赞数达到10万，瓜分能量业务
     * 瓜分规则：排名前一百可瓜分固定数的绿沙能量，
     * 第一名88能量，第二名：58能量，第三名：38能量，4-10：18能量，
     * 11-50：8能量，51-100：2能量，101名后获得随机数量金币，（随机数范围？）
     *
     * 点赞数排名每个名次仅一名用户，点赞数量相同时，按完成时间排列；
     */
    @Override
    public void divideNl() {
        System.out.println("开始瓜分能量！");
    }



    /**
     * 捐赠植物业务(需完善)
     * @param cSpbh  捐赠植物编号
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel contributeSeed(String cLsh,String cSpbh) {
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            //1.判断能否进行捐赠操作（是否连续一个月完成任务）
            String currentDay = TimeUtil.getLocalDate(new Date()).substring(0,7);//获取当前月
            int year = Integer.parseInt(currentDay.substring(0,4));//获取当前月——年
            int mouth = Integer.parseInt(currentDay.substring(5,7));//获取当前月——月

            Calendar calendar = Calendar.getInstance();
            calendar.set(year,mouth,0);
            int dayOfMouth = calendar.get(Calendar.DAY_OF_MONTH);//获取当前月有多少天

            TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
            TGreenRwRwmxExample.Criteria criteria = tGreenRwRwmxExample.createCriteria();
            criteria.andCZtEqualTo("1");
            criteria.andCUseridEqualTo(plateUser.getcUserid());
            criteria.andCRwmouthEqualTo(currentDay);

            List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);
            System.out.println("连续完成基础任务："+tGreenRwRwmxList.size()+"天");

            if (tGreenRwRwmxList.size() < dayOfMouth){
                return ReturnModelHandler.error("操作失败，您还没有连续一个月完成基础任务！");
            }

            //1.同一账户24小时内只能捐赠一种植物（需要调整判断是否是同一天）
            TGreenZzJzjlExample tGreenZzJzjlExample = new TGreenZzJzjlExample();
            TGreenZzJzjlExample.Criteria criteria1 = tGreenZzJzjlExample.createCriteria();
            criteria1.andCZtEqualTo("1");
            criteria1.andDJzsjEqualTo(TimeUtil.getTimestamp(new Date()));//此日期需要调整修改
            List tGreenZzJzjlList = tGreenZzJzjlMapper.selectByExample(tGreenZzJzjlExample);
            if (tGreenZzJzjlList.size() > 0){
                return ReturnModelHandler.error("您今天已经捐赠植物了，同一天只能捐赠一次！");
            }


            //1.查询系统参数，需要查询的参数包括
            //当前种子捐赠后可得到多少能量奖励；如仙人掌：112
            //当前用户账户等级对应的额外奖励有多少？如二级可得到2%额外奖励
            //当前账户的父账户奖励规则？如师傅可得到的固定奖励为100，额外奖励为植物奖励的5%
            //完成植物种植获取的金币数量？
            float sysParamOfAddNl = Float.parseFloat(getDmzByDm("C_ZWJZJL_NL_"+cSpbh));//捐赠种子后得到的能量奖励


            float sysParamOfUserLev = Float.parseFloat(getDmzByDm("C_ZHDJ_EXTJL_"+plateUser.getcRydj()));//账户等级对应的能量奖励百分比


            float extraNL = sysParamOfUserLev*sysParamOfAddNl;//账户等级对应的能量奖励


            float sysParamOfFatherGd = Float.parseFloat(getDmzByDm("C_FATHER_JL_GD"));//父账户固定奖励


            float sysParamOfFatherExt = Float.parseFloat(getDmzByDm("C_FATHER_JL_EXT"));//父账户额外奖励


            //float sysParamOfGoldJlPer = Float.parseFloat(getDmzByDm("C_ZWJZJL_GOLD_"+cSpbh));//植物捐赠后的金币奖励



            float sysParamOfGoldJl = 500;//植物捐赠后的金币奖励值

            /*System.out.println("捐赠此植物的能量奖励"+sysParamOfAddNl);
            System.out.println("捐赠此植物的账户等级额外奖励百分比"+sysParamOfUserLev);
            System.out.println("捐赠此植物的账户等级额外奖励值"+extraNL);
            System.out.println("捐赠此植物的父账户固定奖励"+sysParamOfFatherGd);
            System.out.println("捐赠此植物的父账户额外奖励"+sysParamOfFatherExt);
            System.out.println("捐赠此植物的金币奖励百分比"+sysParamOfGoldJlPer);
            System.out.println("捐赠此植物的金币奖励值"+sysParamOfGoldJl);*/







            //2.修改种子增加明细表种子状态（已捐赠，捐赠事件）
            TGreenZzZjzzmx tGreenZzZjzzmx = tGreenZzZjzzmxMapper.selectByPrimaryKey(cLsh);
            tGreenZzZjzzmx.setcKjz("1");
            tGreenZzZjzzmx.setcSfjz("1");
            tGreenZzZjzzmx.setdJzsj(TimeUtil.getTimestamp(new Date()));
            tGreenZzZjzzmx.setcXguser(plateUser.getcUserid());
            tGreenZzZjzzmx.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenZzZjzzmxMapper.updateByPrimaryKey(tGreenZzZjzzmx);

            //3.新增捐赠记录
            TGreenZzJzjl tGreenZzJzjl = new TGreenZzJzjl();
            tGreenZzJzjl.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenZzJzjl.setcUserid(plateUser.getcUserid());
            tGreenZzJzjl.setcZzzjlsh(cLsh);
            tGreenZzJzjl.setdJzsj(TimeUtil.getTimestamp(new Date()));
            tGreenZzJzjl.setcSpbh(cSpbh);
            tGreenZzJzjl.setcZt("1");
            tGreenZzJzjl.setcCjuser(plateUser.getcUserid());
            tGreenZzJzjl.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenZzJzjlMapper.insert(tGreenZzJzjl);

            //4.新增增加能量明细表记录（增加数量等于捐赠种子指定的能量加上账户等级额外的奖励）
            TGreenNlZjnlmx tGreenNlZjnlmx = new TGreenNlZjnlmx();
            tGreenNlZjnlmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenNlZjnlmx.setcUserid(plateUser.getcUserid());
            tGreenNlZjnlmx.setnZjnl(new BigDecimal(sysParamOfAddNl+extraNL));
            tGreenNlZjnlmx.setdZjsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlZjnlmx.setcZjyy("4");
            tGreenNlZjnlmx.setcCjuser(plateUser.getcUserid());
            tGreenNlZjnlmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlZjnlmxMapper.insert(tGreenNlZjnlmx);


            //5.更新账户能量汇总表记录
            float cSumAddNlzl = sysParamOfAddNl+extraNL;
            TGreenNlHz tGreenNlHz = tGreenNlHzMapper.selectByPrimaryKey(plateUser.getcUserid());
            tGreenNlHz.setnNlhz(tGreenNlHz.getnNlhz().add(new BigDecimal(cSumAddNlzl)));
            tGreenNlHz.setcXguser(plateUser.getcUserid());
            tGreenNlHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlHzMapper.updateByPrimaryKey(tGreenNlHz);

            //6.新增金币增加表记录（增加原因：完成种植任务）
            TGreenGoldZjmx tGreenGoldZjmx = new TGreenGoldZjmx();
            tGreenGoldZjmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenGoldZjmx.setcUserid(plateUser.getcUserid());
            System.out.println("增加金币数量："+sysParamOfGoldJl);
            tGreenGoldZjmx.setnZjsl(new BigDecimal(sysParamOfGoldJl));
            tGreenGoldZjmx.setcZjyy("C_GOLD_ZJYY_3");
            tGreenGoldZjmx.setcZjyysm("完成植物捐赠");
            tGreenGoldZjmx.setdZjsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldZjmx.setcZt("1");
            tGreenGoldZjmx.setcCjuser(plateUser.getcUserid());
            tGreenGoldZjmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldZjmxMapper.insert(tGreenGoldZjmx);


            //7.修改金币汇总表
            TGreenGoldHz tGreenGoldHz = tGreenGoldHzMapper.selectByPrimaryKey(plateUser.getcUserid());
            tGreenGoldHz.setnJbzl(tGreenGoldHz.getnJbzl().add(new BigDecimal(sysParamOfGoldJl)));
            tGreenGoldHz.setcXguser(plateUser.getcUserid());
            tGreenGoldHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldHzMapper.updateByPrimaryKey(tGreenGoldHz);


            //8.查询当前账户是否有父账户（是否有师傅），有则师傅账户增加奖励
            if (!(("").equals(plateUser.getcFatherid()) || null == plateUser.getcFatherid())){
                System.out.println("有父账户！");
                System.out.println("父账户增加相应的能量奖励");//父账户是否需要金币奖励
            }


        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return null;
    }


    /**
     * 能量充值
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel rechargeNl() {
        return null;
    }


    /**
     * 能量提现
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel presentationNl() {
        return null;
    }


    /**
     * 新增金币操作
     * 使用AOP@After时，其中有大量事务，导致目标方法无法回滚，因此不能使用该方法
     * @param cZjyy
     * @return
     */
    private void addGoldOperation(String cZjyy) throws Exception{
        PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
        //3.获取新增金币类型，判断：如果是完成基础任务，则要完成三个任务才增加金币

        PlateCodeDmz plateCodeDmz = getDmobjByDmlbAndDm(cZjyy);
        String cZjyysm = plateCodeDmz.getcSm();//金币增加原因中文
        String nZjsl = plateCodeDmz.getcDmz();//金币增加数量

        //4.增加金币明细添加一条记录
        TGreenGoldZjmx tGreenGoldZjmx = new TGreenGoldZjmx();
        tGreenGoldZjmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
        tGreenGoldZjmx.setcUserid(plateUser.getcUserid());
        tGreenGoldZjmx.setnZjsl(new BigDecimal(nZjsl));
        tGreenGoldZjmx.setcZjyy(cZjyy);
        tGreenGoldZjmx.setcZjyysm(cZjyysm);
        tGreenGoldZjmx.setdZjsj(TimeUtil.getTimestamp(new Date()));
        tGreenGoldZjmx.setcZt("1");
        tGreenGoldZjmx.setcCjuser(plateUser.getcUserid());
        tGreenGoldZjmx.setdCjsj(TimeUtil.getTimestamp(new Date()));


        //5.修改金币汇总表中的记录
        TGreenGoldHzExample tGreenGoldHzExample1 = new TGreenGoldHzExample();
        TGreenGoldHzExample.Criteria criteria1 = tGreenGoldHzExample1.createCriteria();
        criteria1.andCZtEqualTo("1");
        criteria1.andCUseridEqualTo(plateUser.getcUserid());
        List tGreenGoldHzList1 = tGreenGoldHzMapper.selectByExample(tGreenGoldHzExample1);
        TGreenGoldHz tGreenGoldHz = (TGreenGoldHz) tGreenGoldHzList1.get(0);
        tGreenGoldHz.setnJbzl(tGreenGoldHz.getnJbzl().add(tGreenGoldZjmx.getnZjsl()));
        tGreenGoldHz.setcXguser(plateUser.getcUserid());
        tGreenGoldHz.setdXgsj(TimeUtil.getTimestamp(new Date()));

        //提交事务
        if (cZjyy.equals("C_GOLD_ZJYY_1")){
            TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
            TGreenRwRwmxExample.Criteria criteria2 = tGreenRwRwmxExample.createCriteria();
            criteria2.andCZtEqualTo("1");
            criteria2.andCUseridEqualTo(plateUser.getcUserid());
            criteria2.andCRwdayEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,10));
            List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);
            System.out.println("完成了："+tGreenRwRwmxList.size()+"项任务");
            //4-1如果当日任务三项都完成了则增加金币
            if (tGreenRwRwmxList.size() == 3){
                tGreenGoldZjmxMapper.insert(tGreenGoldZjmx);
                tGreenGoldHzMapper.updateByPrimaryKey(tGreenGoldHz);
            }
        }else {
            tGreenGoldZjmxMapper.insert(tGreenGoldZjmx);
            tGreenGoldHzMapper.updateByPrimaryKey(tGreenGoldHz);
        }

    }


    /**
     * 在操作与增加金币有关的操作时验证是否是第一次操作与金币有关的任务，
     *     如果是第一次增加金币的操作则新增一条金币汇总表记录，此后对此表都是修改操作
     * @return   调用是否成功
     */
    private void checkAddGoldOperation() throws Exception{
        System.out.println("in");
        PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
        //1.获取金币汇总表中的记录，如果是第一次增加金币的操作则新增一条金币汇总表记录，此后对此表都是修改操作
        TGreenGoldHzExample tGreenGoldHzExample = new TGreenGoldHzExample();
        TGreenGoldHzExample.Criteria criteria = tGreenGoldHzExample.createCriteria();
        criteria.andCZtEqualTo("1");
        criteria.andCUseridEqualTo(plateUser.getcUserid());
        List tGreenGoldHzList = tGreenGoldHzMapper.selectByExample(tGreenGoldHzExample);
        System.out.println(tGreenGoldHzList);
        if (tGreenGoldHzList.size() < 1){
            System.out.println("in if");
            TGreenGoldHz tGreenGoldHz = new TGreenGoldHz();
            tGreenGoldHz.setcUserid(plateUser.getcUserid());
            tGreenGoldHz.setnJbzl(new BigDecimal("0"));
            tGreenGoldHz.setcZt("1");
            tGreenGoldHz.setcUserid(plateUser.getcUserid());
            tGreenGoldHz.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldHzMapper.insert(tGreenGoldHz);
        }
    }


    /**
     * 查询能量汇总表中的值是否达到足够瓜分能量的值
     * @return
     */
    private Map enabledDivideNl() throws Exception{
        Map returnMap = new HashMap();

        int nGfnlz = Integer.parseInt(getDmzByDm("C_GFNLZ_1"));//查询系统参数获取瓜分能量值

        int nDzhz = owerTGreenGoldDzhzMapper.selectSumGoldDzhz();//查询点赞汇总表中的点赞总量

        returnMap.put("isAbled",nDzhz >= nGfnlz);
        returnMap.put("nDzhz",nDzhz);
        returnMap.put("nGfnlz",nGfnlz);

        return returnMap;
    }

    /**
     * 根据代码类别与代码查询代码值
     * @param cDm
     * @return
     */
    private String getDmzByDmlbAndDm(String cDmlb,String cDm) throws Exception{
        PlateCodeDmzExample plateCodeDmzExample = new PlateCodeDmzExample();
        PlateCodeDmzExample.Criteria criteria = plateCodeDmzExample.createCriteria();
        criteria.andCDmEqualTo(cDm);
        criteria.andCDmlbEqualTo(cDmlb);
        criteria.andCZtEqualTo("1");
        PlateCodeDmz plateCodeDmz = (PlateCodeDmz)plateCodeDmzMapper.selectByExample(plateCodeDmzExample).get(0);

        return plateCodeDmz.getcDmz();
    }

    /**
     * 仅限于代码值字段不为空的查询
     * @param cDm
     * @return
     */
    private String getDmzByDm(String cDm) throws Exception{
        PlateCodeDmzExample plateCodeDmzExample = new PlateCodeDmzExample();
        PlateCodeDmzExample.Criteria criteria = plateCodeDmzExample.createCriteria();
        criteria.andCDmEqualTo(cDm);
        criteria.andCZtEqualTo("1");
        PlateCodeDmz plateCodeDmz = (PlateCodeDmz)plateCodeDmzMapper.selectByExample(plateCodeDmzExample).get(0);

        return plateCodeDmz.getcDmz();
    }

    /**
     * 仅限于代码值字段不为空的查询
     * @param cDm
     * @return
     */
    private PlateCodeDmz getDmobjByDmlbAndDm (String cDm) throws Exception{
        PlateCodeDmzExample plateCodeDmzExample = new PlateCodeDmzExample();
        PlateCodeDmzExample.Criteria criteria = plateCodeDmzExample.createCriteria();
        criteria.andCDmEqualTo(cDm);
        criteria.andCZtEqualTo("1");
        PlateCodeDmz plateCodeDmz = (PlateCodeDmz)plateCodeDmzMapper.selectByExample(plateCodeDmzExample).get(0);

        return plateCodeDmz;
    }


    /**
     * 能量充值记录
     * @param jsonObject
     * @return
     */
    @Override
    public ReturnModel selectTGreenNlCzjl(JSONObject jsonObject) {
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dkssj = sdf.parse(jsonObject.getString("dKssj"));//格式化时间

            Map params = new HashMap();
            params.put("dKssj",dkssj);
            params.put("cUserid",plateUser.getcUserid());


            List tGreenNlCzjlList = owerTGreenNlCzjlMapper.selectTGreenNlCzjl(params);

            return ReturnModelHandler.success(tGreenNlCzjlList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    /**
     * 能量提现记录
     * @param jsonObject
     * @return
     */
    @Override
    public ReturnModel selectTGreenNlTxjl(JSONObject jsonObject) {
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dkssj = sdf.parse(jsonObject.getString("dKssj"));//格式化时间

            Map params = new HashMap();
            params.put("dKssj",dkssj);
            params.put("cUserid",plateUser.getcUserid());

            List tGreenNlTxjlList = owerTGreenNlTxjlMapper.selectTGreenNlTxjl(params);

            return ReturnModelHandler.success(tGreenNlTxjlList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }


    /**
     * 种子捐赠记录
     * @param jsonObject
     * @return
     */
    @Override
    public ReturnModel selectTGreenZzJzjl(JSONObject jsonObject) {
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dkssj = sdf.parse(jsonObject.getString("dKssj"));//格式化时间

            Map params = new HashMap();
            params.put("dKssj",dkssj);
            params.put("cUserid",plateUser.getcUserid());

            List tGreenZzJzjlList = owerTGreenZzJzjlMapper.selectTGreenZzJzjl(params);

            return ReturnModelHandler.success(tGreenZzJzjlList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

}
