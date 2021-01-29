package com.itheima.test;

import com.itheima.dao.UserDao;
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
public class UserDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao mapper;
    private SqlSessionFactory factory;
    @Before
    public void init() throws IOException {
        //1.加载配置文件
        in = Resources.getResourceAsStream("SQLMapConfig.xml");
        //2.创建构建者
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //3.通过构建者创建工厂

        factory = sqlSessionFactoryBuilder.build(in);
        //4.通过工厂生产代理对象
        sqlSession = factory.openSession();
        //5.代理对象增强方法，调用
        mapper = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        //6.提交事务

        in.close();
    }
    @Test
    public void testFindAll() throws IOException {
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
            System.out.println(user.getList());
        }
    }
    @Test
    public void testupdateUserById() throws IOException {
        User user1 = new User();
        user1.setUserId(49);
        user1.setUsername("张夫业");
        user1.setUserSex("男");
        user1.setUserAddress("北京");
        user1.setUserBirthday(new Date( ));
        mapper.updateUserById(user1);
    }
    @Test
    public void testaddUser() throws IOException {
        User user1 = new User();

        user1.setUsername("张三");
        user1.setUserSex("女");
        user1.setUserAddress("上海");
        user1.setUserBirthday(new Date( ));
        mapper.addUser(user1);
    }

    @Test
    public void testdeleteUser() throws IOException {
        mapper.deleteUser(50);
    }
    @Test
    public void testfindOne() throws IOException {
        User user = mapper.findOne(41);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        System.out.println(user);
        UserDao mapper1 = factory.openSession().getMapper(UserDao.class);
        User user1 = mapper1.findOne(41);
        System.out.println(user1);
//        System.out.println(user==user1);
    }

    @Test
    public void testfindUserByName() throws IOException {
        List<User> users = mapper.findUserByName("王");
        for (User user : users) {
            System.out.println(user);
        }

    }
    @Test
    public void testfindTotalCount(){
        Integer totalCount = mapper.findTotalCount();
        System.out.println(totalCount);
    }
}
