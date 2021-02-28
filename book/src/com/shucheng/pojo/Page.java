package com.shucheng.pojo;

import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class Page<T> {
    public static final int PAGE_SIZE =8;//当前页显示的默认记录数
    private  Integer pageNo;//当前页码
    private Integer pageSize = PAGE_SIZE;//当前页码显示的数量
    private Integer pageTotalCount;//总记录的数量
    private Integer pageTotal;//总页码
    private List<T> items;//当前页显示的数据

    public Page() {
        super();
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotalCount, Integer pageTotal, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.pageTotal = pageTotal;
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", pageTotal=" + pageTotal +
                ", items=" + items +
                '}';
    }
}
