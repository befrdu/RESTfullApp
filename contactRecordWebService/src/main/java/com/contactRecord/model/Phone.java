package com.contactRecord.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
//@Table(name="phone")
public class Phone implements Serializable {
private static final long serialVersionUID = 5658716793957904104L;
private static final String SIZE_VALIDATION="{size.validation}";


	public Phone(){
		
	}
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=10,max=15)	
	private String work;
	
	@Size(min=10,max=15)
	private String home;
	
	@Size(min=10,max=15, message=SIZE_VALIDATION)
	private String mobile;
	
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	
	}
