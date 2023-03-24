package com.learn_academy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sid;
	private String name;
	private String gender;
	private String std;
	private String dob;
	@OneToOne
	private classTab ct;
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public student(String name, String gender, String std, String dob, classTab ct) {
		super();
		this.name = name;
		this.gender = gender;
		this.std = std;
		this.dob = dob;
		this.ct = ct;
	}
	@Override
	public String toString() {
		return "student [sid=" + sid + ", name=" + name + ", gender=" + gender + ", std=" + std + ", dob=" + dob + "]";
	}
	
	
}
