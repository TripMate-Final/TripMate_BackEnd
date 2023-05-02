package com.ssafy.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserDto (회원정보)", description = "회원 정보를 가진 Class")
public class UserDto {
	private String user_id;
	@ApiModelProperty(value = "회원 아이디")
	private String user_auth_id;
	private String user_email;
	private String user_name;
	@ApiModelProperty(value = "회원 비밀번호")
	private String user_password;
	private String user_position;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_auth_id() {
		return user_auth_id;
	}
	public void setUser_auth_id(String user_auth_id) {
		this.user_auth_id = user_auth_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_position() {
		return user_position;
	}
	public void setUser_position(String user_position) {
		this.user_position = user_position;
	}
}
