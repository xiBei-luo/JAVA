package com.greenplatform.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;
    /* 注册拦截器*/


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
        exclude.add("/plate/login");
        exclude.add("/plate/insertPlateuser");

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(exclude);
    }

}



