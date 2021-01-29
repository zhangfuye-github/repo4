package cn.com.cmbc;

import cn.com.cmbc.domain.Accout;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/2
 * @Description:
 */
@Controller
@RequestMapping("test")
public class Demo01 {
    @RequestMapping("hello")
    public String hello(){
        System.out.println("你好，世界");
        return "success";
    }
    @RequestMapping(path = "param")
    public String parambanding(Accout accout){
        System.out.println(accout);
        return "success";
    }

}
