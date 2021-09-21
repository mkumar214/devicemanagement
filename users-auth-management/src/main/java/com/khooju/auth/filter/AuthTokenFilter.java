package com.khooju.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.khooju.auth.contants.AppConstant;
import com.khooju.auth.service.impl.UserDetailsServiceImpl;
import com.khooju.auth.utils.JwtUtils;

/**
 * This filter is overriding the method of {@link OncePerRequestFilter} for only one execution in the lifetime of the request
 * @author mukesh
 *
 */
public class AuthTokenFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtils jwtUtils = null;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
		String token = parseJwt(request);
		if(!StringUtils.isEmpty(token) && jwtUtils.validateJwtTokens(token)) {
			String username = jwtUtils.getUserNameFromJwtToken(token);
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			//setting source in the UsernamePasswordAuthenticationToken
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		}catch (Exception e) {
			logger.error("Can not set user authentication {}",e);
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	private String parseJwt(HttpServletRequest request) {
		String authToken = request.getHeader(AppConstant.Http.AUTHORISATION);
		//If token is not empty and token start with the word bearer.
		if(StringUtils.hasText(authToken) && authToken.startsWith(AppConstant.Http.BEARER)) {
			//split the token from the index 7 to remove the bearer token.
			return authToken.substring(7, authToken.length());
		}
		return null;
	}

}
