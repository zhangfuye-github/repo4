package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/15
 * @Description:
 */
public interface UserService {
    /**
     * 用来注册用户
     * @param user
     * @return
     */
    public abstract boolean registUser(User user);

    boolean activeUser(String code);

    User loginUser(String username, String password);

    User findByName(String user);
}
