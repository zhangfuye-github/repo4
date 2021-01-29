package cn.com.cmbc.domain;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/20
 * @Description:
 */
public class User implements Serializable {
    private  String uname;
    private String password;

    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
