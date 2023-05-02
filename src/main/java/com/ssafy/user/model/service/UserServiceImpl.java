package com.ssafy.user.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public UserDto userLogin(Map<String, String> map) throws Exception {
		return userMapper.userLogin(map);
	}
}
