package com.test.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:
 */
@Configuration      //加入这个注解的类，表示该类是springboot的配置类，既可以在application.yml中添加配置，也可以通过该注解添加配置
public class AppConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
