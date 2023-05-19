package com.ssafy.recommendation.model.mapper;

import com.ssafy.recommendation.model.RecommendationListDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface RecommendationMapper {
    List<RecommendationListDto> recommendList(int contentId) throws SQLException;
}
