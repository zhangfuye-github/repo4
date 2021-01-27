package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/21
 * @Description:
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        //1.获取表单提交的数据，有username，password，vcode
        //1.1思考问题，如何获取表单提交的数据从request域中获取数据
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        //1.2获取表单中的验证码
        String verifycode = request.getParameter("verifycode");
//        System.out.println("表单中的验证码"+verifycode);
        //1.3获取session中的验证码
        String checkcode_server = (String)(session.getAttribute("CHECKCODE_SERVER"));
        //1.4删除session中的验证码
        session.removeAttribute("verifycode");


        Map<String, String[]> parameterMap = request.getParameterMap();
        //创建一个user实体类
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String password = user.getPassword();
        String username = user.getUsername();

        //2.比较验证码，如果验证码不正确，提示错误信息，如果验证码正确，进行下一步的判断

        if(verifycode != null && verifycode.length() != 0){
            //不为空时，和session中的验证码进行比较
            if (checkcode_server.equalsIgnoreCase(verifycode)) {
                //判断用户名或者密码是否为空
                if((password != null && password.length() != 0)&&(username != null && username.length() != 0)){
                    //3.进行数据的查询，根据用户名和密码进行用户的查询，如果用户名密码正确怎么样，不正确怎么办
                    //用户名密码不为空时
                    UserService loginService = new UserServiceImpl();
                    User loginuser = loginService.login(user);
                    if (loginuser!=null) {
                        session.setAttribute("loginuser",loginuser);
                        response.sendRedirect(request.getContextPath()+"/index.jsp");
                        return;
                    }else{
                        request.setAttribute("login_msg","用户名或密码错误");
                        request.getRequestDispatcher("/login.jsp").forward(request,response);
                        return;
                    }
                }else{
                    //用户名或者密码不允许为空
                    request.setAttribute("login_msg","用户名或者密码不允许为空");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                    return;
                }
            }else{
                //请输入正确的验证码
                request.setAttribute("login_msg","验证码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }
        }else{
            //请输入验证码
            request.setAttribute("login_msg","请输入验证码,验证码不允许为空");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}