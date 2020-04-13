package com.plate.publicmag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.plate.publicmag.dao.**")
public class PublicmagApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicmagApplication.class, args);
    }

}
