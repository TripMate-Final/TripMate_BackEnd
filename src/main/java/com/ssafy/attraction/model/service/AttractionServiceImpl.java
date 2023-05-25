package com.ssafy.attraction.model.service;

import com.ssafy.attraction.model.*;
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
    public AttractionDetailDto attractionDetail(AttractionMinDto attractionMinDto) throws Exception {
        return attractionMapper.attractionDetail(attractionMinDto);
    }

    @Override
    public void updateHit(int contentId) throws Exception {
        attractionMapper.updateHit(contentId);
    }

    @Override
    public List<AttractionFilterDto> attractionSelect(AttractionSelectDto attractionSelectDto) throws Exception {
        return attractionMapper.attractionSelect(attractionSelectDto);
    }

    @Override
    public List<AttractionFilterDto> attractionSelectOption(AttractionSelectDto attractionSelectDto) throws Exception {
        return attractionMapper.attractionSelectOption(attractionSelectDto);
    }

    @Override
    public AttractionPreviewDto attractionPreview(int contentId) throws Exception {
        return attractionMapper.attractionPreview(contentId);
    }
}
