package com.gdy.thieseback.req;

public class PageReq {

    //页码
    private int page;

    //尺寸
    private int size;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pagereq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
