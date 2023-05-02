package com.ssafy.board.model.mapper;

import com.ssafy.board.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {
    // 게시글 작성
    void boardWrite(BoardDto boardDto) throws SQLException;
    // 게시글 수정
    BoardDto boardUpdate(BoardDto boardDto) throws SQLException;
    // 게시글 삭제
    void boardDelete(int boardId) throws SQLException;
    // 공지사항 목록 보기
    List<BoardDto> boardNoticeList() throws Exception;
    // 게시글 목록 보기
    List<BoardDto> boardList(String boardType) throws SQLException;
    // 게시글 내용 보기
    BoardDto boardDetail(int boardId) throws SQLException;
    // 게시글 검색
    List<BoardDto> boardSearch(String keyword) throws SQLException;
}
