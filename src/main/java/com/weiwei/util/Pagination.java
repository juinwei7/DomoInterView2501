package com.weiwei.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Pagination<T> {
    private int currentPage;    // 當前頁碼
    private int totalPages;     // 總頁數
    private int pageSize;       // 每頁顯示數量
    private long totalItems;    // 總數據量
    private List<T> items;      // 當前頁數據

    public Pagination(int currentPage, int pageSize, long totalItems, List<T> items) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.items = items;
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", pageSize=" + pageSize +
                ", totalItems=" + totalItems +
                ", items=" + items +
                '}';
    }
}
