package com.example.springproject.app;

import com.example.springproject.domain.Developer;
import com.example.springproject.service.DeveloperService;
import com.example.springproject.service.IssueService;
import com.example.springproject.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exer")
public class DataApp {
	@Autowired
	DeveloperService developerService;
	@Autowired
	RepoService repoService;
	@Autowired
	IssueService issueService;
	@GetMapping("/developer")
	public List<Developer> findAll(){
		System.out.println(developerService.getClass().getName());
		return developerService.findAll();
	}
	@PostMapping("/update_data")
	public void updateData() {
		repoService.updateInfo("MaaAssistantArknights"
				, "MaaAssistantArknights");//for testing, this line gets and saves all developers' data.
	}
	@GetMapping("/count_close")
	public long countCloseIssues() {
		return issueService.countClose();
	}
	
	@GetMapping("/count_open")
	public long countOpenIssues() {
		return issueService.countOpen();
	}
}