package com.cmbc.demo;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/6
 * @Description:用来自定义一个工具，用来测试成员方法。
 */
public class CheckDemo {
    public static void main(String[] args) throws IOException {
        //创建输出流
        FileWriter fileWriter = new FileWriter("bug.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //1.首先需要要获取的执行类的对象
        Calculator calculator = new Calculator();
        //2.通过对象获取要测试类的Class对象，
        Class<? extends Calculator> aClass = calculator.getClass();
        //3.获取Class对象当中要测试的成员方法
        Method[] methods = aClass.getMethods();
        //4.对方法进行执行
        int num = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(calculator);
                } catch (Exception e) {
                    num++;
//                   bufferedWriter.write(e.getMessage());
                    bufferedWriter.write(""+e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write(e.getClass().getName());
                    bufferedWriter.newLine();
//                    bufferedWriter.write("异常的名称:" + e.getCause().getClass().getSimpleName());
//                    bufferedWriter.newLine();
//                    bufferedWriter.write("异常的原因:"+e.getCause().getMessage());
//                    bufferedWriter.newLine();
                    bufferedWriter.write("------------------------------------");
                    bufferedWriter.newLine();
                }
            }
        }
        //5.捕获异常，将异常输出到bug.txt日志文本文件当中。
        bufferedWriter.write("总共出现" + num + "次异常");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
