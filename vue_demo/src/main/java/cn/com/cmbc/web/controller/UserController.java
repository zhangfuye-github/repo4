package cn.com.cmbc.web.controller;

import cn.com.cmbc.domain.User;
import cn.com.cmbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public List<User> findAll() {
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        return all;
    }
    @RequestMapping("/findById.do")
    public User findById(Integer id) {
        return userService.findById(id);
    }
    @RequestMapping("/updateUser.do")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
