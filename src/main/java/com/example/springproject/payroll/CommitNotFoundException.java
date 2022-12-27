package com.example.springproject.payroll;

public class CommitNotFoundException extends RuntimeException {
	public CommitNotFoundException(Long id) {
		super("Could not find commit " + id);
	}
}
