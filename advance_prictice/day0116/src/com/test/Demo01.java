package com.test;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/16
 * @Description:以后所有练习的代码都放到这里
 * 1.jdk10,新特性可以使用var，不用声明类型
 */
public class Demo01 {
    public static void main(String[] args) {
//        var a="false";
        var person=new Person();
        person.setAge(18);
        person.setName("zhangsna");
        person.setSex("男");
        System.out.println(person.getClass());
    }
}
