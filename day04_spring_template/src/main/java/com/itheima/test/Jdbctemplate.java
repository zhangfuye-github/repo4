package com.itheima.test;

import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/17
 * @Description:
 */
public class Jdbctemplate {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///springdb");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        JdbcTemplate jt=new JdbcTemplate();
        jt.setDataSource(dataSource);
        jt.execute("insert into account (name,money) values('zhangfuye',2000)");

    }
}
