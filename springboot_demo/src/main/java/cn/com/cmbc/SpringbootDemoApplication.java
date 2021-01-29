package cn.com.cmbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

//springboot的配置引导类，就可以吧他看做是spring的配置文件
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }
    /*
    基于全注解的方式，把数据源注入到IOC容器中。。。。。
    @Bean
    public DataSource getDataSource(){
        return DataSource;
    }*/
}
