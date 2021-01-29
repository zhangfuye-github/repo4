package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/26
 * @Description:
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService service = new UserServiceImpl();
    /**
     * 用户注册的方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.首先从获取表单的验证码
        String check = request.getParameter("check");
        //2.从session中获取存储的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //3.移除验证码
        session.removeAttribute("CHECKCODE_SERVER");
        //4.进行验证码的比对
        ResultInfo resultInfo = new ResultInfo();
        if (!check.equalsIgnoreCase(checkcode_server)) {
            //如果验证码，不正确，返回结果，验证码不正确的提示
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码不正确,请输入正确的验证码");
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return;
        }
        //验证码正确的话，进行用户注册
        //首先获取用户传递过来的参数

        Map<String, String[]> map = request.getParameterMap();
        //进行用户参数的封装通过使用一个类
        User user = new User();
        try {
            BeanUtils.populate(user, map);//通过使用工具类，将数据封装到user对象当中
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //调用service层注册用户的方法
////        UserService service = new UserServiceImpl();
        boolean b = service.registUser(user);
        //根据返回的结果进行，参数的判断
        if (b) {
            //true表示注册成功
            resultInfo.setFlag(true);
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return;
        } else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("该用户已被注册，请重新填写用户名");
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return;
        }
    }

    /**
     * 用户登录方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先验证码
        //1.首先从获取表单的验证码
        String check = request.getParameter("check");
        //2.从session中获取存储的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //3.移除验证码
        session.removeAttribute("CHECKCODE_SERVER");
        //4.进行验证码的比对
        ResultInfo resultInfo = new ResultInfo();
        if (!check.equalsIgnoreCase(checkcode_server)) {
            //如果验证码，不正确，返回结果，验证码不正确的提示
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码不正确,请输入正确的验证码");
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return;
        }
        //验证码校验通过之后
        //根据用户名和密码查询用户
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        UserService service = new UserServiceImpl();
        User user = service.loginUser(username, password);
        if (user != null) {
            String status = user.getStatus();
            if ("N".equals(status)) {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("用户尚未激活，请先激活");
                ObjectMapper mapper = new ObjectMapper();
                String s = mapper.writeValueAsString(resultInfo);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(s);
                return;
            }
            session.setAttribute("user", user.getName());
            resultInfo.setFlag(true);
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return;
        }
        resultInfo.setFlag(false);
        resultInfo.setErrorMsg("用户名或密码错误");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(resultInfo);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
        return;
    }

    /**
     * 用户激活方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.首先获取激活码
        String code = request.getParameter("code");
        //2.获取激活码之后，调用激活方法
        boolean b = service.activeUser(code);
        if (b) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("激活成功，请<a href='login.html'>登录</a>");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("激活失败");
        }
    }
    /**
     * 查询单个用户是否登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        System.out.println(user);
        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(user);
        ResultInfo resultInfo = new ResultInfo();
        response.setContentType("application/json;charset=utf-8");
        resultInfo.setData(user);
        mapper.writeValue(response.getWriter(),resultInfo);
        return;
    }
    /**
     * 退出方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
//        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
}