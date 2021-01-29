package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/28
 * @Description:
 */
public interface RouteImgDao {
    List<RouteImg> findByRid(int rid);
}
