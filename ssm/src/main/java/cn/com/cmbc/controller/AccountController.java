package cn.com.cmbc.controller;

import cn.com.cmbc.domain.Account;
import cn.com.cmbc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/23
 * @Description:
 */
@Controller
@RequestMapping("user")
public class AccountController {
    //DI属性注入........
    @Autowired
    private AccountService as;
    /**
     * 表现层查询所有账户的方法
     * @return
     */
    @RequestMapping("testFindAll")
    public String findAll(Model model){
        System.out.println("表现层findAll方法执行了......");
        List<Account> all = as.findAll();
        model.addAttribute("list",all);
        return "list";
    }

    @RequestMapping("saveAccount")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层saveAccount方法执行了......");
        as.saveUser(account);
        response.sendRedirect(request.getContextPath()+"testFindAll");
        return ;
    }
}
