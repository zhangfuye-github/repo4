import cn.com.cmbc.domain.Customer;
import cn.com.cmbc.util.JpaUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/15
 * @Description:
 */
public class TestDemo2 {
    @Test
    public void test(){
        EntityManager entityManager = JpaUtil.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer();
        customer.setCustName("zhangsan");
        entityManager.persist(customer);
        transaction.commit();
        entityManager.close();
    }
    @Test
    public void testFind(){
        EntityManager manager = JpaUtil.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Customer customer = manager.find(Customer.class, 1L);
        System.out.println(customer);
        transaction.commit();
        manager.close();

    }
    //使用jpql进行复杂查询
    @Test
    public void testFindAll(){
        EntityManager manager = JpaUtil.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        String jpql = "from Customer";
        Query query = manager.createQuery(jpql);
        List resultList = query.getResultList();
        for (int i = resultList.size(); i >0 ; i--) {
            System.out.println(resultList.get(i-1));
        }
        transaction.commit();
        manager.close();

    }
    @Test
    public void testFindAllOrder(){
        EntityManager manager = JpaUtil.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        String jpql = "from Customer order by custId desc";
        Query query = manager.createQuery(jpql);
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }
        transaction.commit();
        manager.close();

    }
    @Test
    public void testCountAll(){
        EntityManager manager = JpaUtil.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        String jpql = "select count(custId) from Customer where custName = ?";
        Query query = manager.createQuery(jpql);
        query.setParameter(1,"传智播客");
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);
        transaction.commit();
        manager.close();

    }
}
