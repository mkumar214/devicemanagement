package com.khooju.auth.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * This Entity is representation the user profile.
 * @author mukesh
 *
 */

@Entity
public class UserProfile extends Identifier{


	
	/**
	 * First name of the user.
	 */
	@Column
	private String firstName;
	

	/**
	 * Last name of the user.
	 */
	@Column
	private String lastName;
	/**
	 * gender of the user. Gender value will be male,female, transgender
	 */
	@Column
	private String gender;
	/**
	 * Date of the birth of the user.
	 */
	@Column
	private Date dOB;
	
	/**
	 * Age of the user.This is calculated on the basis of DOB.
	 */
	@Column
	private String age;
	
	@OneToOne
	private Users user;



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
