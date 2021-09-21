package com.khooju.auth.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khooju.auth.db.model.Users;

/**
 * We are overriding the default implementation of the {@link UserDetails} for more information in the DTO. 
 * @author mukesh
 *
 */
public class UserDetailsImpl implements UserDetails {

	private Long id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;
	
	
	
	private Collection<? extends GrantedAuthority> authorities;
	public UserDetailsImpl(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	public static UserDetailsImpl build(Users user) {
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRolename()))
				.collect(Collectors.toList());
		
		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmailid(),
				user.getPassword(), 
				authorities);
	}
}
