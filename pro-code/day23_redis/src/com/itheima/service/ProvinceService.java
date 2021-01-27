package com.itheima.service;

import com.itheima.domain.Province;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/14
 * @Description:
 */
public interface ProvinceService {
    public abstract List<Province> findAll();

    /***
     *查询数据库中的省份，返回加入redis缓存技术
     * @return
     */
    public abstract String findAllProvince();
}
