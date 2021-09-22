package com.khooju.auth.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khooju.auth.db.model.Roles;
import com.khooju.auth.service.RolesServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api")
@Api(description = "These  api manage roles operations")
public class RolesController {

	Logger log = LoggerFactory.getLogger(RolesController.class);
	

	@Autowired
	RolesServices rolesServices;
	
	@PostMapping(value = "/roles/create")
	@ResponseBody
	@ApiOperation(value = "add a new roles in the database")
	public Roles add(Roles rolesRequest){
		log.info("Request received for saving {}",rolesRequest);
		return rolesServices.create(rolesRequest);
	}
	
	
	@GetMapping(value = "/roles/findall")
	@ResponseBody
	@ApiOperation(value = "get all roles from the database")
	public List<Roles> fetchAll(){
		return rolesServices.fetchAllRoles();
	}
}
