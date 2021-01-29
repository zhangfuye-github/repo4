package com.itheima.ui;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.util.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/11
 * @Description:
 */
public class SaveAccount {
    public static void main(String[] args) {
        //1.首先创建业务逻辑层的对象
        //2.调用业务逻辑层的方法
//        for (int i = 0; i < 5; i++) {
//            AccountService accountservice = (AccountServiceImpl)BeanFactory.getBean("accountservice");
//            System.out.println(accountservice);
//            accountservice.saveAccount();
//        }
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountServiceImpl)ac.getBean("accountService");
//        AccountDao accountDao = ac.getBean("accountDao", AccountDaoImpl.class);
//        System.out.println(accountDao);
//        System.out.println(accountService);
        accountService.saveAccount();
    }
}
