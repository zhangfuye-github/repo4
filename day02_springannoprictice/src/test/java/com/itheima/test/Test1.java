package com.itheima.test;

import com.itheima.config.SpringConfiguration;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:
 * 整合juint
 * 1.配置xml
 * 2.添加相应的注解
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Test1 {
//    private ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//private ApplicationContext aaa=new AnnotationConfigApplicationContext(SpringConfiguration.class);
    @Autowired
    private AccountService accountservice;
    @Test
    public void testFindAll() throws SQLException {
        //1.首先加载配置文件
//        ApplicationContext aaa=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取对象
//        AccountService accountservice =(AccountService) aaa.getBean("accountService");

        List<Account> all = accountservice.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }
    @Test
    public void testFindOne() throws SQLException {
//        AccountService accountservice =(AccountService) aaa.getBean("accountService");
        Account one = accountservice.findOne(5);
        System.out.println(one);
    }
    @Test
    public void testSave() throws SQLException {
        Account account = new Account();
        account.setMoney(5000.0f);
        account.setName("zhangsan");
//        AccountService accountservice =(AccountService) aaa.getBean("accountService");
        accountservice.saveAccount(account);
//        Account one = accountservice.findOne(4);
//        System.out.println(one);
    }
    @Test
    public void testUpdate() throws SQLException {
        Account account = new Account();
        account.setMoney(55550.0f);
        account.setName("zh");
        account.setId(6);
//        AccountService accountservice =(AccountService) aaa.getBean("accountService");
        accountservice.updateAccount(account);
        Account one = accountservice.findOne(6);
        System.out.println(one);
    }
    @Test
    public void testDelete() throws SQLException {
//        AccountService accountservice =(AccountService) aaa.getBean("accountService");
        accountservice.deleteAccount(6);
        Account one = accountservice.findOne(6);
        System.out.println(one);
    }
//    @Test
//    public void test1() throws SQLException {
////        Object userController = aaa.getBean("userController");
////        int count = aaa.getBeanDefinitionCount();
//        System.out.println(count);
////        String[] names = aaa.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//    }
}
