package com.cmbc.day11.demo02;
//定义成员内部类
public class Student {
    private String name;
    int num=10;
    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void method(){
        System.out.println("外部类成员方法");
        Stu s = new Stu();
        s.method();
    }
    public class Stu{
        int num=20;
        public void method(){
            int num=30;
            System.out.println("内部类方法执行");
            System.out.println("我的名字叫："+name);
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Student.this.num);
        }
    }
}
