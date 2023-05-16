package com.ssafy.user.model.service;

import java.util.List;
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
	public UserDto userLogin(UserDto userdto) throws Exception {
		return userMapper.userLogin(userdto);
	}

	@Override
	public int userIdCheck(String userId) throws Exception {
		return userMapper.userIdCheck(userId);
	}

	@Override
	public void userRegist(UserDto userDto) throws Exception {
		userMapper.userRegist(userDto);
	}

	@Override
	public UserDto userFindPassword(Map<String , String> map) throws Exception {
		return userMapper.userFindPassword(map);
	}

	@Override
	public void userDelete(UserDto userDto) throws Exception {
		userMapper.userDelete(userDto);
	}

	@Override
	public void userUpdate(UserDto userDto) throws Exception {
		userMapper.userUpdate(userDto);
	}

	@Override
	public void friendRequest(Map<String , String> map) throws Exception {
		userMapper.friendRequest(map);
	}

	@Override
	public void friendAccept(Map<String , String> map) throws Exception {
		userMapper.friendAccept(map);
	}

	@Override
	public void friendDelete(Map<String , String> map) throws Exception {
		userMapper.friendDelete(map);
	}

	@Override
	public List<String> friendList(String userId) throws Exception {
		return userMapper.friendList(userId);
	}
}

