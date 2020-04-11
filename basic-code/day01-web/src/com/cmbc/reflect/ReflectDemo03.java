package com.cmbc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/5
 * @Description:
 */
public class ReflectDemo03 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        //这是通过反射获取构造方法创建类对象的方法
        Person person = constructor.newInstance("zhangfuye", 25);
        System.out.println(person);
        //可以直接通过Class对象，创建类实例
        Person person1 = personClass.newInstance();
        System.out.println(person1);


    }
}
