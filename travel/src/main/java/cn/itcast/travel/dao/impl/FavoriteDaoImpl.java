package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/28
 * @Description:
 */
public class FavoriteDaoImpl implements FavoriteDao {
    //首先连接数据库
    private  JdbcTemplate  template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findByRid(int rid) {
        String sql="select count(*) from tab_favorite where rid=?";
        int i = (int)template.queryForObject(sql, Integer.class, rid);
        return i;
    }

    @Override
    public void addFavorite(int rid, int uid) {
        String sql="insert into tab_favorite values (?,?,?)";
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(date);
        template.update(sql, rid, format1, uid);
    }
}
