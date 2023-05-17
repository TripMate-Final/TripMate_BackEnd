package com.ssafy.recommendation.controller;

import com.ssafy.recommendation.model.RecommendationListDto;
import com.ssafy.recommendation.model.service.RecommendationService;
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
@RequestMapping("/recommend")
@CrossOrigin("*")
public class RecommendationController {
    private static final Logger logger =  LoggerFactory.getLogger(RecommendationController.class);

    private RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @ApiOperation(value = "추천 관광지 목록", notes = "추천 관광지 목록을 보여줍니다")
    @ApiResponses({@ApiResponse(code=200, message = "관광지 추천 목록 OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/{contentId}")
    public ResponseEntity<?> recommendList(@PathVariable("contentId") int contentId){
        try{
            List<RecommendationListDto> list = recommendationService.recommendList(contentId);
            if(list != null && !list.isEmpty()){
                return new ResponseEntity<List<RecommendationListDto>>(list,HttpStatus.OK);
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
