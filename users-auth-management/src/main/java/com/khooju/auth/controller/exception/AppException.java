package com.khooju.auth.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is a runtime exception.This throws when some unexpected situtation occured in the system.
 * There are different HTTP code for the different different exception.
 * @author mukesh
 *
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {

	public AppException(String message) {
		super(message);
	}
	
	public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
