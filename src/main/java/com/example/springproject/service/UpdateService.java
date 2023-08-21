package com.example.springproject.service;

import net.sf.json.JSONArray;

public interface UpdateService {
	JSONArray getJSONArrayByUrl(String url);
	
	JSONArray getJSONArray(String owner, String repoName, String url);
	
	
}
