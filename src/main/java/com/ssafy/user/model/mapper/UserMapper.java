package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.UserDto;

@Mapper
public interface UserMapper {
	int userIdCheck(String userId) throws SQLException;
	UserDto userLogin(UserDto userDto) throws SQLException;
	void userRegist(UserDto userDto) throws SQLException;
	UserDto userChangePassword(UserDto userDto) throws SQLException;
	void userDelete(UserDto userDto) throws SQLException;
	UserDto userUpdate(UserDto userDto) throws SQLException;
	void friendRequest(Map<String , String> map) throws SQLException;
	void friendAccept(Map<String , String> map) throws SQLException;
	void friendDelete(Map<String , String> map) throws SQLException;
	List<String> friendList() throws SQLException;
}
