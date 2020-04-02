package com.cmbc.demo02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/30
 * @Description:
 */
public class DemoObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("7.txt"));
        ArrayList<Object> list = (ArrayList<Object>) ois.readObject();
        ois.close();
        for (Object o : list) {
            System.out.println(o);
        }

/*        Person o1 = (Person) o;
        System.out.println(o1);*/
    }
}
