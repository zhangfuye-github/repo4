package cn.com.cmbc.test;

import cn.com.cmbc.SpringdatajpaSpringbootApplication;
import cn.com.cmbc.domain.User;
import cn.com.cmbc.repository.UserRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = cn.com.cmbc.SpringdatajpaSpringbootApplication.class )
public class JpaTest {
    @Autowired
    private UserRespository userRespository;
    @Test
    public void test(){
        List<User> all = userRespository.findAll();
        System.out.println(all);
    }
}
