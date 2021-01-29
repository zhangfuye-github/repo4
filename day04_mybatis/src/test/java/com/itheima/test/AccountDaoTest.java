package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Account;
import com.itheima.domain.QueryVO;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/2
 * @Description:
 */
public class AccountDaoTest {
    private AccountDao mapper;
    private InputStream inputStream;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        //1.加载配置文件

        inputStream = Resources.getResourceAsStream("SqlMapConfing.xml");
        //2.创造构建者
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //3.构建工厂
        SqlSessionFactory factory = factoryBuilder.build(inputStream);
        //4.生产代理对象

        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destory() throws IOException {
        //6.释放资源
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public  void testfindAll() throws IOException {
        //5.执行方法
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
