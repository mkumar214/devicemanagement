package com.khooju.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.khooju.auth.db.model.Users;
import com.khooju.auth.repository.UserRepository;

/**
 * This class implement {@link UserDetailsService} and overriding the loadUserByUsername method.+
 * @author mukesh
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;

	/**
	 * This method return the user if userfound in the database otherwise this throws the exception.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("{} is serching in the db",username);
		Users user = userRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Please check the username, phonenumber or email-id"));
		return UserDetailsImpl.build(user);
	}

}
