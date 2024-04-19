package com.example.demo.model;


import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotBlank(message = "Name cannot be kept empty. !!")
	private String name;
	
	@NotNull
	@NotBlank(message = "EmailId cannot be kept empty. !!")
	private String emailId;
	
	@NotNull
	@NotBlank(message = "Occupation cannot be kept empty. !!")
	private String occupation;
	
	@NotNull
	@NotBlank(message = "Company cannot be kept empty. !!")
	private String company;
	
	@NotNull
	@NotBlank(message = "DOB cannot be kept empty. !!")
	private String dob;
	
	@NotNull
	@NotBlank(message = "House Address cannot be kept empty. !!")
	private String houseAddress;
	
	@NotNull
	@NotBlank(message = "City cannot be kept empty. !!")
	private String city;
	
	@NotNull
	@NotBlank(message = "State cannot be kept empty. !!")
	private String state;
	
	@NotNull
	@NotBlank(message = "Phone-No cannot be kept empty. !!")
	private String phoneNo;

	
	public Employe() {
		
	}
	
	public Employe(String name, String emailId, String occupation, String company, String dob, String houseAddress, String city, String state, String phoneNo) {
		this.name = name;
		this.emailId = emailId;
		this.occupation = occupation;
		this.company = company;
		this.dob = dob;
		this.houseAddress = houseAddress;
		this.city = city;
		this.state = state;
		this.phoneNo = phoneNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + ", emailId=" + emailId + ", occupation=" + occupation
				+ ", company=" + company + ", dob=" + dob + ", houseAddress=" + houseAddress + ", city=" + city
				+ ", state=" + state + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
}
