package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/15
 * @Description:
 */
public interface UserDao {
    /**
     * 根据用户名判断用户是否存在
     * @param username
     * @return
     */
    User findByUser(String username);

    /**
     * 在用户列表中添加注册用户
     * @param user
     * @return
     */
    boolean saveUser(User user);

    /**
     * 根据激活码查询用户
     * @return
     * @param code
     */
    User findUserByCode(String code);

    void updateUser(String username, String status);

    User loginUser(String username, String password);

    User findByName(String user);
}
