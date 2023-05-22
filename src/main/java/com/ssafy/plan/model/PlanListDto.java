package com.ssafy.plan.model;

import java.util.List;

public class PlanListDto {
    private List<PlanDetailDto> planList;
    private String planTitle;
    private String planStartDate;
    private String planEndDate;
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

    public String getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(String planStartDate) {
        this.planStartDate = planStartDate;
    }

    public String getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(String planEndDate) {
        this.planEndDate = planEndDate;
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
}
