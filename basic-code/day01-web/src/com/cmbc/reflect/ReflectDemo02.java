package com.cmbc.reflect;

import java.lang.reflect.Field;
import java.util.function.DoubleToIntFunction;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/5
 * @Description:
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();//该方法只能获取所有的public修饰的成员变量
        for (Field field : fields) {
            System.out.println(field);
        }
        //如何对反射得到成员变量进行赋值操作，get，set方法
        Field a = personClass.getField("a");
        Person person = new Person();
        Object o = a.get(person);

        System.out.println(o);
        a.set(person,"张夫业");
        System.out.println(a.get(person));
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field name = personClass.getDeclaredField("name");
        //不能直接给加锁的成员变量直接赋值，要想赋值的话，需要完成，暴力反射
        if (!name.isAccessible()) {
            name.setAccessible(true);
        }
        name.set(person,"zfy");
        System.out.println(person);
    }
}
