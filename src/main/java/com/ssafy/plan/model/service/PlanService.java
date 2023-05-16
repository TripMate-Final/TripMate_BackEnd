package com.ssafy.plan.model.service;

import com.ssafy.plan.model.PlanViewDto;

import java.util.List;

public interface PlanService {
    List<PlanViewDto> planView(int planId);
}
