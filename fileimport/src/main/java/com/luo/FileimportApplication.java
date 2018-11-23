package com.luo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.luo.dao")
public class FileimportApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileimportApplication.class, args);
    }
}
