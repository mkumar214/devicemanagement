package com.khooju.auth;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.khooju.auth.service.impl.UserDetailsImpl;

/**
 * Implemented the AuditAware interface for storing the user information in the database table.
 * @author mukesh
 *
 */

public class SpringSecurityAuditorAware implements AuditorAware<String> {

	
	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		if(authentication== null || !authentication.isAuthenticated())
			return null;
		return Optional.ofNullable((String)authentication.getPrincipal());
	}

}
