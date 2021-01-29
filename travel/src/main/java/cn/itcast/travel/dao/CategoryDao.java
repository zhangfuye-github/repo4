package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/26
 * @Description:category用于连接查询数据库的接口
 */
public interface CategoryDao {

    /**
     * 用于查询所有
     * @return
     */
    public List<Category> findAll();
}
