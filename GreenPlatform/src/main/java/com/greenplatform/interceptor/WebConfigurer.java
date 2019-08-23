package com.greenplatform.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;
    /* 注册拦截器*/

    /**
     * 注册添加静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    /**
     * 注册添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List exclude = new ArrayList();//不拦截的列表

        //静态资源
        exclude.add("/publicFrame/**");
        exclude.add("/publicJs/**");
        exclude.add("/publicImg/**");
        exclude.add("/js/**");
        exclude.add("/style/**");

        //登录页与注册页
        exclude.add("/base/login");
        exclude.add("/base/register");
        exclude.add("/base/loginByPhone");
        exclude.add("/base/getBackPassword");
        exclude.add("/base/doGetBackPassword");
        exclude.add("/base/loginByWx");
        exclude.add("/base/registerByWx");
        exclude.add("/base/tipPage");

        exclude.add("/checkForm/**");
        exclude.add("/login/**");

        //邀请注册二维码
        exclude.add("/qrcode/**");

        //主页
        exclude.add("/*");

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(exclude);
    }

}



