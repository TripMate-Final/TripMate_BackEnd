package com.ssafy.plan.model.mapper;

import com.ssafy.plan.PlanDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanMapper {
    void PlanRegist(PlanDto planDto);
}
