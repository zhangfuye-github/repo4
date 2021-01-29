package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/26
 * @Description:
 */
public class CategoryServiceImpl implements CategoryService {
    CategoryDao dao=new CategoryDaoImpl();
    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Category> findAll() {
        //1.首先从缓存中取数据，如果有数据，则返回，不存在则在数据库中进行查询
        Jedis jedis = JedisUtil.getJedis();
        //2.查询redis
        Set<Tuple> categorys = jedis.zrangeWithScores("categorys", 0, -1);
        List<Category> cs=null;
        if(categorys == null || categorys.size() == 0){
            //查询数据库
//            System.out.println("数据库查询。。。");
            cs = dao.findAll();
            //将查询结果存储到redis
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("categorys",cs.get(i).getCid(),cs.get(i).getCname());
            }
        }else{
//            System.out.println("redis查询。。。。");
            cs = new ArrayList<>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCid((int) tuple.getScore());
//                System.out.println((int) tuple.getScore());

                category.setCname(tuple.getElement());
//                System.out.println(tuple.getElement());

//                category.setCname(name);
                cs.add(category);
            }

        }
        return cs;
    }
}
