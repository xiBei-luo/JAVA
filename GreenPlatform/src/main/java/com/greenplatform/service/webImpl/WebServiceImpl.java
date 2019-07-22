package com.greenplatform.service.webImpl;

import com.greenplatform.aop.YwOperationCheckAndLog;
import com.greenplatform.dao.*;
import com.greenplatform.dao.owerMapper.OwerTGreenGoldDzhzMapper;
import com.greenplatform.dao.owerMapper.OwerTGreenNlHzMapper;
import com.greenplatform.dao.owerMapper.OwerTGreenZzZjzzmxMapper;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.WebService;
import com.greenplatform.service.utilImpl.UtilServiceImpl;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.*;

@Transactional
@Service
public class WebServiceImpl implements WebService {
    @Autowired
    UtilServiceImpl utilService;
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



    ReturnModel returnModel = new ReturnModel();


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
                returnModel.setFlag(1);
                returnModel.setMsg("您今天已完成该项任务了！");
                returnModel.setObject(null);
                return returnModel;
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
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel buySeeds(TGreenZzZjzzmx tGreenZzZjzzmx) {
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

            //1.同一账户下只能同时种植一类植物
            for (int i=0;i<tGreenZzZjzzmxList.size();i++){
                TGreenZzZjzzmx tGreenZzZjzzmx1 = (TGreenZzZjzzmx) tGreenZzZjzzmxList.get(i);
                if (tGreenZzZjzzmx1.getcSpbh().equals(tGreenZzZjzzmx.getcSpbh())){
                    returnModel.setFlag(1);
                    returnModel.setMsg("您已经有这类种子正在种植中，无法进行兑换！");
                    returnModel.setObject(null);
                    return returnModel;
                }
            }


            int tGreenZzZjzzmxCount = tGreenZzZjzzmxList.size();
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

                BigDecimal userNlzl = ((TGreenNlHz) tGreenNlHzList.get(0)).getnNlhz();//获取指定账户的能量总量
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

                BigDecimal zzPrice = ((TGreenSpSpmx) tGreenSpSpmxList.get(0)).getnSpjg();//获取种子的价格
                if (tGreenNlHzList.isEmpty()){
                    returnModel.setFlag(1);
                    returnModel.setMsg("您的能量不足，快去完成任务获取能量吧！");
                    returnModel.setObject(null);
                }else if(userNlzl.compareTo(zzPrice) == -1) {
                    returnModel.setFlag(1);
                    returnModel.setMsg("您的能量不足，快去完成任务获取能量吧！");
                    returnModel.setObject(null);
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

                TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
                TGreenRwRwmxExample.Criteria criteriaTGreenRwRwmxExample = tGreenRwRwmxExample.createCriteria();
                criteriaTGreenRwRwmxExample.andCUseridEqualTo(loginUserId);
                criteriaTGreenRwRwmxExample.andCZtEqualTo("1");
                criteriaTGreenRwRwmxExample.andCRwdayEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,10));

                List plateuserList = plateUserMapper.selectByExample(plateUserExample);//人员姓名与人员等级

                List tGreenNlHzList = tGreenNlHzMapper.selectByExample(tGreenNlHzExample);//查询能量总量

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
     * 查询首页所需信息（当前人当日任务完成情况，点赞排行榜前十，能量汇总排行前十，商品明细）
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
                //1.商品
                TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
                TGreenSpSpmxExample.Criteria criteriaTGreenSpSpmxExample = tGreenSpSpmxExample.createCriteria();
                criteriaTGreenSpSpmxExample.andCZtEqualTo("1");
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
                loginUserHomeMap.put("tGreenRwRwmx",rwmxMap);

