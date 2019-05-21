package com.greenplatform.config;

import com.greenplatform.model.PlateUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("preHandle被调用！");
        PlateUser user = (PlateUser) request.getSession().getAttribute("loginUser");
        System.out.println("当前登陆用户--"+user);
        if(user == null){
            //未登陆，返回登陆页面
            response.sendRedirect(request.getContextPath()+"/base/login");  //未登录自动跳转界面
            return false;
        }else{
            //已登陆，判断用户权限

            //判断是否是是前端用户访问后台管理页面,权限控制
            String requestURI = request.getRequestURI();
            //System.out.println(requestURI);
            if(user.getcRylb().equals("2")&&requestURI.contains("plate")) {
                //response.getWriter().print("<a href= \" http://localhost:8080/Interceptor_2/user/toLoginPage.do\" >当前用户无权限访问该页面</a>");
                response.sendRedirect(request.getContextPath()+"/base/login");  //没有权限返回登陆页面
                return false;
            }else {
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
