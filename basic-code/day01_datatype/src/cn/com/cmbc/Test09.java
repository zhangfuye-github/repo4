package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/29
 * @Description:
 */
public class Test09 {
    public static void main(String[] args) {
        int x = 2,y=3;
        switch(x)
        {
            default:
                y++;
            case 3:
                y++;
                break;
            case 4:
                y++;
        }
        System.out.println("y="+y);//5此处考察的应该是case的贯穿
    }
}
