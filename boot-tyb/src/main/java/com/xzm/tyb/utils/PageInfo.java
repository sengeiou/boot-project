package com.xzm.tyb.utils;

import java.io.Serializable;

/**
 * @Author: Seifon
 * @Description: 分页信息
 * @Date: Created in 9:39 2018/4/10
 *
作者：Seifon
链接：https://juejin.im/post/5ae722546fb9a07aa83e8343
来源：掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PageInfo implements Serializable{


    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 总页数
     */
    private Long totalPages;
    /**
     * 当前页
     */
    private Integer pageNo;
    /**
     * 页记录数
     */
    private Integer pageSize;

    public PageInfo(Long total) {
        this.total = total;
    }

    public PageInfo(Long total, Integer pageNo,
                    Integer pageSize) {
        this.total = total;
        this.totalPages = (total - 1) / pageSize + 1;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public static PageInfo page(Long total) {
        return new PageInfo(total);
    }

    public static PageInfo page( Long total, Integer pageNo,
                                 Integer pageSize) {
        return new PageInfo(total, pageNo, pageSize);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
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
}

