package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/27
 * @Description:
 */
public interface RouteDao {
    /**
     * 查询总记录数
     * @param cid
     * @param rnameStr
     * @return
     */
    int findTotalCount(int cid, String rnameStr);

    /**
     * 查询要分页展示的内容
     * @param cid
     * @param start
     * @param pagesize
     * @param rnameStr
     * @return
     */
    List<Route> findAllRoute(int cid, int start, int pagesize, String rnameStr);

    Route findByRid(int rid);

    Favorite isFavorite(int rid, int uid);
}
