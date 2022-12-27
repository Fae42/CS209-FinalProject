package com.example.springproject.service;

import com.example.springproject.api.ReleaseRepository;
import com.example.springproject.api.RepoRepository;
import com.example.springproject.domain.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoServiceImpl implements RepoService {
    @Autowired
    private RepoRepository repoRepository;
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private ReleaseService releaseService;
    @Autowired
    private CommitService commitService;
    
    @Override
    public void updateInfo(String owner, String repoName) {
        System.out.println("update repo, may take long time and crash due to GitHub API limits");
        Repo repo = findByOwnerAndName(owner, repoName);
        if (repo==null) {
            repo = new Repo();
            repo.setOwner(owner);
            repo.setName(repoName);
            repoRepository.save(repo);
        }
        long repoID = repo.getId();
        
        developerService.update(owner, repoName, repoID);
        issueService.update(owner, repoName, repoID);
        releaseService.update(owner, repoName, repoID);
        commitService.update(owner, repoName, repoID);
    }
    
    @Override
    public Repo findByOwnerAndName(String owner, String name) {
        return repoRepository.findRepoByOwnerAndName(owner, name);
    }
    
}
