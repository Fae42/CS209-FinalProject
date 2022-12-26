package com.example.springproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Developer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private long repoID;
	private long contributions;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getRepoID() {
		return repoID;
	}
	
	public void setRepoID(long repoID) {
		this.repoID = repoID;
	}
	
	public long getContributions() {
		return contributions;
	}
	
	public void setContributions(long contributions) {
		this.contributions = contributions;
	}
}
