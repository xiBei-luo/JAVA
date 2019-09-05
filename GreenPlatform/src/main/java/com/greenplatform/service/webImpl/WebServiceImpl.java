package com.greenplatform.service.webImpl;

import com.greenplatform.aop.YwOperationCheckAndLog;
import com.greenplatform.dao.*;
import com.greenplatform.dao.owerMapper.*;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.qrcode.QRCodeUtil;
import com.greenplatform.service.WebService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.TimeUtil;
import com.greenplatform.util.returnUtil.ReturnModelHandler;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    TGreenNlGfjlMapper tGreenNlGfjlMapper;
    @Autowired
    PlateUserFatherMapper plateUserFatherMapper;
    @Autowired
    OwerTGreenRwRwmxMapper owerTGreenRwRwmxMapper;

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



    /**
     * 业务说明：1.判断用户账户内是否有可捐赠的种子，有则需捐赠后再做任务；
     *          2.用户账户内是否有未捐赠/不可捐赠/有效的种子，有则可进行任务，没得则需要购买种子后再做任务；
     *          3.完成任务前验证：是否是第一次操作与金币有关的业务（基础任务与金币业务有关联）；
     *          4.验证当日的前一天是否有完成任务，如果有则继续任务，如果没有则视为不是连续操作，则将该用户所有任务记录状态置为无效
     *              4-1如果三种基础任务没有连续完成，且当前任务是当日第一次完成则将任务汇总表置0
     *          5.查询数据验证当前任务是否已完成，已完成返回错误信息，否则：新增任务明细记录，修改任务汇总记录
     *          6.金币操作（如果完成了当日的三项任务则新增账户金币——明细表，汇总表）
     *          7.完成当前任务后，验证是否连续一个月完成基础任务，是则修改种子状态为可捐赠
     * 完成每日任务
     * 只允许一种种子正在种植中
     * @param tGreenRwRwmx
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel accomplishRw(TGreenRwRwmx tGreenRwRwmx) {
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();

            //1.验证用户是否有有效种子
            TGreenZzZjzzmxExample tGreenZzZjzzmxExample1 = new TGreenZzZjzzmxExample();
            TGreenZzZjzzmxExample.Criteria criteria3 = tGreenZzZjzzmxExample1.createCriteria();
            criteria3.andCZtEqualTo("1");
            criteria3.andCUseridEqualTo(plateUser.getcUserid());
            List tGreenZzZjzzmxList1 = tGreenZzZjzzmxMapper.selectByExample(tGreenZzZjzzmxExample1);
            if (tGreenZzZjzzmxList1.size() < 1){
                return ReturnModelHandler.error("您的账户下没有种子，请购买种子后操作！");
            }
            //1.验证种子是否可捐赠
            criteria3.andCKjzEqualTo("1");
            tGreenZzZjzzmxList1 = tGreenZzZjzzmxMapper.selectByExample(tGreenZzZjzzmxExample1);
            if (tGreenZzZjzzmxList1.size() > 0){
                return ReturnModelHandler.error("您有一颗可捐赠的种子，请捐赠后再操作！");
            }


            checkAddGoldOperation();//调用前验证是否需要新增金币汇总表记录

            //1.查询完成任务当日的前一天是否有完成任务，若前一天没有完成任务则视用户操作为不是连续完成任务，先删除当前用户的此前任务操作，再完成当日任务
            TGreenRwRwmxExample tGreenRwRwmxExample1 = new TGreenRwRwmxExample();
            TGreenRwRwmxExample.Criteria criteria2 = tGreenRwRwmxExample1.createCriteria();
            criteria2.andCZtEqualTo("1");
            criteria2.andCUseridEqualTo(plateUser.getcUserid());
            //获取当前日期的前一天
            String prevDayOfCur = getPrevDayOfCur(TimeUtil.getLocalDate(new Date()),-1);
            criteria2.andCRwdayEqualTo(prevDayOfCur);
            List tGreenRwRwmxList1 = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample1);
            //若用户完成任务的前一天没有完成任务则将此前任务状态修改为无效,并修改任务汇总表，将该用户任务汇总表的记录置为0
            if (tGreenRwRwmxList1.size() < 3){
                Map paramMap = new HashMap();
                paramMap.put("cUserid",plateUser.getcUserid());
                paramMap.put("cZt","0");
                paramMap.put("dXgsj",TimeUtil.getTimestamp(new Date()));
                paramMap.put("cXguser",plateUser.getcUserid());
                paramMap.put("cRwday",TimeUtil.getLocalDate(new Date()).substring(0,10));
                //修改状态为无效
                owerTGreenRwRwmxMapper.updateZtBycUserid(paramMap);


                //如果当日是第一次完成任务，则置任务汇总条数为0
                TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
                TGreenRwRwmxExample.Criteria criteria = tGreenRwRwmxExample.createCriteria();
                criteria.andCZtEqualTo("1");
                criteria.andCUseridEqualTo(plateUser.getcUserid());
                criteria.andCRwdayEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,10));
                List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);
                if (tGreenRwRwmxList.size() < 1){
                    TGreenRwRwhz tGreenRwRwhz = tGreenRwRwhzMapper.selectByPrimaryKey(plateUser.getcUserid());
                    tGreenRwRwhz.setnLjwccs(0);//置为0
                    tGreenRwRwhz.setdXgsj(TimeUtil.getTimestamp(new Date()));
                    tGreenRwRwhz.setcXguser(plateUser.getcUserid());
                    //任务汇总置空
                    tGreenRwRwhzMapper.updateByPrimaryKey(tGreenRwRwhz);
                }
            }

            String localDateDay = (TimeUtil.getLocalDate(new Date()).substring(0,10));
            String localDateMonth = (TimeUtil.getLocalDate(new Date()).substring(0,7));

            //今日任务是否完成
            TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
            TGreenRwRwmxExample.Criteria criteria = tGreenRwRwmxExample.createCriteria();
            criteria.andCUseridEqualTo(plateUser.getcUserid());
            criteria.andCRwlbEqualTo(tGreenRwRwmx.getcRwlb());
            criteria.andCRwdayEqualTo(localDateDay);
            criteria.andCZtEqualTo("1");
            List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);
            if(!(tGreenRwRwmxList.isEmpty())){
                return ReturnModelHandler.error("您今天已完成该项任务了！");
            }else{
                //1.任务明细中增加一条记录
                tGreenRwRwmx.setcUserid(plateUser.getcUserid());
                tGreenRwRwmx.setcCjuser(plateUser.getcUserid());
                tGreenRwRwmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
                tGreenRwRwmx.setcZt("1");
                tGreenRwRwmx.setcRwmouth(localDateMonth);
                tGreenRwRwmx.setcRwday(localDateDay);
                tGreenRwRwmx.setdRwsj(TimeUtil.getTimestamp(new Date()));
                tGreenRwRwmxMapper.insert(tGreenRwRwmx);

                //2.修改任务汇总表
                TGreenRwRwhz tGreenRwRwhz = tGreenRwRwhzMapper.selectByPrimaryKey(plateUser.getcUserid());
                tGreenRwRwhz.setnLjwccs(tGreenRwRwhz.getnLjwccs() + 1);
                tGreenRwRwhz.setdXgsj(TimeUtil.getTimestamp(new Date()));
                tGreenRwRwhz.setcXguser(plateUser.getcUserid());
                tGreenRwRwhzMapper.updateByPrimaryKey(tGreenRwRwhz);

                addGoldOperation("C_GOLD_ZJYY_1");//调用后增加对金币表相关的操作

                //是否连续一个月完成任务，若是，则将种子状态修改为"可捐赠"
                boolean isContinueAcomreplishRw = isContinueAcomreplishRw(plateUser.getcUserid());
                if (isContinueAcomreplishRw == true){
                    TGreenZzZjzzmxExample tGreenZzZjzzmxExample = new TGreenZzZjzzmxExample();
                    TGreenZzZjzzmxExample.Criteria criteria1 = tGreenZzZjzzmxExample.createCriteria();
                    criteria1.andCZtEqualTo("1");
                    criteria1.andCUseridEqualTo(plateUser.getcUserid());
                    criteria1.andCKjzEqualTo("0");
                    criteria1.andCSfjzEqualTo("0");
                    List tGreenZzZjzzmxList = tGreenZzZjzzmxMapper.selectByExample(tGreenZzZjzzmxExample);

                    TGreenZzZjzzmx tGreenZzZjzzmx = (TGreenZzZjzzmx) tGreenZzZjzzmxList.get(0);
                    tGreenZzZjzzmx.setcKjz("1");
                    tGreenZzZjzzmx.setcXguser(plateUser.getcUserid());
                    tGreenZzZjzzmx.setdXgsj(TimeUtil.getTimestamp(new Date()));
                    tGreenZzZjzzmxMapper.updateByPrimaryKey(tGreenZzZjzzmx);
                }


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
            //System.out.println(tGreenZzZjzzmxCount);
            if (tGreenZzZjzzmxCount > 0){
                return ReturnModelHandler.error("平台一次只允许种植一种植物，请捐赠后再来兑换！");
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
     * 查询我的账户信息（人员姓名，人员等级，能量总量,金币总量,点赞总量，种子汇总，今日任务，徒弟账户）
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

                //查询是否连续一个月完成任务
                int nMonthRw = countContinueAcomreplishRw(GetcurrentLoginUser.getCurrentUser().getcUserid());

                //种子明细
                Map paramsMap = new HashMap();
                paramsMap.put("cUserid",loginUserId);
                paramsMap.put("cSfjz","0");

                //徒弟账户
                PlateUserFatherExample plateUserFatherExample = new PlateUserFatherExample();
                PlateUserFatherExample.Criteria criteria2 = plateUserFatherExample.createCriteria();
                criteria2.andCZtEqualTo("1");
                criteria2.andCUseridEqualTo(GetcurrentLoginUser.getCurrentUser().getcUserid());
                List plateUserFatherList = plateUserFatherMapper.selectByExample(plateUserFatherExample);//查询到徒弟账户ID
                List sonUseridList = new ArrayList();//存放子账户id


                Iterator iterator = plateUserFatherList.iterator();
                while (iterator.hasNext()){
                    PlateUserFather plateUserFather = (PlateUserFather) iterator.next();
                    sonUseridList.add(plateUserFather.getcSonid());//取子账户id
                }
                //System.out.println("子账户id列表："+sonUseridList);

                List plateUserSonList = new ArrayList();
                if (sonUseridList.size() > 0){
                    /*//子账户主信息（姓名，ID）
                    PlateUserExample plateUserSonExample = new PlateUserExample();
                    PlateUserExample.Criteria criteria3 = plateUserSonExample.createCriteria();
                    plateUserSonExample.setOrderByClause("c_username");
                    criteria3.andCUseridIn(sonUseridList);
                    plateUserSonList = plateUserMapper.selectByExample(plateUserSonExample);*/

                    //子账户任务完成情况
                    Iterator iterator1 = sonUseridList.iterator();
                    while (iterator1.hasNext()){
                        String soncUserid = iterator1.next().toString();
                        Map plateUserSonMap = new HashMap();
                        plateUserSonMap.put("cUserid",soncUserid);
                        plateUserSonMap.put("cUsername",getcUsernameByUserid(soncUserid));

                        TGreenRwRwmxExample tGreenRwRwmxExample1 = new TGreenRwRwmxExample();
                        TGreenRwRwmxExample.Criteria criteria4 = tGreenRwRwmxExample1.createCriteria();
                        criteria4.andCUseridEqualTo(soncUserid);
                        criteria4.andCZtEqualTo("1");
                        criteria4.andCRwdayEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,10));
                        List sonTGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample1);

                        Map sonRwmxMap = new HashMap();
                        sonRwmxMap.put("1",false);
                        sonRwmxMap.put("2",false);
                        sonRwmxMap.put("3",false);
                        for (int i=0;i<sonTGreenRwRwmxList.size();i++){
                            TGreenRwRwmx tGreenRwRwmx = (TGreenRwRwmx) sonTGreenRwRwmxList.get(i);
                            sonRwmxMap.put(tGreenRwRwmx.getcRwlb(),true);
                        }
                        plateUserSonMap.put("sonUserRwmx",sonRwmxMap);
                        plateUserSonList.add(plateUserSonMap);
                    }

                    //System.out.println(plateUserSonList);
                }



                List tGreenZzZjzzmxList = owerTGreenZzZjzzmxMapper.selectTGreenZzZjzzmx(paramsMap);//查询种子明细

                List tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);//查询当日任务完成情况明细

                loginuserAccountMap = new HashMap();
                loginuserAccountMap.put("plateUser",plateuserList);
                loginuserAccountMap.put("tGreenNlHz",tGreenNlHzList);
                loginuserAccountMap.put("tGreenZzZjzzmx",tGreenZzZjzzmxList);
                loginuserAccountMap.put("tGreenRwRwmx",tGreenRwRwmxList);
                loginuserAccountMap.put("nMonthRw",nMonthRw);
                loginuserAccountMap.put("tGreenDzzl",tGreenGoldDzhzList);
                loginuserAccountMap.put("tGreenJbzl",tGreenGoldJbhzList);
                loginuserAccountMap.put("plateUserSon",plateUserSonList);
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
                int countRank = countContinueAcomreplishRw(plateUser.getcUserid());
                String tmpTxt = "sm";
                if(countRank >= 20){
                    tmpTxt = "big";
                }else if(countRank > 10 && countRank < 20){
                    tmpTxt = "mid";
                }

                rwmxMap.put("endRwCountDay",tmpTxt);//完成任务天数

                loginUserHomeMap.put("tGreenRwRwmx",rwmxMap);

                //4.点赞排行榜前十
                List tGreenGoldDzhzList = owerTGreenGoldDzhzMapper.selectGreenGoldDzhzRank();
                loginUserHomeMap.put("tGreenGoldDzhzList",tGreenGoldDzhzList);

                //6.当前登陆人的能量排名
                Map tGreenNlHzMap = new HashMap();
                tGreenNlHzMap.put("cUsername",plateUser.getcUsername());
                tGreenNlHzMap.put("cUserid",plateUser.getcUserid());

                Map tGreenNlHzMap1 = owerTGreenNlHzMapper.selectTGreenNlHzBycUserid(plateUser.getcUserid());
                if (null == tGreenNlHzMap1){
                    tGreenNlHzMap.put("nRank","暂无");
                    tGreenNlHzMap.put("n_nlhz","0");
                }else{

                    tGreenNlHzMap.put("nRank",tGreenNlHzMap1.get("rank").toString().split("\\.")[0]);
                    tGreenNlHzMap.put("n_nlhz",tGreenNlHzMap1.get("n_nlhz"));
                }
                loginUserHomeMap.put("owerTGreenNlHz",tGreenNlHzMap);



                //7.当前登陆人的点赞排名
                Map tGreenGoldDzhzMap = new HashMap();
                tGreenGoldDzhzMap.put("cUsername",plateUser.getcUsername());
                tGreenGoldDzhzMap.put("cUserid",plateUser.getcUserid());

                Map tGreenGoldDzhzMap1 = owerTGreenGoldDzhzMapper.selectTGreenGoldDzhzBycUserid(plateUser.getcUserid());
                if (null == tGreenGoldDzhzMap1 || tGreenGoldDzhzMap1.isEmpty()){
                    tGreenGoldDzhzMap.put("nRank","暂无");
                    tGreenGoldDzhzMap.put("n_dzzl","0");
                }else{
                    tGreenGoldDzhzMap.put("nRank",tGreenGoldDzhzMap1.get("rank").toString().split("\\.")[0]);
                    tGreenGoldDzhzMap.put("n_dzzl",tGreenGoldDzhzMap1.get("n_dzzl"));
                }
                loginUserHomeMap.put("owerTGreenGoldDzhz",tGreenGoldDzhzMap);

                //5.当前登陆人信息
                loginUserHomeMap.put("plateUser",plateUser);

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
            if ((boolean)enabledDivideNlMap.get("isAbled") == true){
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
            tGreenGoldDzmx.setnDzsl(new BigDecimal("50"));//50金币对应50个赞
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
            tGreenGoldDzhz.setnDzzl(tGreenGoldDzhz.getnDzzl().add(new BigDecimal("50")));//50金币对应50个赞
            tGreenGoldDzhz.setcXguser(plateUser.getcUserid());
            tGreenGoldDzhz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldDzhzMapper.updateByPrimaryKey(tGreenGoldDzhz);

            //系统能量值是否达到10万
            Map afterEnableDivideMap = enabledDivideNl();
            if ((boolean)afterEnableDivideMap.get("isAbled") == true){
                //关闭点赞服务,开启瓜分能量
                divideNl();
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
    public ReturnModel certification(PlateUser plateUser, HttpSession session) {

        //1.验证身份证号，手机号码


        //1.验证账户，查询平台表中是否有记录，若没有则新增一条，若有则修改各个参数状态
        PlateUser plateUser1 = plateUserMapper.selectByPrimaryKey(plateUser.getcUserid());
        if (!plateUser.getcPhone().equals(plateUser1.getcPhone())){
            return ReturnModelHandler.error("验证失败，手机号码与注册时输入手机号码不一致！");
        }
        plateUser1.setcIssmz("1");
        plateUser1.setcUsername(plateUser.getcUsername());
        plateUser1.setcPhone(plateUser.getcPhone());
        plateUser1.setcZjhm(plateUser.getcZjhm());
        int tmpSex = Integer.parseInt(plateUser.getcZjhm().substring(16,17));
        plateUser1.setcSex(tmpSex%2 == 0 ? "2" : "1");
        plateUser1.setcXguser(plateUser.getcUserid());
        plateUser1.setdXgsj(TimeUtil.getTimestamp(new Date()));
        plateUserMapper.updateByPrimaryKey(plateUser1);


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

        //5.该账户下任务汇总表的状态置为有效
        TGreenRwRwhz tGreenRwRwhz = tGreenRwRwhzMapper.selectByPrimaryKey(plateUser.getcUserid());
        tGreenRwRwhz.setcZt("1");
        tGreenRwRwhz.setcXguser(plateUser.getcUserid());
        tGreenRwRwhz.setdXgsj(TimeUtil.getTimestamp(new Date()));
        tGreenRwRwhzMapper.updateByPrimaryKey(tGreenRwRwhz);

        //2.实名制完成后要移除session域中的值，重新登陆系统
        //session.setAttribute("loginUser",plateUser1);
        session.removeAttribute("loginUser");

        return ReturnModelHandler.success(null);
    }


    /**
     * 金币点赞数达到10万，瓜分能量业务
     * 瓜分规则：排名前一百可瓜分固定数的绿沙能量，
     * 第一名88能量，第二名：58能量，第三名：38能量，4-10：18能量，
     * 11-50：8能量，51-100：2能量，101名后获得随机数量金币，（随机数范围？）
     *
     * 点赞数排名每个名次仅一名用户，点赞数量相同时，按完成时间排列；
     * 瓜分能量，存历史数据，清空数据
     */
    @Override
    public void divideNl() throws Exception {
        //System.out.println("开始瓜分能量！");

        //1.获取排名
        //2.奖励能量，奖励金币
        //3.瓜分记录表添加一条记录
        //4.清空能量汇总表记录


        //1.获取排名
        List tGreenGoldDzhzList = owerTGreenGoldDzhzMapper.selectGreenGoldDzhzAllRank();

        //系统参数排名几位之前瓜分能量
        int countGfNl = Integer.parseInt(getDmzByDm("C_GFNL_COUNT_1"));//金币点赞活动中排名前几的瓜分能量


        //2.奖励能量
        List tGreenGoldDzhzList1 = new ArrayList();
        if (tGreenGoldDzhzList.size() > countGfNl){
            tGreenGoldDzhzList1 = tGreenGoldDzhzList.subList(0,countGfNl);
        }else{
            tGreenGoldDzhzList1 = tGreenGoldDzhzList;
        }
        //System.out.println("瓜分能量用户"+tGreenGoldDzhzList1);
        ReturnModel divideNlByUser = divideNlByUser(tGreenGoldDzhzList1);


        //3.奖励金币
        List tGreenGoldDzhzList2 = new ArrayList();
        if (tGreenGoldDzhzList.size() > countGfNl){
            tGreenGoldDzhzList2 = tGreenGoldDzhzList.subList(countGfNl,tGreenGoldDzhzList.size());
            //System.out.println("瓜分金币用户："+tGreenGoldDzhzList2);
            ReturnModel divideGoldByUser = divideGoldByUser(tGreenGoldDzhzList2);
        }

        //3.瓜分记录增加一条数据
        int nSumDzzl = owerTGreenGoldDzhzMapper.selectSumGoldDzhz();
        //System.out.println(nSumDzzl);
        TGreenNlGfjl tGreenNlGfjl = new TGreenNlGfjl();
        tGreenNlGfjl.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
        tGreenNlGfjl.setdGfsj(TimeUtil.getTimestamp(new Date()));
        tGreenNlGfjl.setnGfzl(new BigDecimal(nSumDzzl));
        tGreenNlGfjl.setcCzr(GetcurrentLoginUser.getCurrentUser().getcUserid());
        tGreenNlGfjl.setcZt("1");
        tGreenNlGfjlMapper.insert(tGreenNlGfjl);

        //4.清空点赞汇总表
        Map tGreenGoldDzhzMap = new HashMap();
        String cBz = "清空点赞数，原因：金币点赞瓜分能量活动,时间："+TimeUtil.getTimestamp(new Date()).toString();

        tGreenGoldDzhzMap.put("nDzzl",new BigDecimal("0"));
        tGreenGoldDzhzMap.put("cXguser",GetcurrentLoginUser.getCurrentUser().getcUserid());
        tGreenGoldDzhzMap.put("dXgsj",TimeUtil.getTimestamp(new Date()));
        tGreenGoldDzhzMap.put("cBz",cBz);
        owerTGreenGoldDzhzMapper.clearAllGoldDzhz(tGreenGoldDzhzMap);


    }



    /**
     * 业务说明：
     *          1.判断种子是否可捐赠（此处不应连续完成一个月任务判断在于，若用户连续一个月完成了基础任务，
     *                              但没有立刻捐赠种子，第二天若用户点击了任务按钮则会把之前的任务次数清为0，
     *                              则这颗种子已经是可捐赠的，但是由于查询任务未满30天，则无法进行捐赠）
     *          2.同一天只能捐赠一种植物，判断是否有一天捐赠两次操作
     *          3.修改种子增加明细表种种子状态为已捐赠
     *          4.新增捐赠记录表数据
     *          5.新增能量：能量增加明细记录表，能量汇总表
     *              5-1：查询账户等级：2级：2%，3级：3%，4级：5%
     *          6.新增金币：金币增加明细记录表，金币汇总表
     *          7.是否有父账户：有则：
     *              7-1.父账户新增能量：能量明细表，能量汇总表
     *          8.修改任务：任务明细表记录为无效，任务汇总表置为"0"
     *          9.验证用户是否连续三个月完成任务：
     *              9-1.查询用户一共捐赠了几颗种子，第三颗对应一级，第六颗对应二级，以此类推，修改用户等级
     *
     *
     * 捐赠植物业务
     * @param cSpbh  捐赠植物编号
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel contributeSeed(String cLsh,String cSpbh) {
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            //1.判断种子是否可捐赠
            TGreenZzZjzzmx tGreenZzZjzzmx1 = tGreenZzZjzzmxMapper.selectByPrimaryKey(cLsh);
            if (!("1".equals(tGreenZzZjzzmx1.getcKjz()))){
                return ReturnModelHandler.error("种子还不能进行捐赠！");
            }

            //1.同一账户24小时内只能捐赠一种植物（需要调整判断是否是同一天）
            TGreenZzJzjlExample tGreenZzJzjlExample = new TGreenZzJzjlExample();
            TGreenZzJzjlExample.Criteria criteria1 = tGreenZzJzjlExample.createCriteria();
            criteria1.andCUseridEqualTo(plateUser.getcUserid());
            criteria1.andCZtEqualTo("1");
            criteria1.andCJzdayEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,10));
            List tGreenZzJzjlList = tGreenZzJzjlMapper.selectByExample(tGreenZzJzjlExample);
            if (tGreenZzJzjlList.size() > 0){
                return ReturnModelHandler.error("您今天已经捐赠植物了，同一天只能捐赠一次！");
            }


            //1.查询系统参数，需要查询的参数包括
            //当前种子捐赠后可得到多少能量奖励；如仙人掌：112
            //当前用户账户等级对应的额外奖励有多少？如二级可得到2%额外奖励
            //当前账户的父账户奖励规则？如师傅可得到的固定奖励为100，额外奖励为植物奖励的5%
            //完成植物种植获取的金币数量？
            //种子价格
            //种子价格（师傅获得奖励是是种子本身价格的5%，而不是徒弟捐赠奖励的5%）
            //如仙人掌价值100，徒弟捐赠后能得112，师傅的额外奖励是100*5%
            TGreenSpSpmx tGreenSpSpmx = tGreenSpSpmxMapper.selectByPrimaryKey(cSpbh);
            float nSpjg = tGreenSpSpmx.getnSpjg().floatValue();

            float sysParamOfAddNl = Float.parseFloat(getDmzByDm("C_ZWJZJL_NL_"+cSpbh));//捐赠种子后得到的能量奖励


            float sysParamOfUserLev = Float.parseFloat(getDmzByDm("C_ZHDJ_EXTJL_"+plateUser.getcRydj()));//账户等级对应的能量奖励百分比


            float extraNL = sysParamOfUserLev*sysParamOfAddNl;//账户等级对应的能量奖励


            float sysParamOfFatherGd = Float.parseFloat(getDmzByDm("C_FATHER_JL_GD"));//父账户固定奖励


            float sysParamOfFatherExt = Float.parseFloat(getDmzByDm("C_FATHER_JL_EXT"));//父账户额外奖励

            float fatherZjnlSum = sysParamOfFatherGd + (sysParamOfFatherExt*nSpjg);//捐赠后父账户一共得到的能量奖励(固定奖励+浮动奖励)


            //师傅账户是否有固定奖励判断，徒弟第一次捐赠则师傅有固定奖励，否则只有浮动奖励5%
            TGreenZzJzjlExample tGreenZzJzjlExample1 = new TGreenZzJzjlExample();
            TGreenZzJzjlExample.Criteria criteria = tGreenZzJzjlExample1.createCriteria();
            criteria.andCUseridEqualTo(plateUser.getcUserid());
            criteria.andCZtEqualTo("1");
            List tGreenZzJzjlList1 = tGreenZzJzjlMapper.selectByExample(tGreenZzJzjlExample1);
            if (tGreenZzJzjlList1.size() > 0){
                fatherZjnlSum = sysParamOfFatherExt*nSpjg;//若徒弟不是第一次捐赠
            }


            //float sysParamOfGoldJlPer = Float.parseFloat(getDmzByDm("C_ZWJZJL_GOLD_"+cSpbh));//植物捐赠后的金币奖励



            float sysParamOfGoldJl = 500;//植物捐赠后的金币奖励值，固定500

            /*System.out.println("捐赠此植物的能量奖励"+sysParamOfAddNl);
            System.out.println("捐赠此植物的账户等级额外奖励百分比"+sysParamOfUserLev);
            System.out.println("捐赠此植物的账户等级额外奖励值"+extraNL);
            System.out.println("捐赠此植物的父账户固定奖励"+sysParamOfFatherGd);
            System.out.println("捐赠此植物的父账户额外奖励"+sysParamOfFatherExt);
            System.out.println("捐赠此植物的金币奖励百分比"+sysParamOfGoldJlPer);
            System.out.println("捐赠此植物的金币奖励值"+sysParamOfGoldJl);*/

            //2.修改种子增加明细表种子状态（已捐赠，捐赠时间）
            TGreenZzZjzzmx tGreenZzZjzzmx = tGreenZzZjzzmxMapper.selectByPrimaryKey(cLsh);
            tGreenZzZjzzmx.setcSfjz("1");
            tGreenZzZjzzmx.setcZt("0");
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
            tGreenZzJzjl.setcJzday(TimeUtil.getLocalDate(new Date()).substring(0,10));
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
            tGreenNlZjnlmx.setcZt("1");
            tGreenNlZjnlmx.setcBz("捐赠奖励");
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
                TGreenNlZjnlmx tGreenNlZjnlmx1 = new TGreenNlZjnlmx();//父账户增加一条能量增加明细记录
                TGreenNlHz tGreenNlHz1 = tGreenNlHzMapper.selectByPrimaryKey(plateUser.getcFatherid());//父账户修改能量汇总

                tGreenNlZjnlmx1.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
                tGreenNlZjnlmx1.setcUserid(plateUser.getcFatherid());
                tGreenNlZjnlmx1.setnZjnl(new BigDecimal(fatherZjnlSum));
                tGreenNlZjnlmx1.setdZjsj(TimeUtil.getTimestamp(new Date()));
                tGreenNlZjnlmx1.setcZjyy("C_NL_ZJYY_2");
                tGreenNlZjnlmx1.setcBz("徒弟完成植物捐赠");
                tGreenNlZjnlmx1.setcZt("1");
                tGreenNlZjnlmx1.setdCjsj(TimeUtil.getTimestamp(new Date()));
                tGreenNlZjnlmx1.setcCjuser(plateUser.getcUserid());
                tGreenNlZjnlmxMapper.insert(tGreenNlZjnlmx1);

                tGreenNlHz1.setnNlhz(tGreenNlHz1.getnNlhz().add(new BigDecimal(fatherZjnlSum)));
                tGreenNlHz1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                tGreenNlHz1.setcXguser(plateUser.getcUserid());
                tGreenNlHzMapper.updateByPrimaryKey(tGreenNlHz1);

            }

            //9.用户捐赠种子后，需要将任务明细表状态修改为无效
            Map paramMap = new HashMap();
            paramMap.put("cUserid",plateUser.getcUserid());
            paramMap.put("cZt","0");
            paramMap.put("cXguser",plateUser.getcUserid());
            paramMap.put("dXgsj",TimeUtil.getTimestamp(new Date()));
            owerTGreenRwRwmxMapper.clearPlateUserRwmx(paramMap);

            //10.任务汇总表置0
            TGreenRwRwhz tGreenRwRwhz = tGreenRwRwhzMapper.selectByPrimaryKey(plateUser.getcUserid());
            tGreenRwRwhz.setnLjwccs(0);
            tGreenRwRwhz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenRwRwhz.setcXguser(plateUser.getcUserid());
            tGreenRwRwhzMapper.updateByPrimaryKey(tGreenRwRwhz);

            //11.判断用户捐赠了几颗种子（3/6/9分别对应账户等级2/3/4，每到这几个数字时需要将用户的等级做提升）
            TGreenZzJzjlExample tGreenZzJzjlExample2 = new TGreenZzJzjlExample();
            TGreenZzJzjlExample.Criteria criteria2 = tGreenZzJzjlExample2.createCriteria();
            criteria2.andCZtEqualTo("1");
            criteria2.andCUseridEqualTo(plateUser.getcUserid());
            List tGreenZzJzjlList2 = tGreenZzJzjlMapper.selectByExample(tGreenZzJzjlExample2);

            plateUser.setdXgsj(TimeUtil.getTimestamp(new Date()));
            plateUser.setcXguser(plateUser.getcUserid());

            System.out.println("用户一共捐赠了"+tGreenZzJzjlList2.size()+"颗种子");

            if (tGreenZzJzjlList2.size() == 3){
                plateUser.setcRydj("2");
                plateUserMapper.updateByPrimaryKey(plateUser);
            }else if(tGreenZzJzjlList2.size() == 6){
                plateUser.setcRydj("3");
                plateUserMapper.updateByPrimaryKey(plateUser);
            }else if (tGreenZzJzjlList2.size() == 9){
                plateUser.setcRydj("4");
                plateUserMapper.updateByPrimaryKey(plateUser);
            }


            return ReturnModelHandler.success(null);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }


    /**
     * 能量充值(调用微信接口)
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel rechargeNl() {
        return null;
    }


    /**
     * 能量提现（调用微信接口）
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
    private Map enabledDivideNl() throws Exception{
        Map returnMap = new HashMap();

        int nGfnlz = Integer.parseInt(getDmzByDm("C_GFNLZ_1"));//查询系统参数获取瓜分能量值,10万

        int nDzhz = owerTGreenGoldDzhzMapper.selectSumGoldDzhz();//查询点赞汇总表中的点赞总量

        returnMap.put("isAbled",nDzhz >= nGfnlz);
        returnMap.put("nDzhz",nDzhz);
        returnMap.put("nGfnlz",nGfnlz);

        System.out.println("====点赞池中点赞数达到可瓜分====");
        System.out.println("系统参数："+nGfnlz);
        System.out.println("点赞总量："+nDzhz);
        System.out.println(returnMap);

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


    /**
     * 配置首页不需要登陆，欢迎页显示数据
     * @return
     */
    @Override
    public ReturnModel selectWelcomePageInfo() {
        try{
            Map loginUserHomeMap = new HashMap();

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

            //3.点赞排行榜前十
            List tGreenGoldDzhzList = owerTGreenGoldDzhzMapper.selectGreenGoldDzhzRank();
            loginUserHomeMap.put("tGreenGoldDzhzList",tGreenGoldDzhzList);

            return ReturnModelHandler.success(loginUserHomeMap);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }


    /**
     * 获取当前登陆人请求的邀请注册平台二维码
     * @return
     */
    @Override
    public ReturnModel getInviteQrcode(HttpServletRequest httpServletRequest) {
        try{
            PlateUserFatherExample plateUserFatherExample = new PlateUserFatherExample();
            PlateUserFatherExample.Criteria criteria = plateUserFatherExample.createCriteria();
            criteria.andCZtEqualTo("1");
            criteria.andCUseridEqualTo(GetcurrentLoginUser.getCurrentUser().getcUserid());
            criteria.andCFxmouthEqualTo(TimeUtil.getLocalDate(new Date()).substring(0,7));
            List plateUserFatherList = plateUserFatherMapper.selectByExample(plateUserFatherExample);
            if (plateUserFatherList.size() >= 5){
                return ReturnModelHandler.success("C:/Users/Administrator/greenplatformTmp/qrcode/error.png");
            }




            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            //扫描后跳转路径（跳转至注册页面）
            String qrcodeUrl = "http://lhwlljnw.com/base/qrcodeRegister?user="+plateUser.getcUserid();//正式环境
            //String qrcodeUrl = "http://127.0.0.1/base/qrcodeRegister?user="+plateUser.getcUserid();//测试环境
            // 嵌入二维码的图片路径
            String imgPath = "C:/Users/Administrator/greenplatformTmp/logo.png";//正式环境
            //String imgPath = "C:/Users/CDMCS/Desktop/logo.png";//测试环境

            // 生成的二维码的路径及名称
            String destPath = "C:/Users/Administrator/greenplatformTmp/qrcode/"+plateUser.getcUserid()+".jpg";//正式环境
            //String destPath = "C:/Users/CDMCS/Desktop/qrcode/"+plateUser.getcUserid()+".jpg";//测试环境

            //生成二维码
            QRCodeUtil.encode(qrcodeUrl, imgPath, destPath, true);
            // 解析二维码
            String str = QRCodeUtil.decode(destPath);
            // 打印出解析出的内容
            //System.out.println(str);

            return ReturnModelHandler.success(destPath);
        }catch (Exception e){
            e.printStackTrace();
            return ReturnModelHandler.systemError();
        }
    }

    /**
     * 查询是否连续一个月完成基础任务
     * @param cUserid
     * @return
     */
    private boolean isContinueAcomreplishRw(String cUserid) throws Exception{
        //查询是否连续一个月完成任务
        TGreenRwRwhz tGreenRwRwhz = tGreenRwRwhzMapper.selectByPrimaryKey(cUserid);
        int nMonthRw = (int) Math.floor(tGreenRwRwhz.getnLjwccs()/3);//连续完成任务天数(三项任务，因此要除以3)

        int enableJzParams = Integer.parseInt(getDmzByDm("C_JZ_RWDAY_1"));//完成任务天数可捐赠种子系统参数

        System.out.println("系统参数捐赠种子任务天数："+enableJzParams);
        System.out.println("连续完成任务天数："+nMonthRw);
        System.out.println("是否可捐赠：" + (nMonthRw >= enableJzParams));

        return nMonthRw >= enableJzParams;
    }

    /**
     * 查询连续完成任务天数
     * @param cUserid
     * @return
     */
    private int countContinueAcomreplishRw(String cUserid){
        TGreenRwRwhz tGreenRwRwhz = tGreenRwRwhzMapper.selectByPrimaryKey(cUserid);

        int nMonthRw = (int) Math.ceil(tGreenRwRwhz.getnLjwccs()/3);
        return nMonthRw;
    }

    /**
     * 瓜分能量时，奖励能量
     * list<Map>
     * list = [
     *      {"c_userid":"3309b23c28584179b9d69e226e3eeeee","n_zjnl":88},
     *      {"c_userid":"b55cbb78e1e54da7a14171c34031f692","n_zjnl":58}
     * ]
     * @param list
     * @return
     */
    private ReturnModel divideNlByUser(List list) throws Exception{
        //System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Map map = (Map) iterator.next();
            //System.out.println(map);
            //1.增加能量明细新增一条记录
            String nZjnl = "";//增加能量
            Integer rank = Integer.parseInt(map.get("rank").toString().split("\\.")[0]);
            if (1 == rank){
                nZjnl = getDmzByDm("C_NL_DZGF_1");
            }else if(2 == rank){
                nZjnl = getDmzByDm("C_NL_DZGF_2");
            }else if(3 == rank){
                nZjnl = getDmzByDm("C_NL_DZGF_3");
            }else if (rank>=4 && rank<=10){
                nZjnl = getDmzByDm("C_NL_DZGF_4-10");
            }else if(rank>=11 && rank<=50){
                nZjnl = getDmzByDm("C_NL_DZGF_11-50");
            }else if(rank>=51 && rank<=100){
                nZjnl = getDmzByDm("C_NL_DZGF_51-100");
            }
            //System.out.println("第"+rank+"名"+"奖励能量："+nZjnl);

            TGreenNlZjnlmx tGreenNlZjnlmx = new TGreenNlZjnlmx();
            tGreenNlZjnlmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenNlZjnlmx.setcUserid(map.get("cUserid").toString());
            tGreenNlZjnlmx.setnZjnl(new BigDecimal(nZjnl));
            tGreenNlZjnlmx.setdZjsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlZjnlmx.setcZjyy("C_NL_ZJYY_3");//点赞活动瓜分能量
            tGreenNlZjnlmx.setcBz("金币点赞瓜分能量获得奖励");
            tGreenNlZjnlmx.setcZt("1");
            tGreenNlZjnlmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenNlZjnlmx.setdCjsj(TimeUtil.getTimestamp(new Date()));

            tGreenNlZjnlmxMapper.insert(tGreenNlZjnlmx);
            //System.out.println("第"+rank+"名增加能量明细："+tGreenNlZjnlmx);

            //2.修改能量汇总表
            TGreenNlHz tGreenNlHz = tGreenNlHzMapper.selectByPrimaryKey(map.get("cUserid").toString());
            tGreenNlHz.setnNlhz(tGreenNlHz.getnNlhz().add(new BigDecimal(nZjnl)));
            tGreenNlHz.setcZt("1");
            tGreenNlHz.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenNlHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            //System.out.println("第"+rank+"名能量汇总："+tGreenNlHz);

            tGreenNlHzMapper.updateByPrimaryKey(tGreenNlHz);
        }

        return ReturnModelHandler.success(null);
    }


    /**
     * 瓜分能量时，奖励金币
     *
     * list = [
     *      {"cUserid":"3309b23c28584179b9d69e226e3eeeee","n_zjsl":100},
     *      {"cUserid":"b55cbb78e1e54da7a14171c34031f692","n_zjsl":200}
     * ]
     * @param list
     * @return
     */
    private ReturnModel divideGoldByUser(List list) throws Exception{
        //System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Map map = (Map) iterator.next();
            //System.out.println(iterator.next());

            int nZjsl = (int)(300+Math.random()*(500-300+1));//300-500的随机数
            //System.out.println("随机数金币"+nZjsl);

            //1.增加明细新增一条记录
            TGreenGoldZjmx tGreenGoldZjmx = new TGreenGoldZjmx();
            tGreenGoldZjmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenGoldZjmx.setcUserid(map.get("cUserid").toString());
            tGreenGoldZjmx.setnZjsl(new BigDecimal(nZjsl));
            tGreenGoldZjmx.setdZjsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldZjmx.setcZjyy("C_GOLD_ZJYY_4");
            tGreenGoldZjmx.setcZjyysm("金币点赞活动奖励金币");
            tGreenGoldZjmx.setcZt("1");
            tGreenGoldZjmx.setcBz("金币点赞活动奖励随机数量金币");
            tGreenGoldZjmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenGoldZjmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldZjmxMapper.insert(tGreenGoldZjmx);


            //2.修改汇总表
            TGreenGoldHz tGreenGoldHz = tGreenGoldHzMapper.selectByPrimaryKey(map.get("cUserid").toString());
            tGreenGoldHz.setnJbzl(tGreenGoldHz.getnJbzl().add(new BigDecimal(nZjsl)));
            tGreenGoldHz.setcZt("1");
            tGreenGoldHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenGoldHz.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenGoldHzMapper.updateByPrimaryKey(tGreenGoldHz);
        }

        return ReturnModelHandler.success(null);
    }

    /**
     * 获取用户姓名根据用户id
     * @param cUserid
     * @return
     */
    private String getcUsernameByUserid(String cUserid){
        PlateUserExample plateUserExample = new PlateUserExample();
        PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
        criteria.andCUseridEqualTo(cUserid);
        criteria.andCRylbEqualTo("2");
        criteria.andCRyxzEqualTo("1");
        criteria.andCRyztEqualTo("1");
        criteria.andCZtEqualTo("1");
        criteria.andCIssmzEqualTo("1");

        List plateUserList = plateUserMapper.selectByExample(plateUserExample);
        PlateUser plateUser = (PlateUser) plateUserList.get(0);

        return plateUser.getcUsername();
    }


    /**
     * 获取当前日期的前几天或后几天
     * @param time
     * @return
     */
    private String getPrevDayOfCur(String time,int day){
        String sub = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date timeNow = df.parse(time);
            Calendar begin=Calendar.getInstance();
            begin.setTime(timeNow);
            begin.add(Calendar.DAY_OF_MONTH,day);
            sub = df.format(begin.getTime());
            //System.out.println(sub);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sub;
    }


}
