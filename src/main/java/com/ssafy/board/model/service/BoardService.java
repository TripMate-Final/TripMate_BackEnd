package com.ssafy.board.model.service;

import com.ssafy.board.model.BoardDto;

import java.util.List;

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
    List<BoardDto> boardList(String boardType) throws Exception;
    // 게시글 내용 보기
    BoardDto boardDetail(int boardId) throws Exception;
    // 게시글 검색
    List<BoardDto> boardSearch(String keyword) throws Exception;

}
