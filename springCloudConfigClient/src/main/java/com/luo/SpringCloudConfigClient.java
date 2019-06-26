package com.luo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Luowenlv on 2019/1/9,16:07
 */
@SpringBootApplication
@RestController
public class SpringCloudConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClient.class, args);
    }

    @Value("${hello}")
    String hello;
    @RequestMapping(value = "/hello")
    public String hello(){
        return hello;
    }
}
