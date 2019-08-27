package com.io.tmall_springboot.util;

import org.springframework.data.domain.Page;

import java.util.List;

public class Page4Navigator<T> {
    Page<T> pageFormJPA;
    int navigatePages; //分页超链有几个
    int totalPages;
    int number; //第几页（基0)
    long totalElements; //总共多少条数据
    int size;
    int numberOfElements; //最后一页是size
    List<T> content; //数据集合
    boolean isHasContent;
    boolean first;
    boolean last;
    boolean isHasNext;
    boolean isHasPrevious;
    int[] navigatepageNums; //分页超链有几个的数组形式，便于前端展示

    public Page4Navigator(){
        //这个空的分页是为了 Redis 从json格式转化为 Page4Navigator 对象而专门提供的
    }
    public Page4Navigator(Page<T> pageFormJPA,int navigatePages ){
        this.pageFormJPA = pageFormJPA;
        this.navigatePages = navigatePages;
        totalPages = pageFormJPA.getTotalPages();
        number =  pageFormJPA.getNumber();
        totalElements = pageFormJPA.getTotalElements();
        size = pageFormJPA.getSize();
        numberOfElements = pageFormJPA.getNumberOfElements();
        content = pageFormJPA.getContent();
        isHasContent = pageFormJPA.hasContent();
        first = pageFormJPA.isFirst();
        last = pageFormJPA.isLast();
        isHasNext = pageFormJPA.hasNext();
        isHasPrevious = pageFormJPA.hasPrevious();

        calcNavigatepageNums();
    }

    private void calcNavigatepageNums(){
        int navigatepageNums[];
        int totalPages = getTotalPages();
        int num = getNumber();
        //当总页数小于或等于导航页码数时
        if(totalPages <= navigatePages){
            navigatepageNums = new int[totalPages];
            for(int i = 0;i < totalPages;i++){
                navigatepageNums[i] = i + 1;
            }
        }else{ //当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = num - navigatePages/2;
            int endNum = num + navigatePages/2;

            if(startNum < 1){
                startNum = 1;
                //最前navigatePages页
                for(int i = 0;i<navigatePages;i++){
                    navigatepageNums[i] = startNum++;
                }
            }else if(endNum > totalPages){
                endNum = totalPages;
                //最后navigatePages页
                for(int i=navigatePages-1; i>=0;i--){
                    navigatepageNums[i] = endNum--;
                }
            }else {
                //所有中间页
                for (int i=0;i<navigatePages;i++){
                    navigatepageNums[i] = startNum++;
                }
            }
        }
        this.navigatepageNums = navigatepageNums;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public boolean isHasContent() {
        return isHasContent;
    }

    public void setHasContent(boolean hasContent) {
        isHasContent = hasContent;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isHasNext() {
        return isHasNext;
    }

    public void setHasNext(boolean hasNext) {
        isHasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return isHasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        isHasPrevious = hasPrevious;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }
}
