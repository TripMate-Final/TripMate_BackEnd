package com.ssafy.attraction.model.service;

import com.ssafy.attraction.model.AttractionDetailDto;
import com.ssafy.attraction.model.AttractionFilterDto;
import com.ssafy.attraction.model.AttractionListDto;
import com.ssafy.attraction.model.AttractionSelectDto;

import java.sql.SQLException;
import java.util.List;

public interface AttractionService {
    List<AttractionListDto> attractionListAll() throws Exception;
    AttractionDetailDto attractionDetail(int contentId) throws Exception;

    void updateHit(int contentId) throws Exception;

    List<AttractionFilterDto> attractionSelect(AttractionSelectDto attractionSelectDto) throws Exception;

    List<AttractionFilterDto> attractionSelectOption(String keyword) throws Exception;
}
