package com.inspur.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/19
 * @Description:soup快速入门
 */
public class XmlDemo {
    public static void main(String[] args) throws IOException {
//        System.out.println("你好！xml！！");
//        1.导入jar包
//        2.add as libraries
//        3.jsoup中有一个静态方法，用来加载配置文件
//        4.可以通过类加载器的方式获取要解析的xml的路径
        String path = XmlDemo.class.getClassLoader().getResource("student.xml").getPath();
//        System.out.println(path);
//       加载配置文件，首先要知道要加载的配置文件的名称和位置
//       然后获取文档对象，然后根据文档标签获取内容
//        Document document = Jsoup.parse(new File(path), "utf-8");
        Document document = Jsoup.parse(new File("1_xml/src/student.xml"), "utf-8");
//        Document document = Jsoup.parse(new File("D:/workspace/idea-git/pro-code/out/production/1_xml/student.xml"), "utf-8");
        System.out.println(document);
        Elements name = document.getElementsByTag("name");
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i).text());
        }
    }

}
