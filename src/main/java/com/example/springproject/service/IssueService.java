package com.example.springproject.service;

public interface IssueService {
	
	public void update(String owner, String repoName, long repoID);
	public long countOpen();
	public long countClose();
	public long getAvgSolveTime();
	public long getMaxSolveTime();
	public long getMinSolveTime();
	public void delete(long repoID);
}
