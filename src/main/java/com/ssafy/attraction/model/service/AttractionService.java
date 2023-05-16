package com.ssafy.attraction.model.service;

import com.ssafy.attraction.model.AttractionListDto;

import java.util.List;

public interface AttractionService {
    List<AttractionListDto> attractionListAll() throws Exception;
}
