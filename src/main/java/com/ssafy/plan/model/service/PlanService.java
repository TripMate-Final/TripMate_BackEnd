package com.ssafy.plan.model.service;

import com.ssafy.plan.model.*;

import java.util.List;

public interface PlanService {
    void planRegist(PlanListDto planList);
    List<PlanDto> planListAll(String userId);
    List<PlanViewDto> planView(int planId);


    void planDelete(PlanDeleteDto planDeleteDto);
    int planCountUser(int planId);
    void planShare(PlanShareDto planShareDto);
    void planShareOk(PlanShareDto planShareDto);
    void planDeleteAll(int planId);
}
