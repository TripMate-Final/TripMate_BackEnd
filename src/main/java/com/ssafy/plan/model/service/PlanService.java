package com.ssafy.plan.model.service;

import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.PlanViewDto;

import java.util.List;

public interface PlanService {
    List<PlanDto> planListAll(String userId);
    List<PlanViewDto> planView(int planId);
}
