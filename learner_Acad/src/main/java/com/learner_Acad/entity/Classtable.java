package com.learner_Acad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="class_table")
public class Classtable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	private String std;
	private String ctime;
	@OneToOne
	private subject Sid;
	@OneToOne
	private teacher Tid;
	@OneToOne
	private student Stu;
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public subject getSid() {
		return Sid;
	}
	public void setSid(subject sid) {
		Sid = sid;
	}
	public teacher getTid() {
		return Tid;
	}
	public void setTid(teacher tid) {
		Tid = tid;
	}
	public student getStu() {
		return Stu;
	}
	public void setStu(student stu) {
		Stu = stu;
	}
	public Classtable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classtable(String std, String ctime, subject sid, teacher tid, student stu) {
		super();
		this.std = std;
		this.ctime = ctime;
		Sid = sid;
		Tid = tid;
		Stu = stu;
	}
	@Override
	public String toString() {
		return "Classtable [cid=" + cid + ", std=" + std + ", ctime=" + ctime + ", Sid=" + Sid + ", Tid=" + Tid
				+ ", Stu=" + Stu + "]";
	}
	
	
}
