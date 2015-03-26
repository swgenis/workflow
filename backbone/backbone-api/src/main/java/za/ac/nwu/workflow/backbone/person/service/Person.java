package za.ac.nwu.workflow.backbone.person.service;

import za.ac.nwu.workflow.backbone.Entity;

public class Person extends Entity {

	private int year;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String cellphone;
	
	private String faxNumber;
	
	private String phoneNumber;
	
	private String racialType;
	
	private String genderType;
	
	private boolean firstAid;
	
	private String licenseType;
	
	private boolean previousDisadvantage;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRacialType() {
		return racialType;
	}

	public void setRacialType(String racialType) {
		this.racialType = racialType;
	}

	public String getGenderType() {
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

	public boolean isFirstAid() {
		return firstAid;
	}

	public void setFirstAid(boolean firstAid) {
		this.firstAid = firstAid;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public boolean isPreviousDisadvantage() {
		return previousDisadvantage;
	}

	public void setPreviousDisadvantage(boolean previousDisadvantage) {
		this.previousDisadvantage = previousDisadvantage;
	}

}
