package com.cmbc.day11.demo02;

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("张三");
        s.method();//间接调用方式
        Student.Stu stu = s.new Stu();//直接调用方式
        stu.method();
        System.out.println(Student.Stu.class);//这是字节码文件名
    }
}
