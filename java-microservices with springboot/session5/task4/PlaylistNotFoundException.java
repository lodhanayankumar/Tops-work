package com.example.userprofileservice;

public class PlaylistNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlaylistNotFoundException(String message) {
        super(message);
    }
}
