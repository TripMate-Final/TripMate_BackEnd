package com.ssafy.attraction.model;

public class AttractionSelectDto {
  private String keyword;
  private int categoryCode;

    public AttractionSelectDto(String keyword, int categoryCode) {
        this.keyword = keyword;
        this.categoryCode = categoryCode;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    @Override
    public String toString() {
        return "AttractionSelectDto{" +
                "keyword='" + keyword + '\'' +
                ", categoryCode=" + categoryCode +
                '}';
    }
}
