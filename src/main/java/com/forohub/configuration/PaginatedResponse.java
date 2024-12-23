package com.forohub.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PaginatedResponse<T> {
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private List<T> content;

    public PaginatedResponse(Page<T> page) {
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber();
        this.content = page.getContent();
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}

