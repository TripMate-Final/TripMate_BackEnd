package com.ssafy.user.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.user.model.UserDto;

public interface UserService {
	int userIdCheck(String userId) throws Exception;
	UserDto userLogin(UserDto userDto) throws Exception;
	void userRegist(UserDto userDto) throws Exception;
	UserDto userFindPassword(Map<String , String> map) throws Exception;
	void userDelete(UserDto userDto) throws Exception;
	void userUpdate(UserDto userDto) throws Exception;
	void friendRequest(Map<String , String> map) throws Exception;
	void friendAccept(Map<String , String> map) throws Exception;
	void friendDelete(Map<String , String> map) throws Exception;
	List<String> friendList(String UserId) throws Exception;
}
