package com.ssafy.plan.model;

public class PlanContentDto {
    public int contentId;

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    @Override
    public String toString() {
        return "PlanContentDto{" +
                "contentId=" + contentId +
                '}';
    }
}
