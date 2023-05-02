package com.ssafy.user.model.service;

import java.util.Map;

import com.ssafy.user.model.UserDto;

public interface UserService {
	UserDto userLogin(Map<String , String> map) throws Exception;
}
