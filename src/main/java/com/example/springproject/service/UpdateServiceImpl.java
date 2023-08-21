package com.example.springproject.service;

import net.sf.json.JSONArray;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "github")
@Service
public class UpdateServiceImpl implements UpdateService{
	
	private String owner;
	private String repoName;
	private String token;
	
	
	public JSONArray getJSONArrayByUrl(String url) {
		int page = 1;
		JSONArray jsonArray = new JSONArray();
		int jsonSize = jsonArray.size();
		try {
			while (true) {
				URL urlObject = new URL(url + String.format("?page=%d&per_page=100", page));
				URLConnection uc = urlObject.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection)uc;
				httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);
				Map<String, List<String>> tmp = httpURLConnection.getHeaderFields();
				tmp.entrySet().forEach(System.out::println);
				BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				String inputLine;
				StringBuilder json = new StringBuilder();
				while ( (inputLine = in.readLine()) != null) {
					json.append(inputLine);
				}
				in.close();
				jsonArray.add(JSONArray.fromObject(json.toString()));
				if(jsonArray.size() - jsonSize == 0) {
					break;
				}
				jsonSize = jsonArray.size();
				page++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonArray;
	}
	
	
	public JSONArray getJSONArray(String componentName, String owner, String repoName) {
		String url = String.format("https://api.github.com/repos/%s/%s/%s", owner, repoName, componentName);
		return getJSONArrayByUrl(url);
	}
	
	
	public JSONArray getJSONArray(String componentName) {
		return getJSONArray(componentName, owner, repoName);
	}
	
}
