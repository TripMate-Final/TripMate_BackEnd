package com.ssafy.plan.model;
public class PlanDetailDto {
    private int planDay;
    private int planOrder;
    private int contentId;

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
}
