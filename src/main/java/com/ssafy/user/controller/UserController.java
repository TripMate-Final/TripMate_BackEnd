package com.ssafy.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ApiOperation(value = "회원로그인" , notes = "회원을 로그인합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "회원로그인 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@PostMapping(value = "/login")
	public ResponseEntity<?> userLogin(@RequestBody UserDto userDto , HttpSession session) {
		logger.debug("userRegister memberDto : {}", userDto);
		System.out.println(userDto.toString());
//		@PathVariable("userid") String userId;
		try {
			userDto = userService.userLogin(userDto);
			System.out.println(userDto);
			if(userDto != null) {
				session.setAttribute("userinfo", userDto);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "회원가입" , notes = "회원을 가입합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "회원가입 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@PostMapping(value = "/regist")
	public ResponseEntity<?> userRegist(@RequestBody UserDto userDto) {
		try {
			userService.userRegist(userDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}


	@ApiOperation(value = "회원삭제" , notes = "회원을 삭제합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "회원삭제 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> userDelete(HttpSession session){
		UserDto userDto= (UserDto) session.getAttribute("userinfo");
		try {
			userService.userDelete(userDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}


	@ApiOperation(value = "회원정보수정" , notes = "회원 정보를 수정합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "회원정보수정 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@PutMapping(value = "/update")
	public ResponseEntity<?> userUpdate(@RequestBody UserDto userDto){
		try {
			userService.userUpdate(userDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "친구추가 받기" , notes = "친구 추가를 수락합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "친구 추가 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@GetMapping(value = "/friend/{friend_id}")
	public ResponseEntity<?> friendAccept(HttpSession session , @PathVariable("friend_id") String friendId){

		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		System.out.println(userDto.getUserId() + " " + friendId);
		Map<String , String> map = new HashMap<>();
		map.put("userId" , userDto.getUserId());
		map.put("friendId" , friendId);

		try {
			userService.friendAccept(map);
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