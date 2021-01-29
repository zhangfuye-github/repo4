package com.test.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:该类作为作为服务发布注册中心
 */
@EnableEurekaServer //使用该注解自动注册与发布
@SpringBootApplication
public class EurekaMain8761 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain8761.class, args);
    }
}
