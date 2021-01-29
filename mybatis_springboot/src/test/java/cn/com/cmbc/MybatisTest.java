package cn.com.cmbc;

import cn.com.cmbc.dao.UserDao;
import cn.com.cmbc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisSpringbootApplication.class)
public class MybatisTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void testFindAll(){
        List<User> all = userDao.findAll();
        System.out.println(all);
    }
}
