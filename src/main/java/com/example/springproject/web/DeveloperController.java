package com.example.springproject.web;

import com.example.springproject.domain.Developer;
import com.example.springproject.service.DeveloperService;
import com.example.springproject.service.DeveloperServiceImpl;
import com.example.springproject.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
	@Autowired
	DeveloperService developerService;
	
	@GetMapping("/getDevelopers")
	public List<Developer> getDevelopers() throws IOException {
		return developerService.findAll();
	}
}
