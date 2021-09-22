package com.khooju.auth.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is global exception handler class.This is a advice which execute when any exception raised in the system.
 * @author mukesh
 *
 */
@Controller
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * This is authentication exception handler class.
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = UsernameNotFoundException.class)
	public ResponseEntity<Object> handleAuthException(UsernameNotFoundException ex){
				return new ResponseEntity<Object>(ex,HttpStatus.NOT_FOUND);
	}
}
