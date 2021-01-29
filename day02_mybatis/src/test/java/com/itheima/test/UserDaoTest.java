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
 * @Date: 2020/11/2
 * @Description:
 */
public class UserDaoTest {
    private UserDao mapper;
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
        mapper = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        //6.释放资源
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public  void test1() throws IOException {
        //5.执行方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    @Test
    public  void test2() throws IOException {

        User user1 = new User();
        user1.setUserName("张三");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user1.setUserBirthday(new Date());
        user1.setUserSex("男");
        user1.setUserAddress("河北");
        System.out.println(user1);
        mapper.saveUser(user1);
        System.out.println(user1);
    }
    @Test
    public  void testupdateUser() throws IOException {
        User user1 = new User();
        user1.setUserName("李四");
        user1.setUserId(54);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user1.setUserBirthday(new Date());
        user1.setUserSex("女");
        user1.setUserAddress("北京");
        mapper.updateUser(user1);
    }
    @Test
    public  void testdeleteUser() throws IOException {
        mapper.deleteUser(51);
    }
    @Test
    public  void testfindById() throws IOException {
        User user = mapper.findById(48);
        System.out.println(user);
    }
    @Test
    public  void testfindByAddress() throws IOException {
        List<User> users = mapper.findByAddress("%金燕龙%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public  void testfindTotalCount() throws IOException {
        int count = mapper.findTotalCount();
        System.out.println(count);
    }

}
