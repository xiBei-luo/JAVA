package com.plate.publicmag.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
     *
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List exclude = new ArrayList();//不拦截的列表

        //静态资源
        exclude.add("/css/**");
        exclude.add("/images/**");
        exclude.add("/font-awesome/**");
        exclude.add("/js/**");

        //登录页与注册页
        exclude.add("/Plate/login");
        exclude.add("/Login/login");


        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(exclude);
    }

}



