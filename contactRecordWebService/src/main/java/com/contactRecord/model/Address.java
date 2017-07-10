package com.contactRecord.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 7888739895742404595L;
	private static final String SIZE_VALIDATION="{size.validation}";
  
	public Address(){
		
	}
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=4,max=20, message=SIZE_VALIDATION)
	private String street;
	
	@NotEmpty()
	private String city;
	
	@Size(min=2, max=20)
	private String state;
	
	@Size(min=2, max=20, message=SIZE_VALIDATION)
	private String country;
	private String zip;
	
	private float latitude;
	private float longitude;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongtude() {
		return longitude;
	}
	public void setLongtude(float longtude) {
		this.longitude = longtude;
	}
	public int getId() {
		return id;
	}

	
}
