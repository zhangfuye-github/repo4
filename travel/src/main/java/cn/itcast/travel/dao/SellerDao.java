package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/28
 * @Description:
 */
public interface SellerDao {
    Seller findBySid(int sid);
}
