package com.example.springproject.service;

import com.example.springproject.api.IssueRepository;
import com.example.springproject.domain.Developer;
import com.example.springproject.domain.Issue;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Service
public class IssueServiceImpl implements IssueService{
	@Autowired
	IssueRepository issueRepository;
	
	@Override
	public void update(String owner, String repoName, long repoID) {
		System.out.println("update issue");
		this.delete(repoID);
		try {
			StringBuilder json = new StringBuilder();
			String accessToken = "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";
			int page = 1;
			while(true) {
				json = new StringBuilder();
				URL urlObject = new URL(String.format("https://api.github.com/repos/%s/%s/issues?page=%d&per_page=100&state=all"
						,owner, repoName, page) );
				URLConnection uc = urlObject.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection)uc;
				httpURLConnection.setRequestProperty("Authorization", "Bearer " + accessToken);
				Map tmp = httpURLConnection.getHeaderFields();
				tmp.entrySet().stream().forEach(System.out::println);
				BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				String inputLine = null;
				while ( (inputLine = in.readLine()) != null) {
					json.append(inputLine);
				}
				in.close();
				JSONArray jsonArray = JSONArray.fromObject(json.toString());
				if(jsonArray.size() == 0) {
					break;
				}
				page++;
				
				for (int i=0; i < jsonArray.size(); i++) {
					JSONObject jo = jsonArray.getJSONObject(i);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
					sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
					
					Issue issue = new Issue();
					
					issue.setRepoID(repoID);
					issue.setOpen(jo.getString("state").equals("open"));
					issue.setOpenTime(sdf.parse(jo.getString("created_at")));
					if(!issue.isOpen()) {
						issue.setCloseTime(sdf.parse(jo.getString("closed_at")));
					}
					issueRepository.save(issue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public long countOpen() {
		return issueRepository.countByIsOpenTrue();
	}
	
	@Override
	public long countClose() {
		return issueRepository.countByIsOpenFalse();
	}
	
	@Override
	public String getAvgSolveTime() {
		return issueRepository.avgSolveTime();
	}
	
	@Override
	public String getMaxSolveTime() {
		System.out.println(issueRepository.maxSolveTime());
		return issueRepository.maxSolveTime();
	}
	
	@Override
	public String getMinSolveTime() {
		return issueRepository.minSolveTime();
	}
	
	@Override
	public void delete(long repoID) {
		issueRepository.deleteAllByRepoID(repoID);
	}
	
	@Override
	public List<Issue> findAll() {
		return issueRepository.findAll();
	}
}
