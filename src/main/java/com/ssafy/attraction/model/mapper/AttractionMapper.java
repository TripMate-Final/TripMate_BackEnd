package com.ssafy.attraction.model.mapper;

import com.ssafy.attraction.model.AttractionDetailDto;
import com.ssafy.attraction.model.AttractionFilterDto;
import com.ssafy.attraction.model.AttractionListDto;
import com.ssafy.attraction.model.AttractionSelectDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionMapper {
    List<AttractionListDto> attractionListAll() throws SQLException;
    AttractionDetailDto attractionDetail(int contentId) throws SQLException;
    void updateHit(int contentId) throws SQLException;
    List<AttractionFilterDto> attractionSelect(AttractionSelectDto attractionSelectDto) throws SQLException;
    List<AttractionFilterDto> attractionSelectOption(AttractionSelectDto attractionSelectDto) throws SQLException;
}
