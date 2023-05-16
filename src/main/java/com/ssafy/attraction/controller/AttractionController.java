package com.ssafy.attraction.controller;

import com.ssafy.attraction.model.AttractionListDto;
import com.ssafy.attraction.model.service.AttractionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attraction")
@CrossOrigin("*")
public class AttractionController {
    private static final Logger logger =  LoggerFactory.getLogger(AttractionController.class);

    private AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @ApiOperation(value = "관광지 목록 전체", notes = "관광지 목록 전체를 보여줍니다.")
    @ApiResponses({@ApiResponse(code=200, message = "관광지 목록 전체 OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/list")
    public ResponseEntity<?> attractionListAll(){
        try{
            List<AttractionListDto> list = attractionService.attractionListAll();
            if(list != null && !list.isEmpty()){
                return new ResponseEntity<List<AttractionListDto>>(list,HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return exceptionHandling(e);
        }
    }
    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
