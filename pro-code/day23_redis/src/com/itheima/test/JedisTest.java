package com.itheima.test;

import com.itheima.util.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/13
 * @Description:
 */
public class JedisTest {
    @Test
    public void test(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.执行语句
        jedis.set("u_name","张");
        //关闭资源
        jedis.close();
    }
    @Test
    public void test1(){
        //0.配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(20);
        //1.获取链接池
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //2.获取链接
        Jedis jedis = jedisPool.getResource();
        //3.执行语句
        jedis.set("u_name","456");
        //4.关闭资源
        jedis.close();
    }
    @Test
    public void test2(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("u_name","1329409");
        jedis.close();
    }
    @Test
    public void test3(){
        Jedis jedis = JedisUtils.getJedis();
        System.out.println(jedis.get("u_name"));
        jedis.close();
    }
}
