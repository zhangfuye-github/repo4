package com.ithaima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/30
 * @Description:
 */
public class Mybatiestest {
    public static void main(String[] args) throws IOException {
        //1.加载配置文件
        InputStream resource = Resources.getResourceAsStream("SqlMapconfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder sqlSessionBuilder=new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = sqlSessionBuilder.build(resource);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        //5.使用 SqlSession 创建 dao 接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //6.使用代理对象执行查询所有方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        //7.释放资源
        sqlSession.close();
        resource.close();
    }
}
