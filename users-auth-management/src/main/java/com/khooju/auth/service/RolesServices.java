package com.khooju.auth.service;

import java.util.List;

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

	/**
	 * 
	 * @return all the roles saved in the DB
	 */
	List<Roles> fetchAllRoles();

	
}
