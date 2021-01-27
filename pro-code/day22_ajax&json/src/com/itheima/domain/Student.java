package com.itheima.domain;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/12
 * @Description:
 */
public class Student {
    private int id;
    private int classID;
    private String monitor;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", classID=" + classID +
                ", monitor='" + monitor + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
}
