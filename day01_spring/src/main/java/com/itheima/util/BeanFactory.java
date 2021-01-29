package com.itheima.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/11
 * @Description:
 */
public class BeanFactory {
    private static Properties props;
    private static Map<String,Object> beans;
    static {
        try {
            props=new Properties();
            beans=new HashMap<String, Object>();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beanfactory.properties");
            props.load(in);
            Enumeration<Object> keys = props.keys();
            while (keys.hasMoreElements()){
                String s = keys.nextElement().toString();
                String property = props.getProperty(s);
                try {
                    Object o = Class.forName(property).newInstance();
                    beans.put(s,o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static  Object getBean(String name){
        return beans.get(name);
    }
/*    public static Object getBean(String name){
        Object object=null;
        try {
            String property = props.getProperty(name);
            System.out.println(property);
            object = Class.forName(property).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }*/
}
