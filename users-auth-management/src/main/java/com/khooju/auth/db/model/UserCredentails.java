package com.khooju.auth.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This entity is used for tracking the account verification,
 * 
 * @author mukesh
 *
 */
@Entity
public class UserCredentails extends Identifier {

	@Id
	private int id;
	@Column
	private boolean emailVerified;
	@Column
	private boolean contactVerified;
	@Column
	private int failedLoginAttempt;
	@Column
	private boolean isAccountLocked;
	@Column
	private Date lastValidLogin;

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isContactVerified() {
		return contactVerified;
	}

	public void setContactVerified(boolean contactVerified) {
		this.contactVerified = contactVerified;
	}

	public int getFailedLoginAttempt() {
		return failedLoginAttempt;
	}

	public void setFailedLoginAttempt(int failedLoginAttempt) {
		this.failedLoginAttempt = failedLoginAttempt;
	}

	public boolean isAccountLocked() {
		return isAccountLocked;
	}

	public void setAccountLocked(boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}

	public Date getLastValidLogin() {
		return lastValidLogin;
	}

	public void setLastValidLogin(Date lastValidLogin) {
		this.lastValidLogin = lastValidLogin;
	}

}
