package com.ssafy.attraction.model.mapper;

import com.ssafy.attraction.model.AttractionListDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionMapper {
    List<AttractionListDto> attractionListAll() throws SQLException;
}
