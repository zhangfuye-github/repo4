package cn.com.cmbc;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/22
 * @Description:
 */
public class Demo03 {
    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();
        Iterator<String> iterator = getenv.keySet().iterator();
        while (iterator.hasNext()) {
            getenv.get(iterator.next());
        }
        String properties = System.getProperty("java.runtime.name");
        System.out.println(properties);
    }
}
