package com.example.springproject.web;

import com.example.springproject.domain.Developer;
import com.example.springproject.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/release")
public class ReleaseController {
    @Autowired
    ReleaseService releaseServiceService;

    @GetMapping("/getCount")
    public long getCount() throws IOException {
        return releaseServiceService.countRelease();
    }
    @GetMapping("/getCB")
    public List<Integer> getCommitsBetween() throws IOException {
        return releaseServiceService.commitsBetween();
    }

}
