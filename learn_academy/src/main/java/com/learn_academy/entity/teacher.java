package com.learn_academy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tid;
	
	private String tname;
	private String email;
	private String gender;
	private String mob;
	
	@OneToOne
	private classTab ct;
	
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public teacher(String tname, String email, String gender, String mob, classTab ct) {
		super();
		this.tname = tname;
		this.email = email;
		this.gender = gender;
		this.mob = mob;
		this.ct = ct;
	}
	@Override
	public String toString() {
		return "teacher [tid=" + tid + ", tname=" + tname + ", email=" + email + ", gender=" + gender + ", mob=" + mob
				+ "]";
	}
	
	
}
