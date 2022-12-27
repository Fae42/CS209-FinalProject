package com.example.springproject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long repoID;
	@Value("${isOpen:true}")
	private boolean isOpen;
	private Date openTime;
	private Date closeTime;
	
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
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public void setOpen(boolean open) {
		isOpen = open;
	}
	
	public Date getOpenTime() {
		return openTime;
	}
	
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	
	public Date getCloseTime() {
		return closeTime;
	}
	
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
}
