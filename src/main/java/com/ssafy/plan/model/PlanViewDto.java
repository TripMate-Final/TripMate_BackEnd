package com.ssafy.plan.model;

public class PlanViewDto {
    private int planId;
    private String planTitle;

    private int planLength;
    private int planDay;
    private int planOrder;
    private int contentId;
    private String addr1;
    private String title;
    private String firstImage;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public int getPlanLength() {
        return planLength;
    }

    public void setPlanLength(int planLength) {
        this.planLength = planLength;
    }

    public int getPlanDay() {
        return planDay;
    }

    public void setPlanDay(int planDay) {
        this.planDay = planDay;
    }

    public int getPlanOrder() {
        return planOrder;
    }

    public void setPlanOrder(int planOrder) {
        this.planOrder = planOrder;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
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
}
