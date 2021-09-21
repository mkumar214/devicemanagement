package com.khooju.auth.controller.request.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUp {
	@NotBlank
	@Size(min = 4, max = 40)
	private String name;
	@NotBlank
	private String username;
	@NotBlank
	@Size(max = 100)
	@Email
	private String email;
	@NotBlank
	private String contactNumber;
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;
	
	@NotBlank
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "SignUp [name=" + name + ", username=" + username + ", email=" + email + ", contactNumber="
				+ contactNumber + ", role=" + role + "]";
	}
}
