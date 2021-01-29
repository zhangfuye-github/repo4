package cn.com.cmbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:这是一个springboot的引导类
 *
 * 使用springboot共4步：
 *      1.创建maven工程
 *      2.起步依赖导入
 *      3.创建引导类
 *      4.编写controller
 *      5.配置springboot的热部署：
 *          首先引入一个依赖，idea开启热部署。。。。。
 */
//声明该类是springboot的引导类。。。。。
@SpringBootApplication
public class MySpringBootContext {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootContext.class);
    }
}
