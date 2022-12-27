package com.example.springproject.service;

import com.example.springproject.api.DevelopRepository;
import com.example.springproject.domain.Developer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@Service
public class DeveloperServiceImpl implements DeveloperService{
	@Autowired
	DevelopRepository developRepository;
	@Override
	public void update(String owner, String repoName, long repoID) {
		System.out.println("update developers");
		this.delete(repoID);
		try {
			StringBuilder json = new StringBuilder();
			String accessToken = "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";
			int page = 1;
			while(true) {
				json = new StringBuilder();
				URL urlObject = new URL(String.format("https://api.github.com/repos/%s/%s/contributors?page=%d&per_page=100"
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
					Developer developer = new Developer();
					developer.setRepoID(repoID);
					System.out.println(jo.getInt("contributions"));
					System.out.println(jo.getString("login"));
					developer.setContributions(jo.getInt("contributions"));
					developer.setName((jo.getString("login")));
					developRepository.save(developer);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Developer> findAll() {
		return developRepository.findAll();
	}

	public long countDevelopers(){
		return developRepository.count();
	}
	
	@Override
	public void delete(long repoID) {
		developRepository.deleteAllByRepoID(repoID);
	}
}
