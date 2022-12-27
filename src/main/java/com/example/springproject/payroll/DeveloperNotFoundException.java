package com.example.springproject.payroll;

public class DeveloperNotFoundException extends RuntimeException {
	public DeveloperNotFoundException(Long id) {
		super("Could not find developer " + id);
	}
}
