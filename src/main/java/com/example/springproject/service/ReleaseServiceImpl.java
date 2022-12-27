package com.example.springproject.service;

import com.example.springproject.api.CommitRepository;
import com.example.springproject.api.DevelopRepository;
import com.example.springproject.api.ReleaseRepository;
import com.example.springproject.domain.Commit;
import com.example.springproject.domain.Developer;
import com.example.springproject.domain.Release;
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
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReleaseServiceImpl implements ReleaseService{
	@Autowired
	ReleaseRepository releaseRepository;
	@Autowired
	CommitRepository commitRepository;
	@Override
	public void update(String owner, String repoName, long repoID) {
		System.out.println("update releases");
		this.delete(repoID);
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
	
	@Override
	public void delete(long repoID) {
		releaseRepository.deleteAllByRepoID(repoID);
	}
	
	@Override
	public List<Integer> commitsBetween() {
		List<Release> releases = releaseRepository.findAll(new Sort(Sort.Direction.DESC, "createTime"));
		//from new to old
		List<Integer> ans = new ArrayList<>();
		for(int i=1; i<releases.size(); i++) {
			Date d1 = releases.get(i-1).getCreateTime();
			Date d2 = releases.get(i).getCreateTime();
			System.out.println(d1);
			System.out.println(d2);
			System.out.println();
			ans.add((int) commitRepository.countByTimeLessThanAndTimeGreaterThan(d1, d2));
		}
		return ans;
	}
}
