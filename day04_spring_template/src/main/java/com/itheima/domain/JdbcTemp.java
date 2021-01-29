package com.itheima.domain;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/18
 * @Description:
 */
public class JdbcTemp {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
