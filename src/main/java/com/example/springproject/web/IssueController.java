package com.example.springproject.web;

import com.example.springproject.domain.Developer;
import com.example.springproject.service.DeveloperService;
import com.example.springproject.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    IssueService issueService;

    @GetMapping("/getOpen")
    public long getOpen() throws IOException {
        return issueService.countOpen();
    }
    @GetMapping("/getClose")
    public long getClose() throws IOException {
        return issueService.countClose();
    }
    @GetMapping("/getAvg")
    public String getAvg() throws IOException {
        return issueService.getAvgSolveTime();
    }
    @GetMapping("/getMin")
    public String getMin() throws IOException {
        return issueService.getMinSolveTime();
    }
    @GetMapping("/getMax")
    public String getMax() throws IOException {
        return issueService.getMaxSolveTime();
    }

}
