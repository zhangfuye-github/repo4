package com.ithaima.test;

import com.itheima.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/31
 * @Description:
 */
public class MybatisTest {

    @Test
    public void test1() throws IOException {
        //1.读取配置文件
        InputStream sqlMapconfig = Resources.getResourceAsStream("SqlMapconfig.xml");
        //2.创造sqlsessonfactory的构建者对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //3.使用构建者对象创建工厂
        SqlSessionFactory build = factoryBuilder.build(sqlMapconfig);
        //4.使用工厂对象创建对象
        SqlSession sqlSession = build.openSession();
        //5.创建代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //6.通过代理对象执行方法
        Integer count = mapper.findCount();
        System.out.println(count);
        sqlSession.close();
        sqlMapconfig.close();
    }
}
