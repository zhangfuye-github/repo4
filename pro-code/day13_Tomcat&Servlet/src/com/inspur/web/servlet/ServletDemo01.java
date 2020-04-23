package com.inspur.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/19
 * @Description:
 * 这是servlet的快速入门：
 *      1.首先我们需要创建一个Javaee的项目或者模块
 *      2.紧接着我们需要创建一个类实现servlet接口
 *      3.重写servlet里面的抽象方法
 *      4.配置web.xml
 *
 * servlet的原理：
 *      1.用户从客户端发起请求
 *      2.服务器收到客户端的请求
 *      3.会解析客户请求的内容，通过的配置文件找到对应的类的全路径名
 *      4.根据看到类的全路径名称，就要想到java反射，获取字节码文件，从而进行对象的创建
 *      5.反射有三种方式：
 *              1.Source源码阶段，未加载到内存当中， Class.forName("类的全路径名")
 * 		            * 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
 *              2.已经加载到内存当中， 类名.class 通过类名的属性class获取
 * 		            * 多用于参数的传递
 *              3.3.运行时阶段：可以通过 对象名.getClass(); getClass()方法在Object类中定义着。
 * 		            * 多用于对象的获取字节码的方式
 * 		 6.进而调用service方法
 *
 * 		 **以上过程有tomcat内部完成。
 */
public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet.....");
//        此处是servlet的主要方法，每访问一次，该service方法执行一次。
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
