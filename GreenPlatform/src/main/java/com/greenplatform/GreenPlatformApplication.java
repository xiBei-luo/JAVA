package com.greenplatform;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication

@MapperScan("com.greenplatform.dao.**")
public class GreenPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenPlatformApplication.class, args);
    }
}
