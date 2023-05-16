package com.ssafy.plan.model;


import io.swagger.annotations.ApiModel;

@ApiModel(value = "PlanDto (계획)", description = "여행계획 Class")
public class PlanDto {
    private int planId;
    private String planTitle;
    private int planLength;

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
}
