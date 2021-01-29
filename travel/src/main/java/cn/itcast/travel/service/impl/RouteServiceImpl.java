package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/27
 * @Description:
 */
public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao=new RouteDaoImpl();
    private RouteImgDao routeImgDao=new RouteImgDaoImpl();
    private SellerDao sellerDao=new SellerDaoImpl();
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public PageBean<Route> routePageQuery(int cid, int currentpage, int pagesize, String rnameStr) {
        //1.首先查询总记录数
        int totalCount=routeDao.findTotalCount(cid,rnameStr);
        //2.根据总记录数，计算总页数
        int totalPage=totalCount%pagesize>0?(totalCount/pagesize)+1:totalCount/pagesize;

        //3.查询当前页要显示的记录
        int start=(currentpage-1)*pagesize;
        List<Route> list=routeDao.findAllRoute(cid,start,pagesize,rnameStr);

        PageBean<Route> routePageBean = new PageBean<>();
        routePageBean.setTotalpage(totalPage);
        routePageBean.setCurrentpage(currentpage);
        routePageBean.setPagelist(list);
        routePageBean.setPagesize(pagesize);
        routePageBean.setTotalcount(totalCount);
        return routePageBean;
    }

    @Override
    public Route findOne(int rid) {

        //1.首先创建route对象
//        Route route=new Route();
        //2.首先根据rid进行路线的查询
        Route route=routeDao.findByRid(rid);
        //3.根据rid查看图片详情
        List<RouteImg> routeImg= routeImgDao.findByRid(rid);
        route.setRouteImgList(routeImg);
        //4.查询商家信息
        Seller seller=sellerDao.findBySid(route.getSid());
        route.setSeller(seller);
        int count=favoriteDao.findByRid(rid);
        route.setCount(count);
        return route;
    }

    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite=routeDao.isFavorite(Integer.parseInt(rid),uid);
        if(favorite==null){
            return false;
        }
        return true;
    }

    @Override
    public void addFavorite(String rid, int uid) {
        favoriteDao.addFavorite(Integer.parseInt(rid),uid);
    }
}