                //4.点赞排行榜前十
                List tGreenGoldDzhzList = owerTGreenGoldDzhzMapper.selectGreenGoldDzhzRank();
                loginUserHomeMap.put("tGreenGoldDzhzList",tGreenGoldDzhzList);
                System.out.println("点赞排行榜");
                System.out.println(tGreenGoldDzhzList);

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
                returnModel.setFlag(1);
                returnModel.setMsg("系统正在准备瓜分能量，暂时不能进行点赞！");
                returnModel.setObject(null);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return returnModel;
            }

            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            //1.判断账户金币是否足够点赞一次
            TGreenGoldHzExample tGreenGoldHzExample1 = new TGreenGoldHzExample();
            TGreenGoldHzExample.Criteria criteria3 = tGreenGoldHzExample1.createCriteria();
            criteria3.andCZtEqualTo("1");
            criteria3.andCUseridEqualTo(plateUser.getcUserid());
            List tGreenGoldHzList1 = tGreenGoldHzMapper.selectByExample(tGreenGoldHzExample1);

            if (tGreenGoldHzList1.size() < 1){
                returnModel.setFlag(1);
                returnModel.setMsg("金币不足，快去做任务获取金币吧！");
                returnModel.setObject(null);
                return returnModel;
            }

            TGreenGoldHz tGreenGoldHz1 = (TGreenGoldHz) tGreenGoldHzList1.get(0);
            PlateCodeXtcs plateCodeXtcs = utilService.getPlateCodeXtcsObject("C_DZSL_ONE");
            if(tGreenGoldHz1.getnJbzl().compareTo(new BigDecimal(plateCodeXtcs.getcValue())) == -1){
                returnModel.setFlag(1);
                returnModel.setMsg("金币不足，快去做任务获取金币吧！");
                returnModel.setObject(null);
                return returnModel;
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
            tGreenGoldJsmx.setnJssl(new BigDecimal(plateCodeXtcs.getcValue()));
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
            tGreenGoldHz.setnJbzl(tGreenGoldHz.getnJbzl().subtract(new BigDecimal(plateCodeXtcs.getcValue())));
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

            returnModel.setFlag(0);
            returnModel.setMsg("恭喜你，点赞成功！");
            returnModel.setObject(null);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 实名制服务，还需要调整（2019-07-17）
     * @param plateUser
     * @return
     */
    @Override
    public ReturnModel certification(PlateUser plateUser) {

        //1.验证账户，查询平台表中是否有记录，若没有则新增一条，若有则修改各个参数状态
        PlateUser plateUser1 = plateUserMapper.selectByPrimaryKey(plateUser.getcUserid());
        plateUser1.setcIssmz("1");
        plateUser1.setcXguser(plateUser.getcUserid());
        plateUser1.setdXgsj(TimeUtil.getTimestamp(new Date()));
        plateUserMapper.updateByPrimaryKey(plateUser1);


        //2.实名制完成后要更新session域中的值


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


        returnModel.setFlag(0);
        returnModel.setMsg("");
        returnModel.setObject(null);
        return returnModel;
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
     * 新增金币操作
     * 使用AOP@After时，其中有大量事务，导致目标方法无法回滚，因此不能使用该方法
     * @param cZjyy
     * @return
     */
    private void addGoldOperation(String cZjyy) throws Exception{
        PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
        //3.获取新增金币类型，判断：如果是完成基础任务，则要完成三个任务才增加金币
        PlateCodeXtcs plateCodeXtcs = utilService.getPlateCodeXtcsObject(cZjyy);
        String cZjyysm = plateCodeXtcs.getcSm();//金币增加原因中文
        String nZjsl = plateCodeXtcs.getcValue();//金币增加数量

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
        PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
        //1.获取金币汇总表中的记录，如果是第一次增加金币的操作则新增一条金币汇总表记录，此后对此表都是修改操作
        TGreenGoldHzExample tGreenGoldHzExample = new TGreenGoldHzExample();
        TGreenGoldHzExample.Criteria criteria = tGreenGoldHzExample.createCriteria();
        criteria.andCZtEqualTo("1");
        criteria.andCUseridEqualTo(plateUser.getcUserid());
        List tGreenGoldHzList = tGreenGoldHzMapper.selectByExample(tGreenGoldHzExample);
        if (tGreenGoldHzList.size() < 1){
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
    private Map enabledDivideNl(){
        Map returnMap = new HashMap();

        PlateCodeXtcs plateCodeXtcs = utilService.getPlateCodeXtcsObject("C_GFNLZ");
        int nGfnlz = Integer.parseInt(plateCodeXtcs.getcValue());//查询系统参数获取瓜分能量值

        int nDzhz = owerTGreenGoldDzhzMapper.selectSumGoldDzhz();//查询点赞汇总表中的点赞总量

        returnMap.put("isAbled",nDzhz >= nGfnlz);
        returnMap.put("nDzhz",nDzhz);
        returnMap.put("nGfnlz",nGfnlz);

        return returnMap;
    }

}
