package com.ithaima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/18
 * @Description:
 */
public class Demo02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountdao = context.getBean("accountdao", AccountDao.class);
        Account byId = accountdao.findById(1);
        System.out.println(byId);
    }
}
