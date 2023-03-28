package com.fly_proj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	
	private int nop;
	private Date dob;
	private Date dol;
	private float price;
	
	
}
