package com.cmbc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/5
 * @Description:
 */
public class ReflectDemo04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.cmbc.reflect.Person");
/*        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/
        Method eating = aClass.getMethod("eating", String.class);
        Object o = aClass.newInstance();
        eating.invoke(o, "食物");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
