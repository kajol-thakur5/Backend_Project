package com.learner_Acad.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sub_id;
	private String name;
	private String std;
	private String sub_code;
	
	public long getSubid() {
		return sub_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public subject(String name, String std, String sub_code) {
		super();
		this.name = name;
		this.std = std;
		this.sub_code = sub_code;
	}
	@Override
	public String toString() {
		return "subject [sub_id=" + sub_id + ", name=" + name + ", std=" + std + ", sub_code=" + sub_code + "]";
	}
	
	
	
}
