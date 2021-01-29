package cn.com.cmbc.controller;

import cn.com.cmbc.domain.Account;
import cn.com.cmbc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/20
 * @Description:参数的绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 参数绑定
     * @return
     */
    @RequestMapping("param")
    public String testParam(String username,String password){
        System.out.println("username"+username);
        System.out.println("password"+password);
        return "success";
    }

    /**
     * 把参数封装到实体类中
     * @param account
     * @return
     */
    @RequestMapping("parambean")
    public String testParambean(Account account){
        System.out.println("用户名:"+account.getUsername());
        System.out.println("账户:"+account.getAccount());
        System.out.println("金额:"+account.getMoney());
        System.out.println(account);
        return "success";
    }
    @RequestMapping("saveuser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }
}
