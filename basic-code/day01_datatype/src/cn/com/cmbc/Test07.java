package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/29
 * @Description:
 */
public class Test07 {
    public static void main(String[] args) {
        int x = 1,y = 1;
        if(x++==1 | ++y==1)	{
            x =7;
        }
        System.out.println("x="+x+",y="+y);//7，2

        int a = 1,b = 1;

        if(a++==1 || ++b==1) {
            a =7;
        }
        System.out.println("a="+a+",b="+b);//7，1

        boolean c = true;

        if(c==false)
            System.out.println("a");
        else if(c)
            System.out.println("b"); //b
        else if(!c)
            System.out.println("c");
        else
            System.out.println("d");
    }
}
