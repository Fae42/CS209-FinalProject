package com.example.springproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Release {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long repoID;
	private Date createTime;
	private String name;
	
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
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
