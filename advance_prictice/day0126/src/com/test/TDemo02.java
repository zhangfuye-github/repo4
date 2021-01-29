package com.test;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/26
 * @Description:虚拟机栈和本地方法栈内存溢出
 */
public class TDemo02 {
    private int count =1;
    public void add(){
        count++;
        add();
    }
    public static void main(String[] args) {
        TDemo02 tDemo02=new TDemo02();
        try{
            tDemo02.add();
        }catch (Throwable e){
            System.out.println(tDemo02.count);
            e.printStackTrace();
        }

    }
}
