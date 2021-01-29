package cn.itcast.travel.domain;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/27
 * @Description:分页的实体类，用于封装要返回的数据
 */
public class PageBean<T> {
    //总页数
    private int totalpage;
    //当前页
    private int currentpage;
    //每页显示条数
    private int pagesize;
    //总记录数
    private int totalcount;

    @Override
    public String toString() {
        return "PageBean{" +
                "totalpage=" + totalpage +
                ", currentpage=" + currentpage +
                ", pagesize=" + pagesize +
                ", totalcount=" + totalcount +
                ", pagelist=" + pagelist +
                '}';
    }

    //每页要展示的内容
    private List<T> pagelist;

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public List<T> getPagelist() {
        return pagelist;
    }

    public void setPagelist(List<T> pagelist) {
        this.pagelist = pagelist;
    }
}
