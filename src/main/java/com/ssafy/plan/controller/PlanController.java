package com.ssafy.plan.controller;

import com.ssafy.plan.model.PlanDeleteDto;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.PlanListDto;
import com.ssafy.plan.model.PlanViewDto;
import com.ssafy.plan.model.service.PlanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
@CrossOrigin("*")
public class PlanController {
    PlanService planService;
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @ApiOperation(value = "계획 등록", notes = "계획 추가하기.")
    @ApiResponses({@ApiResponse(code=200, message = "OK"), @ApiResponse(code=500, message = "서버에러")})
    @PostMapping("/{planList}")
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
            List<PlanViewDto> list = planService.planView(planId);
            if(list != null && !list.isEmpty()) {
                return new ResponseEntity<List<PlanViewDto>>(list, HttpStatus.OK);
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

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
