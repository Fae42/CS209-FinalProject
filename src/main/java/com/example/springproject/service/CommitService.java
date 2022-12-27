package com.example.springproject.service;

public interface CommitService {
	public void update(String owner, String repoName, long repoID);
	public void delete(long repoID);
}
