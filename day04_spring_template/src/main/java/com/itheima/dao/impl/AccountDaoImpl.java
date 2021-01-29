package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.domain.JdbcTemp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/18
 * @Description:
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    //要想访问jdbctemplate访问数据库，首先获取获取对象
    //获取对象有两种方式，1.直接通过new的方式进行访问2.通过ioc依赖注入的方式
/*    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/
    //使用依赖注入的缺点，代码麻烦，一张表对应一个dao，一个dao里面就需要写一次。解决方法，抽取一个类，然后进行继承

    /**
     *
     * @param id
     * @return
     */
    public Account findById(Integer id) {

        List<Account> list = super.getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return  list.isEmpty()?null:list.get(0);
    }

    /**
     *
     * @param name
     * @return
     */
    public Account findByName(String name) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (list.isEmpty()) {
            return null;
        }
        if (list.size()>1){
            throw new RuntimeException("用户不唯一");
        }
        return list.get(0);
    }

    /**
     *
     * @param id
     */
    public void updateAccount(Integer id) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?", new BeanPropertyRowMapper<Account>(Account.class), "wangwu","5000",id);
    }
}
