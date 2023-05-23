package com.ssafy.attraction.model.mapper;

import com.ssafy.attraction.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionMapper {
    List<AttractionListDto> attractionListAll() throws SQLException;
    AttractionDetailDto attractionDetail(int contentId) throws SQLException;
    void updateHit(int contentId) throws SQLException;
    List<AttractionFilterDto> attractionSelect(AttractionSelectDto attractionSelectDto) throws SQLException;
    List<AttractionFilterDto> attractionSelectOption(AttractionSelectDto attractionSelectDto) throws SQLException;
    AttractionPreviewDto attractionPreview(int contentId) throws SQLException;
}
