package com.ssafy.attraction.model.service;

import com.ssafy.attraction.model.AttractionDetailDto;
import com.ssafy.attraction.model.AttractionListDto;

import java.sql.SQLException;
import java.util.List;

public interface AttractionService {
    List<AttractionListDto> attractionListAll() throws Exception;
    AttractionDetailDto attractionDetail(int contentId) throws Exception;
}
