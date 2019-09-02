package com.greenplatform.interceptor;

import com.greenplatform.model.PlateUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;


/**
 * 登陆验证
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {


    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        //1.系统维护中不能被访问(0点至早上5点维护时间不能被访问)
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 0 && hour < 0 && requestURI.contains("web")) {
            //System.out.println("0点到5点系统维护中");
            response.sendRedirect(request.getContextPath()+"/base/safeguard");  //系统维护中不能被访问，跳转至维护页面
            return false;
        }


        //2.用户登陆及权限验证
        //System.out.println("preHandle被调用！");
        PlateUser plateUser = (PlateUser) request.getSession().getAttribute("loginUser");
        //System.out.println("当前登陆用户--"+plateUser);
        if(plateUser == null){
            //2-1未登陆，返回登陆页面
            response.sendRedirect(request.getContextPath()+"/base/login");  //未登录自动跳转界面
            return false;
        }else{
            //2-2已登陆，判断用户权限

            //2-2-1.判断是否是是前端用户访问后台管理页面或后台用户访问前端页面,权限控制
            //System.out.println(requestURI);
            if(plateUser.getcRylb().equals("2")&&requestURI.contains("plate")) {
                //response.getWriter().print("<a href= \" http://localhost:8080/Interceptor_2/user/toLoginPage.do\" >当前用户无权限访问该页面</a>");
                response.sendRedirect(request.getContextPath()+"/base/login");  //没有权限返回登陆页面
                return false;
            }else if(plateUser.getcRylb().equals("1")&&requestURI.contains("web")){
                response.sendRedirect(request.getContextPath()+"/base/login");  //没有权限返回登陆页面
                return false;
            }else{
                return true;
            }

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle被调用！");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion被调用！");
    }
}
