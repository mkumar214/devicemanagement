package com.khooju.auth.controller.request.dto;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

	@NotBlank
	private String usernameOrEmailOrPhonenumber;
	
	@NotBlank
	private String password;
	
	public String getUsernameOrEmailOrPhonenumber() {
		return usernameOrEmailOrPhonenumber;
	}

	public void setUsernameOrEmailOrPhonenumber(String usernameOrEmailOrPhonenumber) {
		this.usernameOrEmailOrPhonenumber = usernameOrEmailOrPhonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [usernameOrEmailOrPhonenumber=" + usernameOrEmailOrPhonenumber + "]";
	}

	
}
