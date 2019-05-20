package com.greenplatform.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List exclude = new ArrayList();//不拦截的列表
        exclude.add("/base/login");
        exclude.add("/publicFrame/**");
        exclude.add("/publicJs/**");
        exclude.add("/plateStatic/**");
        exclude.add("/publicImg/**");
        exclude.add("/systemStatic/**");
        exclude.add("/plate/login");
        exclude.add("/system/register");

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(exclude);
    }

}



