package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/27
 * @Description:
 */
public class RouteDaoImpl implements RouteDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int cid, String rnameStr) {
        /*
        sql=select count(*) from tab_route where 1==1;
        此处要进行字符串的拼接
         */

        String sql=" select count(*) from tab_route where 1=1 ";
        //此处对参数进行判断，然后进行追加
        StringBuilder sb=new StringBuilder(sql);
        List list =new ArrayList();
        if(cid>0){
            sb.append(" and cid=? ");
            list.add(cid);
        }
        if(rnameStr!=null&&rnameStr.length()>0){
            sb.append(" and rname like ? ");
            list.add("%"+rnameStr+"%");
        }
        sql=sb.toString();
//        System.out.println(sql);
        int i = template.queryForObject(sql, Integer.class, list.toArray());
        return i;
    }

    @Override
    public List<Route> findAllRoute(int cid, int start, int pagesize, String rnameStr) {
        String sql=" select * from tab_route where 1=1 ";

//        String sql="select * from tab_route where cid=? limit ?,? ";
//此处对参数进行判断，然后进行追加
        StringBuilder sb=new StringBuilder(sql);
        List list =new ArrayList();
        if(cid>0){
            sb.append(" and cid=? ");
            list.add(cid);
        }
        if(rnameStr!=null&&rnameStr.length()>0){
            sb.append(" and rname like ? ");
            list.add("%"+rnameStr+"%");
        }
        sb.append(" limit ?,?");
        list.add(start);
        list.add(pagesize);

        sql=sb.toString();
//        System.out.println(sql);
//        System.out.println(cid+""+start+""+pagesize+""+rnameStr);
        List<Route> list1 = template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), list.toArray());
//        System.out.println(list1);
        return list1;
    }

    @Override
    public Route findByRid(int rid) {
        String sql="select * from tab_route where rid=?";
        Route route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
        return route;
    }

    @Override
    public Favorite isFavorite(int rid, int uid) {
        Favorite favorite = null;
        try {
            String sql="select * from tab_favorite where rid=? and uid=?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return favorite;
    }
}
