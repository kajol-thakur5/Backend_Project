package com.fly_project.entity;

import java.math.BigInteger;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class book {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long bid;
	@OneToOne
	private user User;
	private String dob; 
	private BigInteger nop;
	private BigInteger fid;
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public user getUser() {
		return User;
	}
	public void setUser(user user) {
		User = user;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public BigInteger getNop() {
		return nop;
	}
	public void setNop(BigInteger nop) {
		this.nop = nop;
	}
	public BigInteger getFid() {
		return fid;
	}
	public void setFid(BigInteger fid) {
		this.fid = fid;
	}
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public book(user user, String dob, BigInteger nop, BigInteger fid) {
		super();
		User = user;
		this.dob = dob;
		this.nop = nop;
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "book [bid=" + bid + ", User=" + User + ", dob=" + dob + ", nop=" + nop + ", fid=" + fid + "]";
	}
	
	
    
}
