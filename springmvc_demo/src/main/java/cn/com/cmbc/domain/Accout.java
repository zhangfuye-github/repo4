package cn.com.cmbc.domain;

import java.io.Serializable;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/2
 * @Description:
 */
public class Accout implements Serializable {
    private String name;
    private Double money;
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Accout{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
