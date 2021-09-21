package com.khooju.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khooju.auth.db.model.Roles;

/**
 * This repository defines the all the methods for the ro
 * 
 * @author mukesh
 *
 */

public interface RolesRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByRolename(String name);
}
