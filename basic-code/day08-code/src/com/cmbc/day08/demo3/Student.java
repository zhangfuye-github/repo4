package com.cmbc.day08.demo3;

public class Student {
    private String name;
    private int age;
    static String cla;
    private  int id;
    private static int num=0;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id=++num;
    }

    public Student() {
        this.id=++num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }
}
