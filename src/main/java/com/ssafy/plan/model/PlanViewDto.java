package com.ssafy.plan.model;

import java.util.List;

public class PlanViewDto {
    private int day;
    private List<ContentDto> elements;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<ContentDto> getElements() {
        return elements;
    }

    public void setElements(List<ContentDto> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "GetPlanDto{" +
                "day=" + day +
                ", elements=" + elements +
                '}';
    }
}

