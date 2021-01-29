package com.ithaima;

import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/18
 * @Description:
 */
public class Demo01 {
    //对单表的操作
    @Test
    public void test() {
        ClassPathXmlApplicationContext ca=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate caBean = ca.getBean("jdbctemplate", JdbcTemplate.class);
//        caBean.update("insert into account (name,money) values ('zhang1234',555)");
//        caBean.update("delete from account where id=?",5);
//        caBean.update("update account set name=?,money=? where id=?", "lisi","1000",10);
        //查询所有
//        List<Account> list = caBean.query("select * from account", new RowMapperImpl());
//        System.out.println(list);
//        List<Account> list1 = caBean.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
//        for (Account account : list1) {
//            System.out.println(account);
//        }
        Integer integer = caBean.queryForObject("select count(*) from account where money>?", Integer.class, 1000);
        System.out.println(integer);
    }

class RowMapperImpl implements RowMapper<Account>{

    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println(rs.getRow());

//            list = new ArrayList<Account>();
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setName(rs.getString("name"));
            account.setMoney(rs.getFloat("money"));
//            list.add(account);

        return account;
    }
}
    //1.单表增删改
    //2.单表查询所有
    //3.单表查询有限定条件
    //4.单表查询单行单列
    //5.单表查询一条记录
}
