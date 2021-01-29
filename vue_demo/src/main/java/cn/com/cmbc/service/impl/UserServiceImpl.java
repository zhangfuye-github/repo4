package cn.com.cmbc.service.impl;

import cn.com.cmbc.dao.UserDao;
import cn.com.cmbc.domain.User;
import cn.com.cmbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:操作用户表的业务逻辑层实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
