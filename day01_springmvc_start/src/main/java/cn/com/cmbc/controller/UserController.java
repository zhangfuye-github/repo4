package cn.com.cmbc.controller;

import cn.com.cmbc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/20
 * @Description:
 */
@Controller
@RequestMapping("users")
public class UserController {
    @RequestMapping("testRequestParam")
    public String testRequestParam(User user){
        System.out.println("user.jsp执行了.....");
        System.out.println(user);
        return "success";
    }
}
