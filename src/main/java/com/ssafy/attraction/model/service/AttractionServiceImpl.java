package com.ssafy.attraction.model.service;

import com.ssafy.attraction.model.AttractionDetailDto;
import com.ssafy.attraction.model.AttractionListDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService{

    private AttractionMapper attractionMapper;

    public AttractionServiceImpl(AttractionMapper attractionMapper) {
        this.attractionMapper = attractionMapper;
    }

    @Override
    public List<AttractionListDto> attractionListAll() throws Exception {
        return attractionMapper.attractionListAll();
    }

    @Override
    public AttractionDetailDto attractionDetail(int contentId) throws Exception {
        return attractionMapper.attractionDetail(contentId);
    }

    @Override
    public void updateHit(int contentId) throws Exception {
        attractionMapper.updateHit(contentId);
    }
}
