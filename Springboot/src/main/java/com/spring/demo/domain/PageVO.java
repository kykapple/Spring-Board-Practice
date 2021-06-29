package com.spring.demo.domain;

// 페이징 구현 클래스
public class PageVO {
    private int page;   // 현재 페이지 정보
    private int perPageCnt; // 페이지 당 보여줄 게시글 수

    public PageVO() {   // 디폴트 값
        this.page = 1;
        this.perPageCnt = 10;
    }

    // 특정 페이지의 게시글 시작 번호
    public int getPageStart() {
        return (this.page - 1) * perPageCnt;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPageCnt() {
        return perPageCnt;
    }

    public void setPerPageCnt(int perPageCnt) {
        this.perPageCnt = perPageCnt;
    }
}
