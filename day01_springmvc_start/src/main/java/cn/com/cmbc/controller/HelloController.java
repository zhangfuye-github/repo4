package cn.com.cmbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/19
 * @Description:控制器的类
 */
@Controller
@RequestMapping("user")
public class HelloController {
    //该类用来控制请求
    @RequestMapping(path = "hello")
    public String sayHello(){
        System.out.println("hello,springmvc");
        return "success";
    }
    @RequestMapping(path = "testRequestMapping")
    public String testRequestMapping(){
        System.out.println("hello,testRequestMapping");
        return "success";
    }
}
