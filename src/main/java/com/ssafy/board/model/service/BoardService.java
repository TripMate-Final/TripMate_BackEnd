package com.ssafy.board.model.service;

import com.ssafy.board.model.BoardDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BoardService {

    // 게시글 작성
    void boardWrite(BoardDto boardDto) throws Exception;
    // 게시글 수정
    void boardUpdate(BoardDto boardDto) throws Exception;
    // 게시글 삭제
    void boardDelete(int boardId) throws Exception;
    // 공지사항 목록 보기
    List<BoardDto> boardNoticeList() throws Exception;
    // 게시글 목록 보기
    List<BoardDto> boardList(Map<String, String > map) throws Exception;
    // 게시글 내용 보기
    BoardDto boardDetail(int boardId) throws Exception;

    void updateHit(int boardId) throws Exception;
}
