package cn.com.cmbc.ui;

import cn.com.cmbc.dao.AccountDao;
import cn.com.cmbc.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:
 */
public class client {
    public static void main(String[] args) {
        //1.如何调用对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService)applicationContext.getBean("accountServiceImpl");
//        AccountDao ad = (AccountDao) applicationContext.getBean("accountDaoImpl");
//        System.out.println(as);
//        System.out.println(ad);
        as.saveAccount();

    }
}
