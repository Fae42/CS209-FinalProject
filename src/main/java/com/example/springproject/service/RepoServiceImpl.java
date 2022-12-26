package com.example.springproject.service;

import com.example.springproject.api.RepoRepository;
import com.example.springproject.domain.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoServiceImpl implements RepoService {
    @Autowired
    private RepoRepository repoRepository;
    @Autowired
    private DeveloperServiceImpl developerService;
    
    @Override
    public void updateInfo(String owner, String repoName) {
        System.out.println("update repo");
        Repo repo = findByOwnerAndName(owner, repoName);
        if (repo==null) {
            repo = new Repo();
            repo.setOwner(owner);
            repo.setName(repoName);
            repoRepository.save(repo);
        }
        developerService.update(owner, repoName, repo.getId());
    }
    
    @Override
    public Repo findByOwnerAndName(String owner, String name) {
        return repoRepository.findRepoByOwnerAndName(owner, name);
    }
    
}
