package com.ssafy.comment.model.service;

import com.ssafy.comment.model.CommentDto;
import com.ssafy.comment.model.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    private CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDto> commentListAll(int contentId) throws SQLException {
        return commentMapper.commentListAll(contentId);
    }
}
