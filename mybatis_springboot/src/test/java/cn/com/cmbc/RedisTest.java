package cn.com.cmbc;

import cn.com.cmbc.dao.UserDao;
import cn.com.cmbc.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/26
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisSpringbootApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserDao userDao;
    @Test
    public void test() throws JsonProcessingException {
        String user1 = redisTemplate.boundValueOps("user").get();
        if (null==user1) {
            List<User> all = userDao.findAll();
            ObjectMapper mapper=new ObjectMapper();
            user1 = mapper.writeValueAsString(all);
            redisTemplate.boundValueOps("user").set(user1);
            System.out.println("========从数据库查询==========");
        }else{
            System.out.println("========从redis查询==========");
        }
        System.out.println(user1);

    }
}
