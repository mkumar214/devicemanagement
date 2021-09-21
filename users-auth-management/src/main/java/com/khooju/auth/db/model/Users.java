package com.khooju.auth.db.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * This entity represent the user.
 * 
 * @author mukesh
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Users extends Auditable<String> {

	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String emailid;
	@Column
	private String contactNumber;

	/**
	 * User have many to many relationship with the roles.This can be understood as
	 * like multiple user have same role and multiple roles can be assigned to the
	 * single user.
	 * 
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles = new HashSet<Roles>();
	
	@ElementCollection
	private List<UserAddress> addresses = new ArrayList<UserAddress>();

	public Users() {
		super();
	}
	

	public Users(String username, String password, String emailid, String contactNumber, Set<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.contactNumber = contactNumber;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}


	public List<UserAddress> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<UserAddress> addresses) {
		this.addresses = addresses;
	}

}
