package com.greenplatform;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication

@MapperScan("com.greenplatform.dao.**")
public class GreenPlatformApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GreenPlatformApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(GreenPlatformApplication.class, args);
    }
}

/**
 * 配置外部tomcat调试步骤：
 *  1.启动类继承SpringBootServletInitializer，重写configure方法
 *  2.移除pom中springboot内置tomcat依赖
 *  3.添加servlet依赖
 *  4.修改application.yml中请求上下文配置
 */
