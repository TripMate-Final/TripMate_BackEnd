package com.ssafy.attraction.model.service;

import com.ssafy.attraction.model.*;

import java.sql.SQLException;
import java.util.List;

public interface AttractionService {
    List<AttractionListDto> attractionListAll() throws Exception;
    AttractionDetailDto attractionDetail(AttractionMinDto attractionMinDto) throws Exception;

    void updateHit(int contentId) throws Exception;

    List<AttractionFilterDto> attractionSelect(AttractionSelectDto attractionSelectDto) throws Exception;

    List<AttractionFilterDto> attractionSelectOption(AttractionSelectDto attractionSelectDto) throws Exception;
    AttractionPreviewDto attractionPreview(int contentId) throws Exception;
}
