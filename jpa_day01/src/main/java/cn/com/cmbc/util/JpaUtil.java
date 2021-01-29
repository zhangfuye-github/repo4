package cn.com.cmbc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/15
 * @Description:
 */
public class JpaUtil {
    private static final EntityManagerFactory myJpa;

    static {
        myJpa = Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager createEntityManager(){
        return myJpa.createEntityManager();
    }
}
