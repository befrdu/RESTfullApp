package com.contactRecord.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
@Entity
//@Table(name="contact-Detail")
public class ContactDetail implements Serializable {
	private static final String SIZE_VALIDATION="{size.validation}";
	private static final long serialVersionUID = 687217375740372451L;
	
	@Id
	@GeneratedValue
    private int id;
	
	@Size(min=2, max=50, message=SIZE_VALIDATION)
	private String name;
	
	@NotEmpty()
	private String company;
	private boolean favourite;
	private String smallImageUrl;
	private String largImageUrl;
	
	@Email(message="{emailValidationError}")
	private String email;
	private String website;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Past(message="{birthDateValidationError}")
	private Date birthDate;
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	private Phone phone;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
    public ContactDetail(){
		
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public boolean isFavourite() {
		return favourite;
	}
	public void setFavourite(boolean favorite) {
		this.favourite = favorite;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getLargImageUrl() {
		return largImageUrl;
	}
	public void setLargeImagUrl(String largeImageUrl) {
		this.largImageUrl = largeImageUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	
	
}
