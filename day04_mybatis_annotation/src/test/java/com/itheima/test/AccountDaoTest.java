package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Account;
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
import java.util.Date;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/6
 * @Description:
 */
public class AccountDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao mapper;
    @Before
    public void init() throws IOException {
        //1.加载配置文件
        in = Resources.getResourceAsStream("SQLMapConfig.xml");
        //2.创建构建者
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //3.通过构建者创建工厂
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(in);
        //4.通过工厂生产代理对象
        sqlSession = factory.openSession();
        //5.代理对象增强方法，调用
        mapper = sqlSession.getMapper(AccountDao.class);
    }
    @After
    public void destory() throws IOException {
        //6.提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll() throws IOException {
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
