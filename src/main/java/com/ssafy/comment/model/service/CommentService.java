package com.ssafy.comment.model.service;

import com.ssafy.comment.model.CommentDeleteDto;
import com.ssafy.comment.model.CommentDto;
import com.ssafy.comment.model.CommentRegistDto;
import com.ssafy.comment.model.CommentUpdateDto;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {
    List<CommentDto> commentListAll(int contentId) throws SQLException;
    void commentDelete(CommentDeleteDto commentDeleteDto) throws SQLException;
    void commentUpdate(CommentUpdateDto commentUpdateDto) throws SQLException;
    void commentRegist(CommentRegistDto commentRegistDto) throws SQLException;
}
