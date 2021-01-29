package com.itheima.test;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/4
 * @Description:
 */
public class RoleDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao mapper;
    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfing.xml");
        //2.创建构造者对象，优点：省略了创建对象的细节
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.由构建者构建工厂
        SqlSessionFactory sessionFactory = builder.build(in);
        //4.工厂生产代理对象
        sqlSession = sessionFactory.openSession();
        mapper = sqlSession.getMapper(RoleDao.class);
    }
    @After
    public void distory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll() throws IOException {
        //5.执行方法
        List<Role> all = mapper.findAll();
        for (Role role : all) {
            System.out.println(role);
            System.out.println(role.getUserList());
        }
    }
}
