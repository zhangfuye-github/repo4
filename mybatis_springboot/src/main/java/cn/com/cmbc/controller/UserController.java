package cn.com.cmbc.controller;

import cn.com.cmbc.dao.UserDao;
import cn.com.cmbc.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao u;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return u.findAll();
    }
}
