package com.khooju.auth.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LoginHistory extends Identifier{


	
	@Column
	private Date lastPasswordChange;
	
	@Column
	private Date lastSuccessFullLogin;
	
	@Column
	private String device;
	
	@Column
	private boolean isActiveDevice;
	
	/**
	 * This field hold the user information by whom this entity is associated
	 */
	@ManyToOne
	private Users user;
	

	public Date getLastPasswordChange() {
		return lastPasswordChange;
	}
	public void setLastPasswordChange(Date lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}
	public Date getLastSuccessFullLogin() {
		return lastSuccessFullLogin;
	}
	public void setLastSuccessFullLogin(Date lastSuccessFullLogin) {
		this.lastSuccessFullLogin = lastSuccessFullLogin;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public boolean isActiveDevice() {
		return isActiveDevice;
	}
	public void setActiveDevice(boolean isActiveDevice) {
		this.isActiveDevice = isActiveDevice;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
}
