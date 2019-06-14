package com.mengfei.security;

import java.io.Serializable;

public class SplitPage implements Serializable {
    private static final long serialVersionUID = 7337910362036192277L;
    private int pageNum = 1;
    private int pageCount = 1;
    private int pageSize = 10;
    private long rowCount = 0;


    public SplitPage() {
    }

    public SplitPage(Integer pageNum,Integer pageCount, Integer pageSize, long rowCount) {
        this.pageNum = pageNum;
        this.pageCount=pageCount;
        this.pageSize = pageSize;
        this.rowCount = rowCount;

    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowCount() {
        return this.rowCount;
    }
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }


}

