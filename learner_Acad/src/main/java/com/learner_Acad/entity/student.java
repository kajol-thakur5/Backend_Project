package com.learner_Acad.entity;

import java.math.BigDecimal;
import java.util.Date;

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
	private String dob;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public BigDecimal getFees() {
		return fees;
	}
	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student(String fname, String lname, String gender, String dob, String doj, String address, String std,
			BigDecimal fees) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
		this.address = address;
		this.std = std;
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "student [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", dob=" + dob
				+ ", doj=" + doj + ", address=" + address + ", std=" + std + ", fees=" + fees + "]";
	}
	
	
	
}
