package com.itheima.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/13
 * @Description:jedis的工具类，用于进行redis的java操作
 */
public class JedisUtils {
    static JedisPool jedisPool;
    static {
        //加载配置文件(反射)
        JedisPoolConfig config= new JedisPoolConfig();
        InputStream rs = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(rs);
//            host= pro.getProperty("host");
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
        jedisPool = new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));

    }
    public static Jedis getJedis(){
        Jedis resource= jedisPool.getResource();
        return resource;
    }
}
