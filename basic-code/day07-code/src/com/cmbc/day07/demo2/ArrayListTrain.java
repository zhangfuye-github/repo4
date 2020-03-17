package com.cmbc.day07.demo2;

import java.util.ArrayList;

/*
本案例主要练习arraylist，ArrayList和array的区别是ArrayList的长度可变，相当于go中
slice和array的区别。
注意：ArrayList<E>这是集合的ArrayList的类型，其中E是泛型，java中泛型必须是引用类型，
因此这就涉及到jdk1.5 之后的拆箱和装箱。
jdk1.7及以后版本中，ArrayList<>();新建对象时，右侧的泛型可以省略。
注意求数组长度length属性，字符串长度length()成员方法，以及集合长度size()成员方法的方法。
 */
public class ArrayListTrain {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        Person person1 = new Person("张天爱", 28);
        Person person2 = new Person("岳不群", 20);
        Person person3 = new Person("张一山", 29);
        Person person4 = new Person("迪丽热巴", 27);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        arrayListTrain(list);
        System.out.println(list);
        String s ="张夫业";
        System.out.println(s.length());
    }

    private static void arrayListTrain(ArrayList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("姓名："+list.get(i).getName()+"年龄："+list.get(i).getAge());
        }
    }

}
