package com.dream.thoughts.springblogrestapi.exceptions;

public class BlogNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public BlogNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public BlogNotFoundException() {
	}
}
