package com.example.dndspellslist.exceptions;

public class CustomUserDetailsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomUserDetailsException(String message) {
        super(message);
    }

    public CustomUserDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}
 

