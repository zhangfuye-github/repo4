package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/29
 * @Description:
 */
public class Test06 {
    public static void main(String[] args) {
        int x = 1,y = 1;
        if(x++==2 & ++y==2)	{
            x =7;
        }
        System.out.println("x="+x+",y="+y); //2，2

        int a = 1,b = 1;

        if(a++==2 && ++b==2) {
            a =7;
        }
        System.out.println("a="+a+",b="+b); //2，1
    }
}
