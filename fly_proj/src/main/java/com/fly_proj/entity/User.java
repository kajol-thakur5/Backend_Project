package com.fly_proj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long uid;
	private String uname;
	private int age;
	private String address;
	private String mobno;
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uname, int age, String address, String mobno) {
		super();
		this.uname = uname;
		this.age = age;
		this.address = address;
		this.mobno = mobno;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname  + ", age=" + age + ", address=" + address
				+ ", mobno=" + mobno + "]";
	}
	
}
