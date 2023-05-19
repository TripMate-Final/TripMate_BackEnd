package com.ssafy.recommendation.model;

public class RecommendationListDto {
    private int recommendId1;
    private int recommendId2;
    private int recommendId3;
    private int recommendId4;
    private int recommendId5;

    public RecommendationListDto(int recommendId1, int recommendId2, int recommendId3, int recommendId4, int recommendId5) {
        this.recommendId1 = recommendId1;
        this.recommendId2 = recommendId2;
        this.recommendId3 = recommendId3;
        this.recommendId4 = recommendId4;
        this.recommendId5 = recommendId5;
    }

    public int getRecommendId1() {
        return recommendId1;
    }

    public int getRecommendId2() {
        return recommendId2;
    }

    public int getRecommendId3() {
        return recommendId3;
    }

    public int getRecommendId4() {
        return recommendId4;
    }

    public int getRecommendId5() {
        return recommendId5;
    }

    @Override
    public String toString() {
        return "RecommendationListDto{" +
                "recommendId1=" + recommendId1 +
                ", recommendId2=" + recommendId2 +
                ", recommendId3=" + recommendId3 +
                ", recommendId4=" + recommendId4 +
                ", recommendId5=" + recommendId5 +
                '}';
    }
}
