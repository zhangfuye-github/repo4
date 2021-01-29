package com.test;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/21
 * @Description:
 */
public class TestDemo {
    public static void main(String[] args) {
        NoReturnMultiParam no=(int a,int b)->{
            System.out.println(a+b);
        };
        no.method(5,6);
        System.out.println();
        NoReturnNoParam noReturnNoParam=()->{
            System.out.println("无参无返回");
        };
        noReturnNoParam.method();
        System.out.println();
        ReturnMutilParam returnMutilParam=(String c,String d)->{return c+d;};
        String s = returnMutilParam.method("zhang", "li");
        System.out.println(s);
        System.out.println();
        OneParamNoReturn oneParamNoReturn=(a)->{
            System.out.println(a);
        };

        oneParamNoReturn.method(123);
        System.out.println();
        NoParamReturn noParamReturn=()->{return "无参有返回";};
        String s1 = noParamReturn.method();
        System.out.println(s1);

        System.out.println();
        OneParamOneReturn oneParamOneReturn=(a)->{return a;};
        int i = oneParamOneReturn.method(123);
        System.out.println(i);
    }
}
