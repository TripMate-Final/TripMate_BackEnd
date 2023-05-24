package com.ssafy.attraction.model;

public class AttractionSelectDto {
  private String keyword;
  private int categoryCode;
  private int page;
  private String userId;

    public AttractionSelectDto(String keyword, int categoryCode, int page) {
        this.keyword = keyword;
        this.categoryCode = categoryCode;
        this.page = page;
    }

    public AttractionSelectDto(String keyword, int categoryCode, int page , String userId) {
        this.keyword = keyword;
        this.categoryCode = categoryCode;
        this.page = page;
        this.userId = userId;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public int getPage() {
        return page;
    }
    public String getUserId() {
        return userId;
    }
    @Override
    public String toString() {
        return "AttractionSelectDto{" +
                "keyword='" + keyword + '\'' +
                ", categoryCode=" + categoryCode +
                '}';
    }
}
