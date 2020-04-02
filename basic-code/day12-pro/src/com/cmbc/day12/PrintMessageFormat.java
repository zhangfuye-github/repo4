package com.cmbc.day12;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:练习：格式化打印信息
 * 题目
 * 下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。”的格式将信息打印出来。要求将打印姓
 * 名的动作作为第一个Consumer 接口的Lambda实例，将打印性别的动作作为第二个Consumer 接口的Lambda实
 * 例，将两个Consumer 接口按照顺序“拼接”到一起。
 * public static void main(String[] args) {
 * String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
 * }
 */
public class PrintMessageFormat {
    public static void method(String[] array, Consumer<String> Consum,Consumer<String> Consum1){
        for (String s : array) {
/*             Consum.accept(s);
             Consum1.accept(s);*/
            Consum.andThen(Consum1).accept(s);
        }
    }
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        method(array,(s)->{
            String[] split = s.split(",");
            String s1 = "姓名：" + split[0];
            System.out.print(s1);
        },(s)->{
            String[] split = s.split(",");
            String s2 = "年龄：" + split[1];
            System.out.println(s2);
        });
    }
}
