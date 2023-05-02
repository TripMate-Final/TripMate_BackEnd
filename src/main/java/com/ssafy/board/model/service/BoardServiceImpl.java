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
    public BoardDto boardUpdate(BoardDto boardDto) throws Exception {
        return null;
    }

    @Override
    public void boardDelete(String boardId) throws Exception {

    }

    @Override
    public List<BoardDto> boardNoticeList() throws Exception {
        return boardMapper.boardNoticeList();
    }

    @Override
    public List<BoardDto> boardList(String boardType) throws Exception {
        return boardMapper.boardList(boardType);
    }

    @Override
    public BoardDto boardDetail(int board_id) throws Exception {
        return null;
    }

    @Override
    public List<BoardDto> boardSearch(String keyword) throws Exception {
        return null;
    }
}
