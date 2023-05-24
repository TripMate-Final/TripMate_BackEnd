package com.ssafy.user.model.service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.UserLikeDto;

import java.util.List;
import java.util.Map;

public interface UserService {
	public UserDto userInfo(String userId) throws Exception;
	UserDto userLogin(UserDto userDto) throws Exception;
	void userRegist(UserDto userDto) throws Exception;
	UserDto userFindPassword(Map<String , String> map) throws Exception;
	void userDelete(UserDto userDto) throws Exception;
	void userUpdate(UserDto userDto) throws Exception;
	void friendRequest(Map<String , String> map) throws Exception;
	void friendAccept(Map<String , String> map) throws Exception;
	void friendDelete(Map<String , String> map) throws Exception;
	List<String> friendList(String UserId) throws Exception;
	void userLike(UserLikeDto userLikeDto) throws Exception;

	void saveRefreshToken(String userid, String refreshToken) throws Exception;
	Object getRefreshToken(String userid) throws Exception;
	void deleRefreshToken(String userid) throws Exception;
}
