package cn.itcast.web.servlet;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/23
 * @Description:
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码格式
        request.setCharacterEncoding("utf-8");
        //2.获取输入的参数rows和currentPage
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");
        if(rows==null || "".equals(rows)){
            rows="5";
        }
        if(currentPage==null || "".equals(currentPage)){
            currentPage="1";
        }
        //获取查询条件
        Map<String, String[]> condition = request.getParameterMap();
        //3.创建userservice对象，调用相应的finduserbypage();方法

        UserService userService = new UserServiceImpl();
        PageBean<User> pageBean = userService.findUserByPage(rows,currentPage,condition);
        //4.将list返回
//        System.out.println(pageBean);
//        System.out.println(condition);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("condition",condition);
        //5.转发到指定的页面
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
