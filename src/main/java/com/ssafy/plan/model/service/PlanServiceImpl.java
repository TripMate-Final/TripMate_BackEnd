package com.ssafy.plan.model.service;

import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.PlanViewDto;
import com.ssafy.plan.model.mapper.PlanMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService{
    PlanMapper planMapper;
    public PlanServiceImpl(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    @Override
    public List<PlanDto> planListAll(String userId) {
        return planMapper.planListAll(userId);
    }

    @Override
    public List<PlanViewDto> planView(int planId) {
        return planMapper.planView(planId);
    }
}
