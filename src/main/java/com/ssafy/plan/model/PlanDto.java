package com.ssafy.plan.model;


import io.swagger.annotations.ApiModel;

@ApiModel(value = "PlanDto (계획)", description = "여행계획 Class")
public class PlanDto {
    private int planId;
    private int planDay;
    private int planOrder;
    private int contentId;
    private String addr1;
    private String title;
    private String firstImage;
}
