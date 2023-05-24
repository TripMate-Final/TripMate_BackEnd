package com.ssafy.comment.model.mapper;

import com.ssafy.comment.model.CommentDeleteDto;
import com.ssafy.comment.model.CommentDto;
import com.ssafy.comment.model.CommentRegisterDto;
import com.ssafy.comment.model.CommentUpdateDto;
import org.apache.ibatis.annotations.Mapper;


import java.sql.SQLException;
import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentDto> commentListAll(int contentId) throws SQLException;
    void commentDelete(CommentDeleteDto commentDeleteDto) throws SQLException;
    void commentUpdate(CommentUpdateDto commentUpdateDto) throws SQLException;
    void commentRegister(CommentRegisterDto commentRegistDto) throws SQLException;
}
