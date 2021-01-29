package com.itheima.domain;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/3
 * @Description:
 */
public class QueryVO {
    private List<Integer> ids;
    private List<User> user;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
