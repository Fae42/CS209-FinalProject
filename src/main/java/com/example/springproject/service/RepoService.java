package com.example.springproject.service;

import com.example.springproject.domain.Repo;

import java.util.List;

public interface RepoService {

    public void updateInfo(String owner, String repoName);
    
    public Repo findByOwnerAndName(String owner, String name);


}
