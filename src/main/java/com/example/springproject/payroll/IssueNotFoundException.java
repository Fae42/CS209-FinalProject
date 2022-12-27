package com.example.springproject.payroll;

public class IssueNotFoundException extends RuntimeException {
	public IssueNotFoundException(Long id) {
		super("Could not find issue " + id);
	}
}
