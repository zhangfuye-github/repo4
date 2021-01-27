package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/29
 * @Description:
 */
public class Test05 {
    public static void main(String[] args) {
        short s = 30;
        int i = 50;
        s += i;
        System.out.println("s="+s);//80
        int x = 0;
        int y = 0;
        int z = 0;
        boolean a,b;
        a = x>0 & y++>1;
        System.out.println("a="+a);//false
        System.out.println("y="+y);//1
        b = x>0 && z++>1;
        System.out.println("b="+b);//false
        System.out.println("z="+z);//0
        a = x>0 | y++>1;
        System.out.println("a="+a);//false
        System.out.println("y="+y);//2
        b = x>0 || z++>1;
        System.out.println("b="+b);//false
        System.out.println("z="+z);//1
    }
}
