package com.it.util;

public class Pages {
    private int pageNum;//当前页
    private int pageSize;//每页显示条数
    private int pageAll;//总条数
    //上一页
    public int up(){
        if(pageNum>1){
            pageNum--;
        }
        return pageNum;
    }
    //下一页
    public int down(){
        int pageIndex;
        if(pageAll%pageSize==0){
            pageIndex=pageAll/pageSize;
        }else {
            pageIndex=pageAll/pageSize+1;
        }
        if(pageNum<pageIndex){
            pageNum++;
        }
        return pageNum;
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

    public int getPageAll() {
        return pageAll;
    }

    public void setPageAll(int pageAll) {
        this.pageAll = pageAll;
    }
}