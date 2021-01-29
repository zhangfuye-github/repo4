package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/17
 * @Description:
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先验证码
        //1.首先从获取表单的验证码
        String check = request.getParameter("check");
        //2.从session中获取存储的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        //3.移除验证码
        session.removeAttribute("CHECKCODE_SERVER");
        //4.进行验证码的比对
        ResultInfo resultInfo=new ResultInfo();
        if(!check.equalsIgnoreCase(checkcode_server)){
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
        UserService service=new UserServiceImpl();
        User user=service.loginUser(username,password);
        if(user!=null){
            String status = user.getStatus();
            if("N".equals(status)){
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("用户尚未激活，请先激活");
                ObjectMapper mapper = new ObjectMapper();
                String s = mapper.writeValueAsString(resultInfo);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(s);
                return;
            }
            session.setAttribute("user",user.getName());
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
