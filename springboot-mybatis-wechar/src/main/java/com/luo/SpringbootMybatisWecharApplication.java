package com.luo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luo.dao")
public class SpringbootMybatisWecharApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisWecharApplication.class, args);
    }
}
