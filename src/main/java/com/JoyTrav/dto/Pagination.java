package com.JoyTrav.dto;

import java.util.List;

public class Pagination<T>{
    private int pageSIze;
    private int currentPage;
    private int totalPage;
    private List<Integer> pageNumbers;

    private List<T> list;

    public Pagination() {
    }

    public Pagination(int page) {
        this.currentPage = page;

    }

    public int getPageSIze() {
        return pageSIze;
    }

    public void setPageSIze(int pageSIze) {
        this.pageSIze = pageSIze;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<Integer> getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(List<Integer> pageNumbers) {
        this.pageNumbers = pageNumbers;
    }
}
