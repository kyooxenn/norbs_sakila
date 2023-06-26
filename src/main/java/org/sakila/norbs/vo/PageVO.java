package org.sakila.norbs.vo;

import java.io.Serializable;

public class PageVO implements Serializable {
    private static final long serialVersionUID = 2609965824614177785L;


    private int pageNum;
    private int pageSize;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
