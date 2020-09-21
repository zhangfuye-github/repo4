package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/20
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用userdao
        return userDao.findAll();
    }
}
