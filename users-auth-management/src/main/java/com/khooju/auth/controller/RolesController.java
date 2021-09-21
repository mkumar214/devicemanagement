package com.khooju.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khooju.auth.db.model.Roles;

@Controller
@RequestMapping("/api")
public class RolesController {

	@PostMapping(value = "/roles/create")
	public ResponseEntity<Roles> post(Roles rolesRequest){
		return null;
	}
	
	
	@GetMapping(value = "/roles/all")
	public ResponseEntity<Roles> get(Roles rolesRequest){
		return null;
	}
}
