package com.cmbc.day11.demo03;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class InnerClass {
    public InnerClass() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InnerClass(String name) {
        this.name = name;
    }
    public void method(){
        final int num1=123;
        class Student{//注意事项：局部内部类不能有修饰符
            int num;
            public void methodInner(){
                System.out.println("局部内部类的成员方法");
                System.out.println(num);
                System.out.println(num1);
            }
        }
        new Student().methodInner();
    }
}
