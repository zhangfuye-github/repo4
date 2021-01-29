package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/13
 * @Description:
 * @Configuration 该注解的作用用来声明该类是一个配置文件类，spring可以通过一个构造方法加载该配置类。
 * @ComponentScan(basePackages = "com.itheima") 该注解的作用和配置文件中的一个标签一样，用来加载配置文件。
 * @Bean 该注解的作用用来创建一个对象并将对象放到容器中
 */
@Configuration
@ComponentScan(basePackages = "com.itheima")
public class SpringConfiguration {
    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createRunner(DataSource datasource){
//        System.out.println(123);
        QueryRunner runner=new QueryRunner(datasource);
        return runner;
    }
    @Bean("datasource")
    public DataSource creatDataSource(){
//        System.out.println(456);
        ComboPooledDataSource ds=new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql:///springdb");
            ds.setUser("root");
            ds.setPassword("123456");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
