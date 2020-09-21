package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/20
 * @Description:
 */
public interface UserService {

    /**
     * 查询所有的用户信息
     * @return
     */
    public List<User> findAll();
}
