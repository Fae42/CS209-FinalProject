package com.example.springproject.service;

import com.example.springproject.api.CommitRepository;
import com.example.springproject.domain.Commit;
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
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Stream;

@Service
public class CommitServiceImpl implements CommitService {
	@Autowired
	CommitRepository commitRepository;
	@Override
	public void update(String owner, String repoName, long repoID) {
		System.out.println("update commit");
		this.delete(repoID);
		try {
			StringBuilder json = new StringBuilder();
			String accessToken = "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";
			int page = 1;
			while(true) {
				json = new StringBuilder();
				URL urlObject = new URL(String.format("https://api.github.com/repos/%s/%s/commits?page=%d&per_page=100"
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
					
					Commit commit = new Commit();
					commit.setRepoID(repoID);
					commit.setTime(sdf.parse(
							jo.getJSONObject("commit")
									.getJSONObject("committer")
									.getString("date")));
					commitRepository.save(commit);
				}
			}
			System.out.println("update finish.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(long repoID) {
		commitRepository.deleteAllByRepoID(repoID);
	}
	
}
