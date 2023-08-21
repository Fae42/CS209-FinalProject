package com.example.springproject.app;

import com.example.springproject.api.CommitRepository;
import com.example.springproject.api.DeveloperRepository;
import com.example.springproject.api.IssueRepository;
import com.example.springproject.api.RepoRepository;
import com.example.springproject.domain.Commit;
import com.example.springproject.domain.Developer;
import com.example.springproject.domain.Issue;
import com.example.springproject.payroll.CommitNotFoundException;
import com.example.springproject.payroll.DeveloperNotFoundException;
import com.example.springproject.payroll.IssueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RESTful {
	@Autowired
	DeveloperRepository developerRepository;
	@Autowired
	CommitRepository commitRepository;
	@Autowired
	IssueRepository issueRepository;
	@Autowired
	RepoRepository repoRepository;
	@GetMapping("/developer/{id}")
	Developer find(@PathVariable Long id) {
		return developerRepository.findById(id)
				.orElseThrow(() -> new DeveloperNotFoundException(id));
	}
	@GetMapping("/commit/{id}")
	Commit find2(@PathVariable Long id) {
		return commitRepository.findById(id)
				.orElseThrow(() -> new CommitNotFoundException(id));
	}
	@GetMapping("/issue/{id}")
	Issue find3(@PathVariable Long id) {
		return issueRepository.findById(id)
				.orElseThrow(() -> new IssueNotFoundException(id));
	}
}
