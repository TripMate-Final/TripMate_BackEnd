package com.ssafy.comment.model.service;

import com.ssafy.comment.model.CommentDeleteDto;
import com.ssafy.comment.model.CommentDto;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {
    List<CommentDto> commentListAll(int contentId) throws SQLException;
    void commentDelete(CommentDeleteDto commentDeleteDto) throws SQLException;

}
