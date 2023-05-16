package com.ssafy.comment.controller;

import com.ssafy.comment.model.CommentDto;
import com.ssafy.comment.model.service.CommentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "댓글 목록", notes = "댓글 목록 보여줌.")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/{commentId}")
    public ResponseEntity<?> commentListAll(@PathVariable("commentId") int commentId){
        System.out.println(commentId);
        try {
            List<CommentDto> list = commentService.commentListAll(commentId);
            System.out.println(list.get(0).toString());
            if(list != null && !list.isEmpty()) {
                return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
