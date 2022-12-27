package com.example.springproject.web;

import com.example.springproject.domain.Commit;
import com.example.springproject.domain.Developer;
import com.example.springproject.service.CommitService;
import com.example.springproject.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/commit")
public class CommitController {
    @Autowired
    CommitService commitService;

    @GetMapping("/getCommits")
    public List<Commit> getCommits() throws IOException {
        return commitService.findAll();
    }
}
