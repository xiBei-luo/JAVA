package com.greenplatform.aop;

import com.alibaba.fastjson.JSON;
import com.greenplatform.model.PlateLog;
import com.greenplatform.service.PlateService;
import com.greenplatform.util.CusAccessObjectUtil;
import com.greenplatform.util.GetcurrentLoginUser;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private PlateService plateService;
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.greenplatform.aop.OperationLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        //保存日志
        PlateLog plateLog = new PlateLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        OperationLog operationLog = method.getAnnotation(OperationLog.class);
        if (operationLog != null) {
            String value = operationLog.cCzfs();
            plateLog.setcCzfs(value);//操作方式（I新增，U修改，D删除）
        }

        plateLog.setcCzrzbh(UUID.randomUUID().toString().replaceAll("-", ""));//操作日志编号
        plateLog.setcCzr(GetcurrentLoginUser.getCurrentUser().getcUserid());//操作人
        plateLog.setdCzsj(timestamp);//操作时间
        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        plateLog.setcMethod(className + "." + methodName);//调用哪一个服务
        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        plateLog.setcParams(params);//操作传入的参数
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        plateLog.setcIp(CusAccessObjectUtil.getIpAddress(request));//操作人IP
        plateLog.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());//创建人
        plateLog.setdCjsj(timestamp);//创建时间


        //调用service保存plateLog实体类到数据库
        plateService.insertPlateLog(plateLog);
    }


}
