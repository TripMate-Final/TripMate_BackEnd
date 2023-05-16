package com.ssafy.comment.model.service;

import com.ssafy.comment.model.CommentDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {
    List<CommentDto> commentListAll(int contentId) throws SQLException;

}
