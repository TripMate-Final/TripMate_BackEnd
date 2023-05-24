package com.ssafy.plan.model.service;

import com.ssafy.plan.model.*;
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
    public void planRegist(PlanListDto planList) {
        planMapper.planRegist(planList);
    }
    @Override
    public List<PlanDto> planListAll(String userId) {
        return planMapper.planListAll(userId);
    }

    @Override
    public List<GetPlanDto> planView(int planId) {
        return planMapper.planView(planId);
    }

    @Override
    public void planDelete(PlanDeleteDto planDeleteDto) {
        planMapper.planDelete(planDeleteDto);
    }

    @Override
    public int planCountUser(int planId) {
        return planMapper.planCountUser(planId);
    }

    @Override
    public void planShare(PlanShareDto planShareDto) {
        planMapper.planShare(planShareDto);
    }

    @Override
    public void planShareOk(PlanShareDto planShareDto) {
        planMapper.planShareOk(planShareDto);
    }

    @Override
    public void planDeleteAll(int planId) {
        planMapper.planDeleteAll(planId);
    }
}
