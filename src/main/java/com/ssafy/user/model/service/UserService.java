package com.ssafy.user.model.service;

import java.util.List;

import com.ssafy.user.model.UserDto;

public interface UserService {
	int userIdCheck(String userId) throws Exception;
	UserDto userLogin(UserDto userDto) throws Exception;
	void userRegist(UserDto userDto) throws Exception;
	UserDto userChangePassword(UserDto userDto) throws Exception;
	void userDelete(UserDto userDto) throws Exception;
	void userUpdate(UserDto userDto) throws Exception;
	void friendRequest() throws Exception;
	void friendAccept() throws Exception;
	void friendDelete() throws Exception;
	List<String> friendList() throws Exception;
}
