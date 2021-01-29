package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/27
 * @Description:
 */
public interface RouteService {
    /**
     * 用于路线的分页展示
     * @param cid
     * @param currentpage
     * @param pagesize
     * @param rnameStr
     * @return
     */
    PageBean<Route> routePageQuery(int cid, int currentpage, int pagesize, String rnameStr);

    /**
     * 查看路线详情
     * @param rid
     * @return
     */
    public Route findOne(int rid);

    boolean isFavorite(String rid, int uid);

    void addFavorite(String rid, int uid);
}
