package com.khooju.auth.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khooju.auth.controller.RolesController;
import com.khooju.auth.db.model.Roles;
import com.khooju.auth.repository.RolesRepository;
import com.khooju.auth.service.RolesServices;

@Service
public class RolesServiceImpl implements RolesServices {

	Logger log = LoggerFactory.getLogger(RolesServiceImpl.class);
	
	@Autowired
	RolesRepository rolesRepository;

	@Override
	public Roles create(Roles roles) {
		log.info("{} is under process", roles);
		return rolesRepository.save(roles);
	}

	@Override
	public List<Roles> fetchAllRoles() {
		log.info("fetching all the roles from DB");
		return rolesRepository.findAll();
	}

}
