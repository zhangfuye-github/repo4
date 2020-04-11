package com.cmbc.annotation;

import java.lang.reflect.Method;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/6
 * @Description:
 */
@AnnoDemo01(className = "com.cmbc.annotation.Demo02", method = "show2")
public class AnnoTest {
    public static void main(String[] args) throws Exception{
        //首先获取当前类的字节码文件的注解部分。
        Class<AnnoTest> annoTestClass = AnnoTest.class;
        //得到注解接口的实现类对象
        AnnoDemo01 annotation = annoTestClass.getAnnotation(AnnoDemo01.class);
        //通过子类对象，获得该接口的属性
        String s = annotation.className();
        String method = annotation.method();
        /*System.out.println(s);
        System.out.println(method);*/
        //注解的大部分作用用来代替配置文件
        //通过反射获取要执行的哪个类中的哪个方法
        //首先获取要执行类的Class对象
        //然后获取要执行的成员方法
        //执行成员方法。
        Class<?> aClass = Class.forName(s);
        Method method1 = aClass.getMethod(method);
        Object o = aClass.newInstance();
        method1.invoke(o);
    }
}
