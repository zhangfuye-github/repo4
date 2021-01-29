package com.itheima.test;

import com.itheima.dao.UserDao;
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
    public  void testfindAll() throws IOException {
        //5.执行方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
            System.out.println(user.getAccountList());
//            System.out.println(user.getRoleList());
        }

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

    /**
     * 测试条件查询
     * @throws IOException
     */
    @Test
    public  void testfindByConditions() throws IOException {
        User u=new User();
//        u.setUserName("张三");
        u.setUserSex("女");
        List<User> users = mapper.findByConditions(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 根据用户输入的ID进行集合查询
     * @throws IOException
     */
    @Test
    public  void testfindByIds() throws IOException {
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(45);
        ids.add(46);
        ids.add(48);
        ids.add(50);
        ids.add(52);
        QueryVO queryVO = new QueryVO();
        queryVO.setIds(ids);
        List<User> users = mapper.findByIds(queryVO);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
