package com.tensquare.base.pojo;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/21
 * @Description:
 */
public class City {
    private String id;
    private String name;
    private String ishot;

    public City() {
    }

    public City(String id, String name, String ishot) {
        this.id = id;
        this.name = name;
        this.ishot = ishot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }
}
