package com.cmbc.reflectprictice;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/5
 * @Description:该类用来实现调用不同类的不同方法。
 */
public class Prictice {
    public static void main(String[] args) throws Exception {
        //可以通过配置文件存储相关信息，
        //加载配置文件
        //加载配置文件，第一步我们首先获取该对象
        Properties properties = new Properties();
        //File file = new File("D:\\workspace\\idea-git\\basic-code\\day01-web\\src\\pro.properties");
        //FileReader fileReader = new FileReader(file);
        //获取配置文件的信息。通过反射获取配置文件，这是以前不会的一个难点。
        ClassLoader classLoader = Prictice.class.getClassLoader();
        //记住，此处和加载的文件的后缀名没有关系
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //通过反射来调用方法
        Class<?> aClass = Class.forName(className);
        Method method = aClass.getMethod(methodName);
        Object o = aClass.newInstance();
        method.invoke(o);
    }
}
