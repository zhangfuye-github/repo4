package com.cmbc.test;

import com.cmbc.day01.JunitDemo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/2
 * @Description:
 */
public class JunitDemoTest {
    /*  1. 定义一个测试类(测试用例)
            * 建议：
                * 测试类名：被测试的类名Test		CalculatorTest
                * 包名：xxx.xxx.xx.test		cn.itcast.test
        2. 定义测试方法：可以独立运行
            * 建议：
                * 方法名：test测试的方法名		testAdd()
                * 返回值：void
                * 参数列表：空参
        3. 给方法加@Test
        4. 导入junit依赖环境*/
    JunitDemo junitDemo = new JunitDemo();
    @Before
    public void  methd(){
        System.out.println("before..........");
    }
    @After
    public void methoda(){
        System.out.println("after.............");
    }
    @Test
    public void testAdd(){
        int i = junitDemo.add();
        System.out.println(i);
    }
    @Test
    public void method(){
        int sum = junitDemo.sum();
        System.out.printf("%d\n", sum);
        System.out.println("testing.....................");
    }
}
