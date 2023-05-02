package com.ssafy.board.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/board")
@CrossOrigin("*")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @ApiOperation(value = "공지사항 목록", notes = "공지사항 목록을 보여줍니다.")
    @ApiResponses({@ApiResponse(code=200, message = "공지사항 목록 OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/list/notice")
    public ResponseEntity<?> boardNoticeList(){
        try {
            List<BoardDto> list = boardService.boardNoticeList();
            logger.debug("list :::" + list);
            if(list != null && !list.isEmpty()) {
                return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    
    @ApiOperation(value = "게시판 목록", notes = "게시판 목록을 보여줍니다.")
    @ApiResponses({@ApiResponse(code=200, message = "게시판 목록 OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/list/{boardType}")
    public ResponseEntity<?> boardList(@PathVariable("boardType") String boardType){
        try {
            List<BoardDto> list = boardService.boardList(boardType);
            if(list != null && !list.isEmpty()) {
                return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    
    @ApiOperation(value = "게시글 등록", notes = "게시글을 등록합니다.")
    @ApiResponses({@ApiResponse(code=200, message = "게시글 등록 OK"), @ApiResponse(code=500, message = "서버에러")})
    @PostMapping
    public ResponseEntity<?> boardWrite(@RequestBody BoardDto boardDto){
        logger.debug("write board :::" + boardDto.toString());
        try{
            boardService.boardWrite(boardDto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    @ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제합니다.")
    @ApiResponses({@ApiResponse(code=200, message = "게시글 삭제 OK"), @ApiResponse(code=500, message = "서버에러")})
    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> boardDelete(@PathVariable("boardId") int boardId){
        logger.debug("delete boardId :::" + boardId);
        try{
            boardService.boardDelete(boardId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception e){
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "게시글 상세", notes = "게시글을 확인합니다.")
    @ApiResponses({@ApiResponse(code=200, message = "게시글 상세보기 OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/{boardId}")
    public ResponseEntity<?> boardDetail(@PathVariable("boardId") int boardId){
        logger.debug("board detail :::" + boardId);
        try{
            BoardDto boardDto = boardService.boardDetail(boardId);
            if(boardDto != null){
                return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return exceptionHandling(e);
        }
    }
    @ApiOperation(value = "게시글 수정", notes = "게시글을 수정합니다.")
    @ApiResponses({@ApiResponse(code=200, message = "게시글 수정하기 OK"), @ApiResponse(code=500, message = "서버에러")})
    @PutMapping
    public ResponseEntity<?> boardUpdate(@RequestBody BoardDto boardDto){
        logger.debug("board update ::: " + boardDto);
        try{
            boardService.boardUpdate(boardDto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception e){
            return exceptionHandling(e);
        }

    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
