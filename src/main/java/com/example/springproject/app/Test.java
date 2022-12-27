package com.example.springproject.app;

import com.example.springproject.domain.Developer;
import com.example.springproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class Test {
	@Autowired
	DeveloperService developerService;
	@Autowired
	RepoService repoService;
	@Autowired
	IssueService issueService;
	@Autowired
	ReleaseService releaseService;
	@Autowired
	CommitService commitService;
	
	@GetMapping("/developer")
	public List<Developer> findAll(){
		System.out.println(developerService.getClass().getName());
		return developerService.findAll();
	}
	
	@GetMapping("/count_close")
	public long countCloseIssues() {
		return issueService.countClose();
	}
	
	@GetMapping("/count_open")
	public long countOpenIssues() {
		return issueService.countOpen();
	}
	
	@GetMapping("/count_release")
	public long countRelease() {
		return releaseService.countRelease();
	}
	
	@GetMapping("/commits_between")
	public List<Integer> commitsBetween() {
		return releaseService.commitsBetween();
	}
}
