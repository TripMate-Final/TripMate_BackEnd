package com.ssafy.user.controller;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.UserFindDto;
import com.ssafy.user.model.UserLikeDto;
import com.ssafy.user.model.service.JwtServiceImpl;
import com.ssafy.user.model.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private final UserService userService;
	private JwtServiceImpl jwtService;

	public UserController(UserService userService, JwtServiceImpl jwtService) {
		this.userService = userService;
		this.jwtService = jwtService;
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userId") String userId,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDto userDto = userService.userInfo(userId);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	@ApiOperation(value = "회원로그인" , notes = "회원을 로그인합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "회원로그인 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@PostMapping(value = "/login")
	public ResponseEntity<?> userLogin(@RequestBody UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println(userDto.toString());
		try {
			UserDto loginUser = userService.userLogin(userDto);
			if (loginUser != null) {
				String accessToken = jwtService.createAccessToken("userId", loginUser.getUserId());// key, data
				String refreshToken = jwtService.createRefreshToken("userId", loginUser.getUserId());// key, data
				userService.saveRefreshToken(userDto.getUserId(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//		try {
//			userDto = userService.userLogin(userDto);
//			System.out.println(userDto);
//			if(userDto != null) {
//				return new ResponseEntity<UserDto>(userDto , HttpStatus.OK);
//			}
//			else
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
	}

	@ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		System.out.println(1234 + " " + userDto.toString());
		logger.debug("token : {}, userDto : {}", token, userDto);
		if (jwtService.checkToken(token)) {
			if (token.equals(userService.getRefreshToken(userDto.getUserId()))) {
				String accessToken = jwtService.createAccessToken("userid", userDto.getUserId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
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
	public ResponseEntity<?> userDelete(@PathVariable("userId") String userId){
		try {
			userService.userDelete(userId);
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
	@PostMapping(value = "/accept/{friend_id}")
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

	@ApiOperation(value = "친구추가 요청" , notes = "친구 요청을 합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "친구 요청 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@PostMapping(value = "/request/{friend_id}")
	public ResponseEntity<?> friendRequest(HttpSession session , @PathVariable("friend_id") String friendId){
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		Map<String , String> map = new HashMap<>();
		map.put("userId" , friendId);
		map.put("friendId" , userDto.getUserId());

		try {
			userService.friendRequest(map);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "친구삭제" , notes = "친구관계를 삭제합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "친구 삭제 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@DeleteMapping(value = "/delete/{friend_id}")
	public ResponseEntity<?> friendDelete(HttpSession session , @PathVariable("friend_id") String friendId){
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		Map<String , String> map = new HashMap<>();
		map.put("userId" , friendId);
		map.put("friendId" , userDto.getUserId());

		try {
			userService.friendDelete(map);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "친구목록보기" , notes = "친구목록을 확인합니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "친구 삭제 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@GetMapping(value = "/list")
	public ResponseEntity<?> friendList(HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		try {
			List<String> friendList = userService.friendList(userDto.getUserId());
			return new ResponseEntity<List>(friendList , HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "비밀번호 찾기" , notes = "비밀번호를 등록된 email로 보내줍니다")
	@ApiResponses({@ApiResponse(code = 200 , message = "비밀번호 찾기 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@PutMapping(value = "/find")
	public ResponseEntity<?> userPasswordFind(@RequestBody UserFindDto userFindDto){
		System.out.println(userFindDto);
		try {
			UserDto userDto = userService.userFindPassword(userFindDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "좋아요 누르기" , notes = "좋아요 올리기")
	@ApiResponses({@ApiResponse(code = 200 , message = "친구 요청 OK") , @ApiResponse(code = 500 , message = "서버에러")})
	@PostMapping(value = "/like")
	public ResponseEntity<?> userLike(@RequestBody UserLikeDto userLikeDto){
		try {
			userService.userLike(userLikeDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{userId}")
	public ResponseEntity<?> removeToken(@PathVariable("userId") String userId) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleRefreshToken(userId);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}




	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}