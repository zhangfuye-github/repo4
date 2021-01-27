package com.itheima.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.ProvinceDao;
import com.itheima.dao.impl.ProvinceDaoImpl;
import com.itheima.domain.Province;
import com.itheima.service.ProvinceService;
import com.itheima.util.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/14
 * @Description:
 */
public class ProvinceServiceImpl implements ProvinceService {
     ProvinceDao provinceDao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    /***
     * 查询数据库中的省份，返回加入redis缓存技术
     * @return
     */
    @Override
    public String findAllProvince() {
        Jedis jedis = JedisUtils.getJedis();
        String provinces = jedis.get("provinces");
        if(provinces==null || provinces.length()==0){
            System.out.println("redis中不存在数据，查询数据库..........");
            List<Province> list = provinceDao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            String s=null;
            try {
                s= mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("provinces", s);
            jedis.close();
        }else{
            System.out.println("redis中存在数据，查询redis");
        }
        provinces = jedis.get("provinces");
        System.out.println(provinces);
        return provinces;
    }
}
