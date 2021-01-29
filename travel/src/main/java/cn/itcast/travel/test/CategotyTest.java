package cn.itcast.travel.test;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/26
 * @Description:
 */
public class CategotyTest {

    @Test
    public void test1(){
        CategoryDao category=new CategoryDaoImpl();
        List<Category> all =category.findAll();
        System.out.println(all);
        System.out.println(all.get(1).getCid());
    }

    @Test
    public void test2(){
        RouteService routeService=new RouteServiceImpl();
        PageBean<Route> routePageBean = routeService.routePageQuery(5, 1, 5, "西安");
        System.out.println(routePageBean);
    }
    @Test
    public void test3(){
        RouteDao dao=new RouteDaoImpl();
        int totalCount = dao.findTotalCount(0, "西安");
        System.out.println(totalCount);
    }
    @Test
    public void test4(){
        RouteDao dao=new RouteDaoImpl();
        Route route = dao.findByRid(1);
        System.out.println(route);
    }
    @Test
    public void test5(){
//        RouteDao dao=new RouteDaoImpl();
//        Route route = dao.findByRid(1);
//        System.out.println(route);
        RouteService service=new RouteServiceImpl();
        Route route1 = service.findOne(1);
        System.out.println(route1);
    }
    @Test
    public void test6(){
        RouteService service=new RouteServiceImpl();
        boolean favorite = service.isFavorite("1", 1);

        System.out.println(favorite);
    }
    @Test
    public void test7(){
        RouteService service=new RouteServiceImpl();
        service.addFavorite("2",1);

//        System.out.println(favorite);
    }


}
