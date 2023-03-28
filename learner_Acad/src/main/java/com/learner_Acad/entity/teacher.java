package com.learner_Acad.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
}
