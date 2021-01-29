package com.test1;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/21
 * @Description:
 */
public interface NewCharacter {
    public void test1();
    public default void test2(){
        System.out.println("jdk1.8接口可以有实现的方法。。。");
    }
}
