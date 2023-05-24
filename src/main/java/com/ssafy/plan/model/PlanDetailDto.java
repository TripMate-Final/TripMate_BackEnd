package com.ssafy.plan.model;

import java.util.List;

public class PlanDetailDto {
    private int day;
    private int planOrder;
    private List<PlanContentDto> elements;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPlanOrder() {
        return planOrder;
    }

    public void setPlanOrder(int planOrder) {
        this.planOrder = planOrder;
    }

    public List<PlanContentDto> getElements() {
        return elements;
    }

    public void setElements(List<PlanContentDto> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "PlanDetailDto{" +
                "day=" + day +
                ", planOrder=" + planOrder +
                ", elements=" + elements +
                '}';
    }
}
