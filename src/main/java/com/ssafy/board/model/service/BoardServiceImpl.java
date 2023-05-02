package com.ssafy.board.model.service;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    private BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    @Override
    public void boardWrite(BoardDto boardDto) throws Exception {
        boardMapper.boardWrite(boardDto);
    }

    @Override
    public void boardUpdate(BoardDto boardDto) throws Exception {
        boardMapper.boardUpdate(boardDto);
    }

    @Override
    public void boardDelete(int boardId) throws Exception {
        boardMapper.boardDelete(boardId);
    }

    @Override
    public List<BoardDto> boardNoticeList() throws Exception {
        return boardMapper.boardNoticeList();
    }

    @Override
    public List<BoardDto> boardListAll() throws Exception {
        return boardMapper.boardListAll();
    }

    @Override
    public BoardDto boardDetail(int boardId) throws Exception {
        return boardMapper.boardDetail(boardId);
    }

    @Override
    public List<BoardDto> boardSearch(String keyword) throws Exception {
        return null;
    }
}
