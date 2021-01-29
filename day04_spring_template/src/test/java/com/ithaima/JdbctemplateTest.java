package com.ithaima;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/17
 * @Description:
 */
public class JdbctemplateTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbctemplate = (JdbcTemplate)context.getBean("jdbctemplate");
        jdbctemplate.execute("insert into account (name,money) values('zhangfuye1',2000)");
    }

}
