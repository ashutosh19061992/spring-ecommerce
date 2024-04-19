package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	private Integer id;

	public ResourceNotFoundException(String resourceName, Integer id) {
		super(String.format("%s not found with %d ", resourceName, id));
		this.resourceName = resourceName;
		this.id = id;
	}
}
