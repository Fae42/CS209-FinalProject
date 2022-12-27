package com.example.springproject.service;

import com.example.springproject.domain.Developer;

import java.util.List;

public interface DeveloperService {
	public void update(String owner, String repoName, long repoID);
	
	public List<Developer> findAll();
	public long countDevelopers();
	public void delete(long repoID);
}
