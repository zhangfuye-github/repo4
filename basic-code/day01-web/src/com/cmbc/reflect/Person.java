package com.cmbc.reflect;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/5
 * @Description:
 */
public class Person {
    private String  name;
    private int age;
    public  String a;
    protected String  b;
    String  c;
    private String d;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
    public void eat(){
        System.out.println("Eating...");
    }
    public void eating(){
        System.out.println("eating");
    }
}
