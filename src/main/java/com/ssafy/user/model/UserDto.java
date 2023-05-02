package com.ssafy.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserDto (회원정보)", description = "회원 정보를 가진 Class")
public class UserDto {
	@ApiModelProperty(value = "회원 아이디")
	private String userId;
	@ApiModelProperty(value = "회원 이메일")
	private String userEmail;
	@ApiModelProperty(value = "회원 이름")
	private String userName;
	@ApiModelProperty(value = "회원 비밀번호")
	private String userPassword;
	@ApiModelProperty(value = "회원 타입")
	private String userPosition;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userEmail=" + userEmail + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userPosition=" + userPosition + "]";
	}
}