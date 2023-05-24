package com.ssafy.attraction.controller;

import com.ssafy.attraction.model.*;
import com.ssafy.attraction.model.service.AttractionService;
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
@RequestMapping("/attraction")
@CrossOrigin("*")
public class AttractionController {
    private static final Logger logger =  LoggerFactory.getLogger(AttractionController.class);

    private AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @ApiOperation(value = "관광지 리스트", notes = "관광지 목록 전체를 보여줍니다.")
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
    @ApiOperation(value = "관광지 미리보기", notes = "관광지 ")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/preview/{contentId}")
    public ResponseEntity<?> attractionPreview(@PathVariable("contentId") int contentId){
        try{
            AttractionPreviewDto attractionPreviewDto = attractionService.attractionPreview(contentId);
            if (attractionPreviewDto != null) {
                return new ResponseEntity<AttractionPreviewDto>(attractionPreviewDto,HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return exceptionHandling(e);
        }
    }

//    @ApiOperation(value = "관광지 검색", notes = "관광지 검색.")
//    @ApiResponses({@ApiResponse(code=200, message = "관광지 검색 OK"), @ApiResponse(code=500, message = "서버에러")})
//    @PostMapping("/select")
//    public ResponseEntity<?> attractionSelect(@RequestBody AttractionSelectDto attractionSelectDto){
//        try{
//            List<AttractionFilterDto> list = attractionService.attractionSelect(attractionSelectDto);
//            if(list != null && !list.isEmpty()){
//                return new ResponseEntity<List<AttractionFilterDto>>(list,HttpStatus.OK);
//            }else{
//                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//            }
//        }catch (Exception e){
//            return exceptionHandling(e);
//        }
//    }


    @ApiOperation(value = "관광지 검색", notes = "관광지 검색.")
    @ApiResponses({@ApiResponse(code=200, message = "관광지 검색 OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/select")
    public ResponseEntity<?> attractionSelectOption(@RequestParam("keyword") String keyword,@RequestParam("categoryCode") int categoryCode , @RequestParam("page") int page){
        logger.debug(keyword  + ":::" + categoryCode + ":::" + page);
        try{
            AttractionSelectDto attractionSelectDto = new AttractionSelectDto(keyword,categoryCode , page * 15);
            logger.debug("select : " + attractionSelectDto);
            List<AttractionFilterDto> list = attractionService.attractionSelectOption(attractionSelectDto);
            if(list != null && !list.isEmpty()){
                return new ResponseEntity<List<AttractionFilterDto>>(list,HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "관광지 이미지 카드", notes = "관광지 상세정보를 보여줍니다.")
    @ApiResponses({@ApiResponse(code=200, message = "관광지 상세보기 OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/{contentId}")
    public ResponseEntity<?> attractionDetail(@PathVariable("contentId") int contentId){
        logger.debug("attraction detail :::" + contentId);
        try{
            AttractionDetailDto attractionDetailDto= attractionService.attractionDetail(contentId);
            if (attractionDetailDto != null) {
                attractionService.updateHit(contentId);
                return new ResponseEntity<AttractionDetailDto>(attractionDetailDto,HttpStatus.OK);
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
