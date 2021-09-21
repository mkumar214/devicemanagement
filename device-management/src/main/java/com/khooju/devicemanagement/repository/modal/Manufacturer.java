package com.khooju.devicemanagement.repository.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author mukesh
 *This entity contains the information of the device manufacturer.
 */
@Entity
@Table(name="device_manufacturer")
public class Manufacturer extends Identifier{

	@Column
	private String name;
	
	/**
	 * This field is used for a unique identifier which is allocated by the goverment to manufacturer.
	 */
	
	@Column
	private String uniqueNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniqueNumber() {
		return uniqueNumber;
	}
	public void setUniqueNumber(String uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}
	
	@Override
	public String toString() {
		return "Manufacturer [name=" + name + ", uniqueNumber=" + uniqueNumber + "]";
	}
	
	
	
	
}
