package com.ssafy.plan.model.mapper;

import com.ssafy.plan.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {
    void planRegist(PlanListDto planList); //plan 추가하기
    void planUpdate(PlanDto planDto); //plan 수정하기
    List<PlanDto> planListAll(String userId); //내가 가진 모든 plan 보기
    List<GetPlanDto> planView(int planId); //plan 상세보기
    void planShare(PlanShareDto planShareDto); //plan 친구에게 공유 요청 보내기
    void planDelete(PlanDeleteDto planDeleteDto); //plan 삭제하기 이플랜을 가지고있는 사람이 없으면 진짜로지우기
    void planShareOk(PlanShareDto planShareDto); //plan 공유요청 수락하기
    int planCountUser(int planId);
    void planDeleteAll(int planId);

}
