package com.example.demo.exception;

public class CustomizeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CustomizeException(Exception e) {
		super(e);
	}

}
