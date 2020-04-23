package com.inspur.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/19
 * @Description:
 * servlet的生命周期
 *      1.出生：被创建：在servlet第一次被访问的时候会被创建，只会创建一次
 *             1.默认情况下是在第一次被访问的时候进行执行
 *                  可以在配置文件<servlet>标签中通过<load-on-server>方法进行设置servlet被创建的时机
 *             2.该方法只会执行一次，说明该servlet是单例的。单例的要想到数据安全问题，数据共享
 *                  想到数据安全，我们的第一反映就是加锁，数据库中是事务，但是servlet加锁的话，太影响性能
 *                  因此我们解决方法，我们可以通过在service方法中定义局部变量，来进行问题的解决。
 *      2.运行阶段：每访问一次，进行执行一次
 *      3.销毁阶段，会在服务器正常关闭的时候进行销毁
 *          会在servlet方法被销毁之前执行的story方法。
 */
public class ServletDemo02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init........");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service........");
        //通过指定字符集，用来控制代码的编码方式。先编码，浏览器在进行节码
        servletResponse.setCharacterEncoding("GBK");
        servletResponse.getWriter().write("张夫业");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy........");
    }
}
