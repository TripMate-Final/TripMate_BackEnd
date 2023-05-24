package com.ssafy.user.model.service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.UserFindDto;
import com.ssafy.user.model.UserLikeDto;
import com.ssafy.user.model.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


	private UserMapper userMapper;
	private SqlSession sqlSession;

	public UserServiceImpl(UserMapper userMapper, SqlSession sqlSession) {
		this.userMapper = userMapper;
		this.sqlSession = sqlSession;
	}


	@Override
	public UserDto userInfo(String userId) throws Exception {
		return sqlSession.getMapper(UserMapper.class).userInfo(userId);
	}

	@Override
	public UserDto userLogin(UserDto userdto) throws Exception {
		return userMapper.userLogin(userdto);
	}

	@Override
	public void userRegist(UserDto userDto) throws Exception {
		userMapper.userRegist(userDto);
	}

	@Override
	public UserDto userFindPassword(UserFindDto userFindDto) throws Exception {
		return userMapper.userFindPassword(userFindDto);
	}

	@Override
	public void userDelete(String userId) throws Exception {
		userMapper.userDelete(userId);
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
	@Override
	public void userLike(UserLikeDto userLikeDto) throws Exception {
		userMapper.userLike(userLikeDto);
	}

	@Override
	public void updateAttractionLike(UserLikeDto userLikeDto) throws Exception {
		userMapper.updateAttractionLike(userLikeDto);
	}

	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		sqlSession.getMapper(UserMapper.class).saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return sqlSession.getMapper(UserMapper.class).getRefreshToken(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		sqlSession.getMapper(UserMapper.class).deleteRefreshToken(map);
	}
}

