package com.khooju.devicemanagement.repository.modal;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This entity is for stroing the badic information of the device.
 * @author mukesh
 *
 */
@Entity
@Table(name = "devices")
public class Device extends Identifier{

	/**
	 * This is unique code which is used to identified the device
	 */
	@Column
	private String HScode;
	
	/**
	 * status of the device. e.g : Active,deactive
	 */
    @Column
	private String status;
	
	/**
	 * Device is always associated with the manufacturer
	 */

    @OneToMany
    private Set<Manufacturer> manufactures;
	
	public String getHScode() {
		return HScode;
	}
	public void setHScode(String hScode) {
		HScode = hScode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Manufacturer> getManufactures() {
		return manufactures;
	}
	public void setManufactures(Set<Manufacturer> manufactures) {
		this.manufactures = manufactures;
	}
	
	
	
}
