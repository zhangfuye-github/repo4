package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

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

    /**
     *
     * 登录方法
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 添加用户信息
     * @param user
     */
    void addUser(User user);

    /**
     * 根据Id删除用户
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    User findById(String id);

    void updateUserById(User user);

    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param rows
     * @param currentPage
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String rows, String currentPage, Map<String, String[]> condition);
}
