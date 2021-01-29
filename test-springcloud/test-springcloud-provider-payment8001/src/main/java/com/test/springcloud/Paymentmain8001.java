package com.test.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:
 */
@SpringBootApplication(scanBasePackages="com.test.springcloud")
@EnableEurekaServer
public class Paymentmain8001 {
    public static void main(String[] args) {
        SpringApplication.run(Paymentmain8001.class,args);
    }
}
