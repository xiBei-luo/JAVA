package com.greenplatform.aop;

import com.greenplatform.dao.PlateCodeXtcsMapper;
import com.greenplatform.dao.TGreenGoldHzMapper;
import com.greenplatform.dao.TGreenGoldZjmxMapper;
import com.greenplatform.dao.TGreenRwRwmxMapper;
import com.greenplatform.model.*;
import com.greenplatform.service.utilImpl.UtilServiceImpl;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.TimeUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 增加金币业务：（如果是第一次增加账户金币则需要新增一条金币汇总表）
 * 增加账户金币的业务：每日种植任务；分享平台；捐赠植物
 * 调用这三个服务时需使用此注解来增加对应账户的金币数
 *
 * 业务说明：1.判断是否第一次增加金币==>金币汇总表中增加一条记录
 * 2.增加金币明细表中增加一条记录
 * 3.修改金币汇总表记录
 * 4.如果是基础任务获得金币说要判断是否三次任务都已完成==>三项任务都完成才增加一条记录
 */
@Aspect
@Component
public class WebAddGoldAspect {
    @Autowired
    TGreenGoldHzMapper tGreenGoldHzMapper;
    @Autowired
    TGreenRwRwmxMapper tGreenRwRwmxMapper;
    @Autowired
    TGreenGoldZjmxMapper tGreenGoldZjmxMapper;
    @Autowired
    PlateCodeXtcsMapper plateCodeXtcsMapper;
    @Autowired
    UtilServiceImpl utilService;




    @Pointcut("@annotation(com.greenplatform.aop.WebAddGold)")
    public void addGoldPoincut(){

    }

    @Before("addGoldPoincut()")
    public void beforeAddGold(){
        System.out.println("增加金币before");
        try{
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
                tGreenGoldHz.setnJbzl(new BigDecimal("1"));
                tGreenGoldHz.setcZt("1");
                tGreenGoldHz.setcUserid(plateUser.getcUserid());
                tGreenGoldHz.setdCjsj(TimeUtil.getTimestamp(new Date()));
                tGreenGoldHzMapper.insert(tGreenGoldHz);
            }

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }


    @AfterReturning("addGoldPoincut()")
    public void watchAddGold(JoinPoint joinPoint){
        System.out.println("增加金币after");
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            //3.获取新增金币类型，判断：如果是完成基础任务，则要完成三个任务才增加金币
            //从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();
            WebAddGold webAddGold = method.getAnnotation(WebAddGold.class);
            String cAddType = webAddGold.cAddType();//获取当前增加金币的操作
            String cZjyy = cAddType;//金币增加原因

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

            if (cAddType.equals("C_GOLD_ZJYY_1")){
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
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }



}
