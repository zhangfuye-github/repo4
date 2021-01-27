package cn.itcast.domain;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/23
 * @Description:
 */
public class PageBean<T> {
    private int currentPage;//当前页
    private int rows;//每页的的行数
    private int totalPage;//总页数
    private int totalCounts;//总记录数
    private List<T> list;//列表信息

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", rows=" + rows +
                ", totalPage=" + totalPage +
                ", totalCounts=" + totalCounts +
                ", list=" + list +
                '}';
    }
}
