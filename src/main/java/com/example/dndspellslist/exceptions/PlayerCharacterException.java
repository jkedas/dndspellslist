package com.example.dndspellslist.exceptions;


public class PlayerCharacterException extends RuntimeException	{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayerCharacterException(String message) {
        super(message);
    }

    public PlayerCharacterException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
