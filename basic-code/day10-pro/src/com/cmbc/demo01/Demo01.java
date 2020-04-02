package com.cmbc.demo01;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/29
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("3.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("4.txt"));
        String s;
        while((s=br.readLine())!=null){
            String[] split = s.split("\\.");
            hashMap.put(split[0],split[1]);
        }
        Set<String> set = hashMap.keySet();
        String s3;
        for (String s1 : set) {
            String s2 = hashMap.get(s1);
            s3=s1+"\\."+s2;
            bw.write(s3);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
