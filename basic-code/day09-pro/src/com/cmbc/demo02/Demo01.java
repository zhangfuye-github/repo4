package com.cmbc.demo02;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/29
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("张三","16");
        properties.setProperty("李四","10");
        properties.setProperty("王五","19");
        properties.setProperty("赵柳","17");
        properties.setProperty("赵柳","18");
/*        Set<String> set = properties.stringPropertyNames();
        for (String s : set) {
            System.out.println(s+"="+properties.getProperty(s));

        }*/
        FileWriter fw = new FileWriter("a.txt",true);
        properties.store(fw,"");
        fw.close();
        FileReader reader = new FileReader("a.txt");
        Properties properties1 = new Properties();
        properties1.load(reader);
        reader.close();
        Set<String> set1 = properties1.stringPropertyNames();
        for (String s : set1) {
            System.out.println(s+"="+properties.getProperty(s));

        }
    }
}
