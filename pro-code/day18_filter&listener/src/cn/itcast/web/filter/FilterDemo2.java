package cn.itcast.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/24
 * @Description:
 */
//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter方法被执行了");
        chain.doFilter(req, resp);
        System.out.println("doFilter方法被执行回来了");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter init()方法被执行了");
    }

    public void destroy() {

        System.out.println("filter destroy()方法被执行了");

    }

}
