package com.ssafy.user.model.mapper;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.UserLikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
	public UserDto userInfo(String userId) throws SQLException;
	UserDto userLogin(UserDto userDto) throws SQLException;
	void userRegist(UserDto userDto) throws SQLException;
	UserDto userFindPassword(Map<String , String> map) throws SQLException;
	void userDelete(UserDto userDto) throws SQLException;
	UserDto userUpdate(UserDto userDto) throws SQLException;
	void friendRequest(Map<String , String> map) throws SQLException;
	void friendAccept(Map<String , String> map) throws SQLException;
	void friendDelete(Map<String , String> map) throws SQLException;
	List<String> friendList(String userId) throws SQLException;
	void userLike(UserLikeDto userLikeDto) throws SQLException;
	void updateAttractionLike(UserLikeDto userLikeDto) throws  SQLException;

	void saveRefreshToken(Map<String, String> map) throws SQLException;
	Object getRefreshToken(String userId) throws SQLException;
	void deleteRefreshToken(Map<String, String> map) throws SQLException;

}
