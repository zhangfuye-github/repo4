package com.cmbc.demo04;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Person[] arr={new Person("张三",18),
                new Person("李四",19),
                new Person("王五",14),
        };
/*          方法一：通过匿名内部类
            Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });*/
        //方法二：通过lambda表达式
        Arrays.sort(arr,(Person o1, Person o2)->{return o1.getAge()-o2.getAge();});
        for (Person p : arr) {
            System.out.println(p);
        }
    }
}
