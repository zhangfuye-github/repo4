package com.itheima.dao.impl;

import com.itheima.dao.ProvinceDao;
import com.itheima.domain.Province;
import com.itheima.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/14
 * @Description:
 */
public class ProvinceDaoImpl implements ProvinceDao {
    //1.获取链接
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        //2.编写sql
        String  sql="select * from province";
        //3.执行sql
        List<Province> provinces = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        //4.返回结果
        return provinces;
    }
}
