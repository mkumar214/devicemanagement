package com.khooju.auth.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This entity contains the roles which exist in the system.
 * @author mukesh
 *
 */
@Entity
@Table(name="system_roles")
public class Roles extends Identifier{

//TODO: Parent roles structure
	@Column
	private String rolename;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
}
