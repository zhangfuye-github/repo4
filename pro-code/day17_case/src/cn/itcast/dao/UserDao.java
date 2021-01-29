package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/20
 * @Description:<用户操作的dao
 */
public interface UserDao {
    public List<User> findAll();

    User findByUsernameAndPassword(String username, String password);

    /**
     * 添加用户信息
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户id删除用户
     * @param id
     */
    void deleteById(int id);

    /**
     * 根据用户Id查询用户信息
     * @param id
     * @return
     */
    User findById(int id);

    void updateUserById(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findUserByPage(int intRows, int intCurPage, Map<String, String[]> condition);
}
