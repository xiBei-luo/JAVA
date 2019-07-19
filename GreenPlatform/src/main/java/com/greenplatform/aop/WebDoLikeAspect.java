package com.greenplatform.aop;


import com.greenplatform.dao.PlateCodeXtcsMapper;
import com.greenplatform.dao.TGreenGoldDzhzMapper;
import com.greenplatform.dao.owerMapper.OwerTGreenGoldDzhzMapper;
import com.greenplatform.model.PlateCodeXtcs;
import com.greenplatform.model.PlateCodeXtcsExample;
import com.greenplatform.model.base.ReturnModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 金币点赞业务：
 * 调用用户点赞业务前后都需要判断金币点赞池中的点赞数有无达到10万
 * 前：未达到十万，调用点赞，达到十万：停止调用
 * 后：未达到十万，继续，达到十万：停用点赞业务，设置定时任务两个小时候调用瓜分金币业务
 */
public class WebDoLikeAspect {
    @Autowired
    TGreenGoldDzhzMapper tGreenGoldDzhzMapper;

    @Autowired
    OwerTGreenGoldDzhzMapper owerTGreenGoldDzhzMapper;

    @Autowired
    PlateCodeXtcsMapper plateCodeXtcsMapper;

    @Pointcut("@annotation( com.greenplatform.aop.WebDoLike)")
    public void doLikePoincut(){

    }

    //环绕通知
    @Around("doLikePoincut()")
    public ReturnModel watchGoldDzhz(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("in like");
        ReturnModel returnModel = new ReturnModel();//返回值
        Map divideNlMap = enabledDivideNl();

        try{
            if ((boolean)divideNlMap.get("isAbled")){
                returnModel.setFlag(1);
                returnModel.setMsg("系统正在准备瓜分能量，暂时不能进行点赞！");
                returnModel.setObject(null);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return returnModel;
                //停止调用目标方法
            }else{
                //调用目标方法
                returnModel = (ReturnModel) proceedingJoinPoint.proceed();//调用目标方法
                //再次判断是否达到瓜分能量值
                Map enableDivideMap = enabledDivideNl();
                if ((boolean)divideNlMap.get("isAbled")){
                    //关闭点赞服务,开启瓜分能量
                    System.out.println("能量达到十万啦~~~现在开始瓜分能量");
                }

                return returnModel;
            }

        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作出错，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作出错，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


    /**
     * 查询能量汇总表中的值是否达到足够瓜分能量的值
     * @return
     */
    private Map enabledDivideNl(){
        Map returnMap = new HashMap();

        PlateCodeXtcsExample plateCodeXtcsExample = new PlateCodeXtcsExample();
        PlateCodeXtcsExample.Criteria criteria = plateCodeXtcsExample.createCriteria();
        criteria.andCZtEqualTo("1");
        criteria.andCKeyEqualTo("C_GFNLZ");
        List plateCodeXtcsList = plateCodeXtcsMapper.selectByExample(plateCodeXtcsExample);
        PlateCodeXtcs plateCodeXtcs = (PlateCodeXtcs) plateCodeXtcsList.get(0);
        int nGfnlz = Integer.parseInt(plateCodeXtcs.getcValue());//查询系统参数获取瓜分能量值

        int nDzhz = owerTGreenGoldDzhzMapper.selectSumGoldDzhz();//查询点赞汇总表中的点赞总量

        returnMap.put("isAbled",nDzhz >= nGfnlz);
        returnMap.put("nDzhz",nDzhz);
        returnMap.put("nGfnlz",nGfnlz);

        return returnMap;
    }



}




