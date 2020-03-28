package com.cmbc.demo01;

public class BaoZi {
    private String pi;
    private String xian;
    boolean flag=false;
    public BaoZi() {
    }

    public BaoZi(String pi, String xian) {
        this.pi = pi;
        this.xian = xian;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }
}
