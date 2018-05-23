package dev.blog.dao;

public class Page {

    private int totalPageNum;

    private int currentPage;

    private int totalNum;

    public static final int itemNumPerPage = 8;

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public Page(int currentPage, int totalNum) {
        this.currentPage = currentPage;
        this.totalNum = totalNum;
        totalPageNum = totalNum / itemNumPerPage;
        int k = totalNum % itemNumPerPage;
        if(k > 0)
            totalPageNum++;
    }
}
