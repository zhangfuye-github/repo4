package cn.com.cmbc.test;

import cn.com.cmbc.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/23
 * @Description:
 */
public class TestSpring {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService as = (AccountService) ca.getBean("accountService");
        as.findAll();
    }
}
