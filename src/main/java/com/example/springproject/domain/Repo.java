package com.example.springproject.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Repo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    String name;
    String owner;
    int developerNum;
    int most_active_developer;
    int open_issues;
    int close_issues;
    double issue_solve_average;
    int issue_solve_max_day;
    int issue_solve_min_day;
    int releases;
    int commit_times;
    int releases_top10_commits;
    int releases_commits;
    
    final int default_num = -1;

    public Repo(String name, int developerNum, int most_active_developer, int open_issues, int close_issues, double issue_solve_average, int issue_solve_max_day, int issue_solve_min_day, int releases, int commit_times, int releases_top10_commits, int releases_commits) {
        this.name = name;
        this.developerNum = developerNum;
        this.most_active_developer = most_active_developer;
        this.open_issues = open_issues;
        this.close_issues = close_issues;
        this.issue_solve_average = issue_solve_average;
        this.issue_solve_max_day = issue_solve_max_day;
        this.issue_solve_min_day = issue_solve_min_day;
        this.releases = releases;
        this.commit_times = commit_times;
        this.releases_top10_commits = releases_top10_commits;
        this.releases_commits = releases_commits;
    }

    public Repo(){
        this.name = "name";
        this.developerNum = default_num;
        this.most_active_developer = default_num;
        this.open_issues = default_num;
        this.close_issues = default_num;
        this.issue_solve_average = default_num;
        this.issue_solve_max_day = default_num;
        this.issue_solve_min_day = default_num;
        this.releases = default_num;
        this.commit_times = default_num;
        this.releases_top10_commits = default_num;
        this.releases_commits = default_num;
    }
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getDeveloperNum() {
        return developerNum;
    }

    public int getMost_active_developer() {
        return most_active_developer;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public int getClose_issues() {
        return close_issues;
    }

    public double getIssue_solve_average() {
        return issue_solve_average;
    }

    public int getIssue_solve_max_day() {
        return issue_solve_max_day;
    }

    public int getIssue_solve_min_day() {
        return issue_solve_min_day;
    }

    public int getReleases() {
        return releases;
    }

    public int getCommit_times() {
        return commit_times;
    }

    public int getReleases_top10_commits() {
        return releases_top10_commits;
    }

    public int getReleases_commits() {
        return releases_commits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeveloperNum(int developerNum) {
        this.developerNum = developerNum;
    }

    public void setMost_active_developer(int most_active_developer) {
        this.most_active_developer = most_active_developer;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }

    public void setClose_issues(int close_issues) {
        this.close_issues = close_issues;
    }

    public void setIssue_solve_average(double issue_solve_average) {
        this.issue_solve_average = issue_solve_average;
    }

    public void setIssue_solve_max_day(int issue_solve_max_day) {
        this.issue_solve_max_day = issue_solve_max_day;
    }

    public void setIssue_solve_min_day(int issue_solve_min_day) {
        this.issue_solve_min_day = issue_solve_min_day;
    }

    public void setReleases(int releases) {
        this.releases = releases;
    }

    public void setCommit_times(int commit_times) {
        this.commit_times = commit_times;
    }

    public void setReleases_top10_commits(int releases_top10_commits) {
        this.releases_top10_commits = releases_top10_commits;
    }

    public void setReleases_commits(int releases_commits) {
        this.releases_commits = releases_commits;
    }
}
