package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:
 */
public class Test1 {
    private ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void testFindAll() throws SQLException {
        //1.首先加载配置文件

        //2.获取对象
        AccountService accountservice =(AccountService) ac.getBean("accountservice");

        List<Account> all = accountservice.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }
    @Test
    public void testFindOne() throws SQLException {
        AccountService accountservice =(AccountService) ac.getBean("accountservice");
        Account one = accountservice.findOne(5);
        System.out.println(one);
    }
    @Test
    public void testSave() throws SQLException {
        Account account = new Account();
        account.setMoney(5000.0f);
        account.setName("zhangsan");
        AccountService accountservice =(AccountService) ac.getBean("accountservice");
        accountservice.saveAccount(account);
//        Account one = accountservice.findOne(4);
//        System.out.println(one);
    }
    @Test
    public void testUpdate() throws SQLException {
        Account account = new Account();
        account.setMoney(55550.0f);
        account.setName("zh");
        account.setId(5);
        AccountService accountservice =(AccountService) ac.getBean("accountservice");
        accountservice.updateAccount(account);
//        Account one = accountservice.findOne(5);
//        System.out.println(one);
    }
    @Test
    public void testDelete() throws SQLException {
        AccountService accountservice =(AccountService) ac.getBean("accountservice");
        accountservice.deleteAccount(4);
//        System.out.println(one);
    }
}
