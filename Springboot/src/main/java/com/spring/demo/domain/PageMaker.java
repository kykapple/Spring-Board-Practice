package com.spring.demo.domain;

public class PageMaker {

    private PageVO vo;
    private int totalCnt;   // 총 게시글 수
    private int startPage;  // 시작 페이지
    private int endPage;    // 끝 페이지
    private boolean prev;   // 이전 페이지가 있는지
    private boolean next;   // 다음 페이지가 있는지
    private int displayPageCnt = 10;    // 보여줄 페이지 수

    public PageVO getVo() {
        return vo;
    }

    public void setVo(PageVO vo) {
        this.vo = vo;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
        calcData();
    }

    public void calcData() {
        endPage = (int) (Math.ceil(vo.getPage() / (double) displayPageCnt)) * displayPageCnt;

        int check = (int) Math.ceil(getTotalCnt() / (double) vo.getPerPageCnt());
        if (endPage > check) {
            endPage = check;

            startPage = (vo.getPage() / displayPageCnt) * displayPageCnt + 1;
        } else {
            startPage = (endPage - displayPageCnt) + 1;
            if (startPage <= 0)
                startPage = 1;
        }

        prev = startPage == 1 ? false : true;
        next = endPage < check ? true : false;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getDisplayPageCnt() {
        return displayPageCnt;
    }

    public void setDisplayPageCnt(int displayPageCnt) {
        this.displayPageCnt = displayPageCnt;
    }
}
