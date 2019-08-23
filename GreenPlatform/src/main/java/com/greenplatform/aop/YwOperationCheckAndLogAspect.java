package com.greenplatform.aop;

import com.alibaba.fastjson.JSON;
import com.greenplatform.dao.PlateLogMapper;
import com.greenplatform.model.PlateLog;
import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.util.CusAccessObjectUtil;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.TimeUtil;
import com.greenplatform.util.returnUtil.ReturnModelHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * 验证前端用户是否（是否实名制）
 * 调用方法后记录操作日志
 *
 * 排除前端用户注册时的验证操作
 */
@Aspect
@Component
@Order(1)
public class YwOperationCheckAndLogAspect {
    @Autowired
    private PlateLogMapper plateLogMapper;


    @Pointcut("@annotation( com.greenplatform.aop.YwOperationCheckAndLog)")
    public void ywOperPoinCut() {
    }

    //调用前-验证
    @Around("ywOperPoinCut()")
    public ReturnModel beforeywOperPoinCut(ProceedingJoinPoint proceedingJoinPoint){
        ReturnModel returnModel = new ReturnModel();


        try {
            //前端用户注册时不用验证是否实名制
            if(!(proceedingJoinPoint.getSignature().getName().equals("doRegister"))){
                PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
                //1.前端用户未实名制不能进行操作
                if ("2".equals(plateUser.getcRylb()) && !(("1").equals(plateUser.getcIssmz()))){
                    return ReturnModelHandler.error("请先完成实名制再进行业务操作！");
                }else{
                    returnModel = (ReturnModel) proceedingJoinPoint.proceed();
                }
            }else{
                returnModel = (ReturnModel) proceedingJoinPoint.proceed();
            }
            return returnModel;
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作出错，系统错误！");
            returnModel.setObject(null);
            return returnModel;
        }
    }


    //调用后保存日志
    @After("ywOperPoinCut()")
    public void afterywOperPoinCut(JoinPoint  proceedingJoinPoint){
        saveSysLog(proceedingJoinPoint);
    }

    //处理异常
    @AfterThrowing("ywOperPoinCut()")
    public void afterThrowingPoinCut(){
        System.out.println("出现异常啦~~~");
    }


    /**
     *
     * @param proceedingJoinPoint
     */
    private void saveSysLog(JoinPoint proceedingJoinPoint){
        //保存日志
        PlateLog plateLog = new PlateLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        YwOperationCheckAndLog ywOperationCheckAndLog = method.getAnnotation(YwOperationCheckAndLog.class);
        if (ywOperationCheckAndLog != null) {
            String value = ywOperationCheckAndLog.cCzfs();
            plateLog.setcCzfs(value);//操作方式（I新增，U修改，D删除）
        }

        plateLog.setcCzrzbh(UUID.randomUUID().toString().replaceAll("-", ""));//操作日志编号
        plateLog.setcCzr(GetcurrentLoginUser.getCurrentUser().getcUserid());//操作人
        plateLog.setdCzsj(TimeUtil.getTimestamp(new Date()));//操作时间

        //获取请求的类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        plateLog.setcMethod(className + "." + methodName);//调用哪一个服务
        //请求的参数
        Object[] args = proceedingJoinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        plateLog.setcParams(params);//操作传入的参数
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        plateLog.setcIp(CusAccessObjectUtil.getIpAddress(request));//操作人IP
        plateLog.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());//创建人
        plateLog.setdCjsj(TimeUtil.getTimestamp(new Date()));//创建时间


        //调用service保存plateLog实体类到数据库
        plateLogMapper.insert(plateLog);
    }



}
