package com.ssafy.plan.model;

import java.util.List;

public class PlanViewListDto {
    private int planId;
    private String planTitle;
    private int planLength;
    private List<PlanViewDto> planList;

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

    public List<PlanViewDto> getPlanList() {
        return planList;
    }

    public void setPlanList(List<PlanViewDto> planList) {
        this.planList = planList;
    }

    @Override
    public String toString() {
        return "PlanViewListDto{" +
                "planId=" + planId +
                ", planTitle='" + planTitle + '\'' +
                ", planLength=" + planLength +
                ", planList=" + planList +
                '}';
    }
}
