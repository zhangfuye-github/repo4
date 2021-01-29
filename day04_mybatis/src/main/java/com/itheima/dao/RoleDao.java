package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/4
 * @Description:
 */
public interface RoleDao {
    /**
     * 角色查询所有
     * @return
     */
    List<Role> findAll();

}
