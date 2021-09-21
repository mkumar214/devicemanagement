package com.khooju.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khooju.auth.db.model.Users;
/**
 * This repository contains all the crud operation methods.
 * @author mukesh
 *
 */
public interface UserRepository extends JpaRepository<Users, Long> {
	/**
	 * This method returns user by the name.If user not present then this method return optinal object with null value.
	 * @see Optional
	 * @param username
	 * @return
	 */
	Optional<Users> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmailid(String email);	
	
}
