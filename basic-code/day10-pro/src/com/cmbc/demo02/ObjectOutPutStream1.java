package com.cmbc.demo02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/30
 * @Description:
 */
public class ObjectOutPutStream1 {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> list=new ArrayList<>();

        Person person = new Person("张三",15);
        Person person1 = new Person("李四",18);
        Person person2 = new Person("王五",19);
        Person person3 = new Person("赵柳",70);
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);

        FileOutputStream fos = new FileOutputStream("7.txt");
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(list);
        ous.close();
    }
}
