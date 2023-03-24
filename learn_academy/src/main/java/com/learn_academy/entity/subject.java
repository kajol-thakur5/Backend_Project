package com.learn_academy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sub_id;
	private String sname;
	private String std;
	private String sub_code;
	@OneToOne
	private classTab ct;
	
	public long getSub_id() {
		return sub_id;
	}
	public void setSub_id(long sub_id) {
		this.sub_id = sub_id;
	}
	public String getName() {
		return sname;
	}
	public void setName(String name) {
		this.sname = name;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	public subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public subject(String name, String std, String sub_code, classTab ct) {
		super();
		this.sname = name;
		this.std = std;
		this.sub_code = sub_code;
		this.ct = ct;
	}
	@Override
	public String toString() {
		return "subject [sub_id=" + sub_id + ", name=" + sname + ", std=" + std + ", sub_code=" + sub_code + "]";
	}
	
	
}
