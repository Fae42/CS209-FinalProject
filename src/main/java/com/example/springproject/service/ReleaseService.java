package com.example.springproject.service;

import com.example.springproject.domain.Developer;

import java.util.List;

public interface ReleaseService {
	public void update(String owner, String repoName, long repoID);
	public long countRelease();
}
