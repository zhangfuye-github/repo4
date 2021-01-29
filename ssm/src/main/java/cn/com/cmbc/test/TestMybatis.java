package cn.com.cmbc.test;

import cn.com.cmbc.dao.AccountDao;
import cn.com.cmbc.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/23
 * @Description:
 */
public class TestMybatis {
    @Test
    public void testMybatis() throws IOException {
        //首先，加载配置文件
        InputStream resources = Resources.getResourceAsStream("sqlMapConfig.xml");
        //使用构建者模式构建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //构建工厂
        SqlSessionFactory build = builder.build(resources);
        //创建SQLsession
        SqlSession sqlSession = build.openSession();
        //获得代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);

        }
        sqlSession.close();
        resources.close();

    }
    @Test
    public void testSave() throws IOException {
        Account account1 = new Account();
        account1.setMoney(1000d);
        account1.setName("lisi");
        //首先，加载配置文件
        InputStream resources = Resources.getResourceAsStream("sqlMapConfig.xml");
        //使用构建者模式构建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //构建工厂
        SqlSessionFactory build = builder.build(resources);
        //创建SQLsession
        SqlSession sqlSession = build.openSession();
        //获得代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        mapper.saveUser(account1);
        sqlSession.commit();
        sqlSession.close();
        resources.close();

    }

}
