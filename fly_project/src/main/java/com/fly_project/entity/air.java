package com.fly_project.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="air")
public class air {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aid;
	private String aname;
	private String desti;
	private String arr;
	private String d_time;
	private String a_time;
	private BigInteger capacity;
	private String mode;
	private BigDecimal price;
	
	
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getDesti() {
		return desti;
	}
	public void setDesti(String desti) {
		this.desti = desti;
	}
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	public String getD_time() {
		return d_time;
	}
	public void setD_time(String d_time) {
		this.d_time = d_time;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String a_time) {
		this.a_time = a_time;
	}
	public BigInteger getCapacity() {
		return capacity;
	}
	public void setCapacity(BigInteger capacity) {
		this.capacity = capacity;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public air() {
		super();
		// TODO Auto-generated constructor stub
	}
	public air( String aname, String desti, String arr, String d_time, String a_time, BigInteger capacity,
			String mode, BigDecimal price) {
		super();
		this.aname = aname;
		this.desti = desti;
		this.arr = arr;
		this.d_time = d_time;
		this.a_time = a_time;
		this.capacity = capacity;
		this.mode = mode;
		this.price = price;
	}
	@Override
	public String toString() {
		return " aname=" + aname + ", desti=" + desti + ", arr=" + arr + ", d_time=" + d_time
				+ ", a_time=" + a_time + ", capacity=" + capacity + ", mode=" + mode + ", price=" + price + "]";
	}
	
	
	
}
