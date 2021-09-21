package com.khooju.auth.db.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * This class hold the user address. This has many to one relationship with the user.
 * @author mukesh
 *
 */
@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class UserAddress {

	
	/**
	 * This field is used for storing street 1 address. e.g. flat no - 402,tower - n/2, jaypee aman
	 */
	@Column
	private String street1;
	
	/**
	 * This field store the extra information.
	 */
	@Column
	private String street2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private String pincode;
	@Column
	private String addressType;
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	
	
	
}
