package com.inspur.demo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/19
 * @Description:
 */
public class DemoDOM4j {
    public static void main(String[] args) throws Exception {
        //创建SAXReader对象
        SAXReader sr = new SAXReader();
        //加载xml 获取Document对象
        Document doc = sr.read("1_xml/src/student.xml");
        System.out.println(doc);
        //获取根元素
        Element root = doc.getRootElement();
        //获取根元素的子元素  bean
        List<Element> list = root.elements();
        //遍历集合 依次获取每个子元素  bean元素
        for(Element bean : list){
            //获取bean元素的属性值
            String id = bean.attributeValue("number");
            System.out.println(id + "..");
            //获取所有bean元素子元素
            List<Element> propertyList = bean.elements();
            //遍历集合 依次获取每个property元素
            for(Element property:propertyList){
                //获取property元素的属性
                String itcast = property.attributeValue("id");
                if("itcast".equals(itcast)){
                    System.out.println(itcast+"..");
                    List<Element> elements = property.elements();
//                    System.out.println(property.getText());
                    for (Element element : elements) {
                        String name = element.getName();
                        String text = element.getText();
                        System.out.println(name+".."+text);
                    }
                }else{
                    String name = property.getName();
                    String text = property.getText();
//                Element xing = property.element("xing");
                    System.out.println(name+".."+text);
                }

            }
        }
    }
}
