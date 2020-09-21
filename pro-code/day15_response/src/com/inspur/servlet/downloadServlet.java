package com.inspur.servlet;

import com.inspur.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/23
 * @Description:
 */
@WebServlet("/download")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("123456");
        //2.使用字节输入流加载文件进内存
        String filename = request.getParameter("filename");
        //2.1找到文件服务器路径
        ServletContext servletContext = request.getServletContext();
        //注意此处用到的是绝对路径
        //客户端请求的时候用绝对路径
        //默认情况是虚拟目录下。
        //找到资源路径
        String realPath = servletContext.getRealPath("/img/"+filename);
        System.out.println(realPath);
        FileInputStream stream = new FileInputStream(realPath);
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式:content-disposition
        //解决中文文件名问题
        //1.获取user-agent请求头、
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可，用来解决名称问题
        filename = DownLoadUtils.getFileName(agent, filename);
        //表示以附件的形式输出
        response.setHeader("Content-Disposition", "attachment;filename="+filename);
       //输出文件
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b=new byte[1024];
        int len;
        while (((len = stream.read(b)) != -1)) {
            outputStream.write(b,0,len);
        }
        stream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
