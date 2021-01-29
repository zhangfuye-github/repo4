package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/27
 * @Description:
 */
@WebServlet("/page/*")
public class PageServlet extends BaseServlet {
    RouteService routeservice=new RouteServiceImpl();
    UserService service=new UserServiceImpl();
    public void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分页查询的方法
        //1.首先接收用户传递的参数，当前页码数和每页显示的条数
        String cidStr = request.getParameter("cid");
        String rnameStr = request.getParameter("rname");
        String currentpageStr = request.getParameter("currentpage");
        String pagesizeStr = request.getParameter("pagesize");

        if(rnameStr!=null && rnameStr.length()>0 && !"null".equals(rnameStr)){
            byte[] bytes = rnameStr.getBytes("ISO8859-1");
            //再使用UTF-8进行编码
            rnameStr = new String(bytes,"UTF-8");
        }
        //2.对参数进行处理
        int currentpage=0;
        if(currentpageStr==null || currentpageStr.length()==0){
            currentpage=1;
        }else{
            currentpage=Integer.parseInt(currentpageStr);
        }
        int pagesize=0;
        if(pagesizeStr==null || pagesizeStr.length()==0){
            pagesize=5;
        }else{
            pagesize=Integer.parseInt(pagesizeStr);
        }
        int cid=0;
        if(cidStr!=null && cidStr.length()>0 && !"null".equals(cidStr)){
            cid=Integer.parseInt(cidStr);
        }

        //3.调用service的查询方法
        PageBean<Route> pageBean=routeservice.routePageQuery(cid,currentpage,pagesize,rnameStr);
        //4.将封装好的PageBean返回到前端
        writeValue(pageBean,response);
    }
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.首先获取该商品详情的唯一ID，rid
        String ridStr = request.getParameter("rid");
        int rid=0;
        if(ridStr!=null&&ridStr.length()>0){
            rid=Integer.parseInt(ridStr);
        }
        //调用service方法
        Route route=routeservice.findOne(rid);
        //3.将结果返回
        writeValue(route,response);
    }
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先获取当前路线的rid和用户id
        String rid = request.getParameter("rid");

        //2.从session中获取用户数据
        String user = (String) request.getSession().getAttribute("user");
        //3.对获取到的用户进行判空
        int uid;
        if(user==null){
            uid=0;
        }else{
            User user1=service.findByName(user);
            uid=user1.getUid();
        }
        //4.调用方法service层的方法
        boolean flag=routeservice.isFavorite(rid,uid);
//        System.out.println(uid);
//        System.out.println(flag);
        //5.将结果返回到客户端
        writeValue(flag,response);
    }
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先获取当前路线的rid和用户id
        String rid = request.getParameter("rid");
        //2.从session中获取用户数据
        String user = (String) request.getSession().getAttribute("user");
//        System.out.println(user);
        //3.对获取到的用户进行判空
        int uid;
        if(user==null){
            uid=0;
        }else{
            User user1=service.findByName(user);
            uid=user1.getUid();
            System.out.println(user);
            System.out.println(uid);
        }
        routeservice.addFavorite(rid,uid);
    }
}
