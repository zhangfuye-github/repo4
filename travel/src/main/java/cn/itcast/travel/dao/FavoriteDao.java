package cn.itcast.travel.dao;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/28
 * @Description:
 */
public interface FavoriteDao {
    int findByRid(int rid);

    void addFavorite(int parseInt, int uid);
}
