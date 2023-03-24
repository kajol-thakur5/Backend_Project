package com.learn_academy.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="class_table")
public class classTab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	private String std;
	private String ctime;
	
	
	
	
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getStd() {
		return std;
	}




	public void setStd(String std) {
		this.std = std;
	}




	public String getCtime() {
		return ctime;
	}




	public void setCtime(String ctime) {
		this.ctime = ctime;
	}




	public classTab(String std, String ctime) {
		super();
		this.std = std;
		this.ctime = ctime;
	}




	public classTab() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "classTab [cid=" + cid + ", std=" + std + ", ctime=" + ctime + "]";
	}
	
	
	
	
	
}
