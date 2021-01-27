package cn.itcast.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/24
 * @Description:
 */
public class FilterDemo1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器被执行了");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
