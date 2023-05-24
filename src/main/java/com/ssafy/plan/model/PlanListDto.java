package com.ssafy.plan.model;

import java.util.List;

public class PlanListDto {
    private List<PlanDetailDto> planList;
    private String planTitle;
    private String planCreatedDate;
    private int planLength;
    private String userId;

    public List<PlanDetailDto> getPlanList() {
        return planList;
    }

    public void setPlanList(List<PlanDetailDto> planList) {
        this.planList = planList;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getPlanCreatedDate() {
        return planCreatedDate;
    }

    public void setPlanCreatedDate(String planCreatedDate) {
        this.planCreatedDate = planCreatedDate;
    }

    public int getPlanLength() {
        return planLength;
    }

    public void setPlanLength(int planLength) {
        this.planLength = planLength;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PlanListDto{" +
                "planList=" + planList +
                ", planTitle='" + planTitle + '\'' +
                ", planCreatedDate='" + planCreatedDate + '\'' +
                ", planLength=" + planLength +
                ", userId='" + userId + '\'' +
                '}';
    }
}
