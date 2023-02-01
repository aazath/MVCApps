package com.iqrah.dto;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer sid;
	private String sname;
	private Integer sage;
	private String saddr;
	

	public Student() {
	}
	
	public Integer getSid() {
		return sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sage=" + sage + ", saddr=" + saddr + "]";
	}
	public void setSid(Integer id) {
		this.sid = id;
	}
	
	

}
