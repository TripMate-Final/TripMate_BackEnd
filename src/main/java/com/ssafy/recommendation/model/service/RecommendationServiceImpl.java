package com.ssafy.recommendation.model.service;

import com.ssafy.recommendation.model.RecommendationListDto;
import com.ssafy.recommendation.model.mapper.RecommendationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

   private RecommendationMapper recommendationMapper;

    public RecommendationServiceImpl(RecommendationMapper recommendationMapper) {
        this.recommendationMapper = recommendationMapper;
    }

    @Override
    public List<RecommendationListDto> recommendList(int contentId) throws Exception {
        return recommendationMapper.recommendList(contentId);
    }
}
