package com.zzh.pojo;

import java.util.List;

public class PageBean<T> {
    private int counts;
    private List<T> pageItems;

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public List<T> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<T> pageItems) {
        this.pageItems = pageItems;
    }
}
