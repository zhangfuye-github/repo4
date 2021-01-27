package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/27
 * @Description:
 */
@WebFilter("/testServlet")
public class SensitiveFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        final  HttpServletRequest req1 = (HttpServletRequest) req;
        ServletRequest proxy_req = (ServletRequest)Proxy.newProxyInstance(req1.getClass().getClassLoader(), req1.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("getParameter")){
                    String value= (String) method.invoke(req1,args);
                    if(value!=null){
                        if(value.contains("笨蛋")){
                            String s = value.replace("笨蛋", "***");
                            return s;
                        }else{
                            return value;
                        }
                    }else{
                        return value;
                    }

                }
                return method.invoke(req1,args);
            }
        });
        chain.doFilter(proxy_req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

}
