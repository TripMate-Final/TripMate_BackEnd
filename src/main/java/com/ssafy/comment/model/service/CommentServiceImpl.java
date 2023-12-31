package com.ssafy.comment.model.service;

import com.ssafy.comment.model.CommentDeleteDto;
import com.ssafy.comment.model.CommentDto;
import com.ssafy.comment.model.CommentRegisterDto;
import com.ssafy.comment.model.CommentUpdateDto;
import com.ssafy.comment.model.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDto> commentListAll(int contentId) throws SQLException {
        return commentMapper.commentListAll(contentId);
    }

    @Override
    public void commentDelete(CommentDeleteDto commentDeleteDto) throws SQLException {
        commentMapper.commentDelete(commentDeleteDto);
    }

    @Override
    public void commentUpdate(CommentUpdateDto commentUpdateDto) throws SQLException {
        commentMapper.commentUpdate(commentUpdateDto);
    }
    @Override
    public void commentRegister(CommentRegisterDto commentRegisterDto) throws SQLException {
        commentMapper.commentRegister(commentRegisterDto);
    }
}
