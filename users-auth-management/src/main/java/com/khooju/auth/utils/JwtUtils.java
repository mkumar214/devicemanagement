package com.khooju.auth.utils;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.khooju.auth.service.impl.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * This utility class facilates with the method for token generation token etc.
 * @author mukesh
 *
 */
@Component
public class JwtUtils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${auth.app.jwtSecret}")
	private String jwtSecret;

	@Value("${auth.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(
				new Date((new Date()).getTime()+jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public boolean validateJwtTokens(String token) {
		try {
			 Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
			 return true;
		} catch (SignatureException se) {
			logger.error("Invalid JWT signature: {}", se.getMessage());
		}catch (MalformedJwtException me) {
			logger.error("Invalid JWT token: {}", me.getMessage());
		}catch (ExpiredJwtException ee) {
			logger.error("JWT token is expired: {}", ee.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}

	/**
	 * This method returns the username form the token.
	 * @param token
	 * @return
	 */
	public String getUserNameFromJwtToken(String token) {
		
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	
}
