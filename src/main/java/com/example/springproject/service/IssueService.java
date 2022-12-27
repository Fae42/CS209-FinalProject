package com.example.springproject.service;

import com.example.springproject.domain.Issue;

import java.util.Date;
import java.util.List;

public interface IssueService {
	
	public void update(String owner, String repoName, long repoID);
	public long countOpen();
	public long countClose();
	public String getAvgSolveTime();
	public String getMaxSolveTime();
	public String getMinSolveTime();
	public void delete(long repoID);
	public List<Issue> findAll();
}
