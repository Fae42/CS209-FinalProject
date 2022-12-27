package com.example.springproject.service;

import com.example.springproject.domain.Commit;

import java.util.List;

public interface CommitService {
	public void update(String owner, String repoName, long repoID);
	public void delete(long repoID);
	public List<Commit> findAll();
}
