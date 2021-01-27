package com.itheima.web.servlet;

import com.itheima.service.ProvinceService;
import com.itheima.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/14
 * @Description:
 */
@WebServlet("/provincesServlet")
public class ProvincesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
//        ProvinceService provinceService=new ProvinceServiceImpl();
//        List<Province> provinces = provinceService.findAll();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(response.getWriter(),provinces);
        ProvinceService provinceService=new ProvinceServiceImpl();
        String province = provinceService.findAllProvince();
        response.getWriter().write(province);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
