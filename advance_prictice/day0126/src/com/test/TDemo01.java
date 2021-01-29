package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/26
 * @Description:java堆内存异常溢出异常测试
 */
public class TDemo01 {
    static class OOMObject{

    }
    public static void main(String[] args) {

        List<OOMObject> tDemo01List=new ArrayList<>();
        while (true) {
            tDemo01List.add(new OOMObject());
        }
    }
}
