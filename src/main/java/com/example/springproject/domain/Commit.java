package com.example.springproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Commit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long repoID;
	private Date time;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getRepoID() {
		return repoID;
	}
	
	public void setRepoID(long repoID) {
		this.repoID = repoID;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
}
