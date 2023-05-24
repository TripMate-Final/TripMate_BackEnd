package com.ssafy.plan.controller;

import com.ssafy.attraction.controller.AttractionController;
import com.ssafy.plan.model.*;
import com.ssafy.plan.model.service.PlanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plan")
@CrossOrigin("*")
public class PlanController {
    private static final Logger logger =  LoggerFactory.getLogger(AttractionController.class);
    PlanService planService;
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    @ApiOperation(value = "계획 등록", notes = "계획 추가하기.")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @PostMapping("/regist")
    public ResponseEntity<?> planRegist(@RequestBody PlanListDto planList){
        try {
            planService.planRegist(planList);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    @ApiOperation(value = "계획 보기", notes = "계획 보여줌.")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/{planId}")
    public ResponseEntity<?> planView(@PathVariable("planId") int planId){
        try {
            List<GetPlanDto> getList = planService.planView(planId);
            List<PlanViewDto> viewList = new ArrayList<>();
            PlanViewListDto planViewListDto = new PlanViewListDto();
            String title = "";
            int planLength = -1;
            int currentDay = -1;
            PlanViewDto planViewDto = null;
            for(GetPlanDto getPlanDto : getList){
                logger.debug(getPlanDto.toString());
                int day = getPlanDto.getPlanDay();
                if(day != currentDay){
                    if(planViewDto != null){
                        viewList.add(planViewDto);
                    }
                    planViewDto = new PlanViewDto();
                    planViewDto.setDay(day);
                    planViewDto.setElements(new ArrayList<>());
                    currentDay = day;
                    title = getPlanDto.getPlanTitle();
                    planLength = getPlanDto.getPlanLength();
                }
                ContentDto contentDto = new ContentDto();
                contentDto.setContentId(getPlanDto.getContentId());
                contentDto.setTitle(getPlanDto.getTitle());
                contentDto.setFirstImage(getPlanDto.getFirstImage());
                contentDto.setAddr1(getPlanDto.getAddr1());
                contentDto.setLatitude(getPlanDto.getLatitude());
                contentDto.setLongitude(getPlanDto.getLongitude());
                contentDto.setSidoName(getPlanDto.getSidoName());
                contentDto.setGugunName(getPlanDto.getGugunName());
                contentDto.setCategoryName(getPlanDto.getCategoryName());
                contentDto.setCat1Name(getPlanDto.getCat1Name());
                contentDto.setCat2Name(getPlanDto.getCat2Name());
                contentDto.setCat3Name(getPlanDto.getCat3Name());
                contentDto.setLikeCnt(getPlanDto.getLikeCnt());
                logger.debug(contentDto.toString());
                planViewDto.getElements().add(contentDto);
            }
            if(planViewDto != null){
                viewList.add(planViewDto);
            }
            logger.debug(planViewDto.toString());
            planViewListDto.setPlanId(planId);
            planViewListDto.setPlanTitle(title);
            planViewListDto.setPlanLength(planLength);
            planViewListDto.setPlanList(viewList);
            logger.debug(planViewListDto.toString());
            if(planViewListDto != null) {
                return new ResponseEntity<PlanViewListDto>(planViewListDto, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "나의 모든 계획 보기", notes = "모든계획 보여줌.")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @GetMapping("/list/{userId}")
    public ResponseEntity<?> planListAll(@PathVariable("userId") String userId){
        try {
            List<PlanDto> list = planService.planListAll(userId);

            if(list != null && !list.isEmpty()) {
                return new ResponseEntity<List<PlanDto>>(list, HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "플랜 삭제", notes = "플랜삭제.")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @DeleteMapping("/")
    public ResponseEntity<?> planListAll(PlanDeleteDto planDeleteDto){
        try {
            planService.planDelete(planDeleteDto);
            if(planService.planCountUser(planDeleteDto.getPlanId()) == 0)
                planService.planDeleteAll(planDeleteDto.getPlanId());
            return new ResponseEntity<List<PlanDto>>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "플랜 친구공유", notes = "플랜 친구에게 공유 요청 보내기.")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @PostMapping("/request")
    public ResponseEntity<?> planShare(@RequestBody PlanShareDto planshareDto){
        try {
            planService.planShare(planshareDto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "플랜 공유 수락 ", notes = "플랜 공유 수락받고 나에게도 보이기")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @PostMapping("/accept")
    public ResponseEntity<?> planShareOk(@RequestBody PlanShareDto planshareDto){
        try {
            planService.planShareOk(planshareDto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
