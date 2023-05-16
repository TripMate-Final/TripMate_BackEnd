package com.ssafy.attraction.model;

public class AttractionDetailDto{
    private int contentId;
    private String title;
    private String firstImage;
    private String addr1;
    private String zipCode;
    private String overview;
    private Double latitude;
    private Double longitude;
    private String sidoName;
    private String gugunName;
    private String categoryName;
    private String cat1Name;
    private String cat2Name;
    private String cat3Name;
    private int hit;
    private int likeCnt;

    public AttractionDetailDto(int contentId, String title, String firstImage, String addr1, String zipCode, String overview, Double latitude, Double longitude, String sidoName, String gugunName, String categoryName, String cat1Name, String cat2Name, String cat3Name, int hit, int likeCnt) {
        this.contentId = contentId;
        this.title = title;
        this.firstImage = firstImage;
        this.addr1 = addr1;
        this.zipCode = zipCode;
        this.overview = overview;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sidoName = sidoName;
        this.gugunName = gugunName;
        this.categoryName = categoryName;
        this.cat1Name = cat1Name;
        this.cat2Name = cat2Name;
        this.cat3Name = cat3Name;
        this.hit = hit;
        this.likeCnt = likeCnt;
    }

    public int getContentId() {
        return contentId;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public String getAddr1() {
        return addr1;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getOverview() {
        return overview;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getSidoName() {
        return sidoName;
    }

    public String getGugunName() {
        return gugunName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCat1Name() {
        return cat1Name;
    }

    public String getCat2Name() {
        return cat2Name;
    }

    public String getCat3Name() {
        return cat3Name;
    }

    public int getHit() {
        return hit;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    @Override
    public String toString() {
        return "AttractionDetailDto{" +
                "contentId=" + contentId +
                ", title='" + title + '\'' +
                ", firstImage='" + firstImage + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", overview='" + overview + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", sidoName='" + sidoName + '\'' +
                ", gugunName='" + gugunName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", cat1Name='" + cat1Name + '\'' +
                ", cat2Name='" + cat2Name + '\'' +
                ", cat3Name='" + cat3Name + '\'' +
                ", hit=" + hit +
                ", likeCnt=" + likeCnt +
                '}';
    }
}
