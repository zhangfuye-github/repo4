package cn.itcast.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/24
 * @Description:
 */
//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo14 implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo4被执行了");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo4执行回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

}
