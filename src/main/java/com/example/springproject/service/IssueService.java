package com.example.springproject.service;

import com.example.springproject.domain.Issue;

import java.util.Date;
import java.util.List;

public interface IssueService {
	
	public void update(String owner, String repoName, long repoID);
	public long countOpen();
	public long countClose();
	public Date getAvgSolveTime();
	public Date getMaxSolveTime();
	public Date getMinSolveTime();
	public void delete(long repoID);
	public List<Issue> findAll();
}
