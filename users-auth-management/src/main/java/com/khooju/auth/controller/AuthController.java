package com.khooju.auth.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.khooju.auth.controller.exception.ResourceNotFoundException;
import com.khooju.auth.controller.request.dto.LoginRequest;
import com.khooju.auth.controller.request.dto.SignUp;
import com.khooju.auth.controller.response.dto.ApiResponse;
import com.khooju.auth.controller.response.dto.JwtAuthenticationResponse;
import com.khooju.auth.db.model.Roles;
import com.khooju.auth.db.model.Users;
import com.khooju.auth.repository.RolesRepository;
import com.khooju.auth.repository.UserRepository;
import com.khooju.auth.service.impl.UserDetailsImpl;
import com.khooju.auth.utils.JwtUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This controller handles all the
 * 
 * @author mukesh
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Api(description = "This is authentication handler api")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RolesRepository rolesRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtils jwtUtils;

	@ApiOperation(value = "Authenticate user in the system and if user successful the return authentication token")
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginRequest.getUsernameOrEmailOrPhonenumber(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUp signUp) {

		if (userRepo.existsByEmailid(signUp.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}

		if (userRepo.existsByUsername(signUp.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "username already in use!"), HttpStatus.BAD_REQUEST);
		}

		// Create a new User

		Users user = new Users(signUp.getUsername(), passwordEncoder.encode(signUp.getPassword()), signUp.getEmail(),
				null, null);
		Optional<Roles> roles = rolesRepo.findByRolename(signUp.getRole());
		if (roles.isEmpty()) {
			return new ResponseEntity(new ResourceNotFoundException("Roles not found"), HttpStatus.BAD_GATEWAY);
		}
		user.setRoles(Collections.singleton(roles.get()));
		Users savedUser = userRepo.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
				.buildAndExpand(savedUser.getUsername()).toUri();

		return ResponseEntity.ok(savedUser);
	}

}
