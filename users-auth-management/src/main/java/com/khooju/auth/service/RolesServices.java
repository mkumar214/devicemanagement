package com.khooju.auth.service;

import com.khooju.auth.db.model.Roles;

/**
 * This component is for managing the Roles
 * @author mukesh
 *
 */
public interface RolesServices {

	/**
	 * This method is saves new roles in the database.
	 * @param roles
	 * @return
	 */
	Roles create(Roles roles); 
}
