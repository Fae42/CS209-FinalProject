package com.example.springproject.service;

import com.example.springproject.domain.Issue;

import java.util.List;

public interface IssueService {
	
	public void update(String owner, String repoName, long repoID);
	public long countOpen();
	public long countClose();
	public long getAvgSolveTime();
	public long getMaxSolveTime();
	public long getMinSolveTime();
	public void delete(long repoID);
	public List<Issue> findAll();
}
