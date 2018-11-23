package com.luo.filetest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
/*@MapperScan("com.luo.filetest.dao")*/
public class FiletestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiletestApplication.class, args);
    }
}
