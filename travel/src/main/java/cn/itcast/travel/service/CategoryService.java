package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/26
 * @Description:
 */
public interface CategoryService {

    public List<Category> findAll();
}
