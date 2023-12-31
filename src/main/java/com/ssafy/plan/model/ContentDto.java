package com.ssafy.plan.model;

public class ContentDto {
    private int contentId;
    private String title;
    private String firstImage;
    private String addr1;
    private Double latitude;
    private Double longitude;
    private String sidoName;
    private String gugunName;
    private String categoryName;
    private String cat1Name;
    private String cat2Name;
    private String cat3Name;
    private int likeCnt;

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getSidoName() {
        return sidoName;
    }

    public void setSidoName(String sidoName) {
        this.sidoName = sidoName;
    }

    public String getGugunName() {
        return gugunName;
    }

    public void setGugunName(String gugunName) {
        this.gugunName = gugunName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCat1Name() {
        return cat1Name;
    }

    public void setCat1Name(String cat1Name) {
        this.cat1Name = cat1Name;
    }

    public String getCat2Name() {
        return cat2Name;
    }

    public void setCat2Name(String cat2Name) {
        this.cat2Name = cat2Name;
    }

    public String getCat3Name() {
        return cat3Name;
    }

    public void setCat3Name(String cat3Name) {
        this.cat3Name = cat3Name;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }

    @Override
    public String toString() {
        return "ContentDto{" +
                "contentId=" + contentId +
                ", title='" + title + '\'' +
                ", firstImage='" + firstImage + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", sidoName='" + sidoName + '\'' +
                ", gugunName='" + gugunName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", cat1Name='" + cat1Name + '\'' +
                ", cat2Name='" + cat2Name + '\'' +
                ", cat3Name='" + cat3Name + '\'' +
                ", likeCnt=" + likeCnt +
                '}';
    }
}
