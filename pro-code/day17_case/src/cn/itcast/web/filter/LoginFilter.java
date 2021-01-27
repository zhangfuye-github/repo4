package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/25
 * @Description:登录验证过滤器，用户访问资源时，判断用户是否已经登录
 */
@WebFilter("/*")
public class LoginFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//
        //首先从域中获取用户信息
        //1.第一步，我们需要做的是强制类型转换
        HttpServletRequest request= (HttpServletRequest) req;
        //2.从request中获取登录用户
        Object loginuser = request.getSession().getAttribute("loginuser");
        //3.判断loginuser是否为空
        if(loginuser!=null){
            chain.doFilter(req, resp);
        }else{
            //<看用户访问的资源是否是登录相关的页面，如果是，放行，否则跳转至登录页面
            String requestURI = request.getRequestURI();
            if(requestURI.contains("/login.jsp")||requestURI.contains("/loginServlet")||requestURI.contains("/css/")||requestURI.contains("/fonts/")||requestURI.contains("/js/")||requestURI.contains("/checkCodeServlet")){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("login_msg","您尚未登录，请您登录！！！");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);

            }
        }
    }
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

}
