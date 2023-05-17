package com.ssafy.recommendation.model.service;

import com.ssafy.recommendation.model.RecommendationListDto;

import java.util.List;

public interface RecommendationService {
    List<RecommendationListDto> recommendList(int contentId) throws Exception;
}
