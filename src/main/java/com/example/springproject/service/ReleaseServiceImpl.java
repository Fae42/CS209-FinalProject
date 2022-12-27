package com.example.springproject.service;

import com.example.springproject.api.DevelopRepository;
import com.example.springproject.api.ReleaseRepository;
import com.example.springproject.domain.Developer;
import com.example.springproject.domain.Release;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Service
public class ReleaseServiceImpl implements ReleaseService{
	@Autowired
	ReleaseRepository releaseRepository;
	@Override
	public void update(String owner, String repoName, long repoID) {
		System.out.println("update releases");
		try {
			StringBuilder json = new StringBuilder();
			String accessToken = "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";
			int page = 1;
			while(true) {
				json = new StringBuilder();
				URL urlObject = new URL(String.format("https://api.github.com/repos/%s/%s/releases?page=%d&per_page=100"
						,owner, repoName, page) );
				URLConnection uc = urlObject.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection)uc;
				httpURLConnection.setRequestProperty("access_token", accessToken);
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
					
					Release release = new Release();
					release.setRepoID(repoID);
					release.setName(jo.getString("name"));
					release.setCreateTime(sdf.parse(jo.getString("created_at")));
					releaseRepository.save(release);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public long countRelease() {
		return releaseRepository.count();
	}
	
}
