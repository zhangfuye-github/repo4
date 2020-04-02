package com.cmbc.day13.demo01;

import java.util.stream.Stream;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/1
 * @Description:
 */
public class StreamLimit {
    public static void main(String[] args) {
        String[] arr={"张三丰","张无忌","张翠山","周芷若","赵敏","阿里"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> limit = stream.limit(3);
        limit.forEach(s -> System.out.println(s));
    }
}
