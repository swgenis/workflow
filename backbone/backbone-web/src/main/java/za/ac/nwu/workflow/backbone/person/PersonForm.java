package za.ac.nwu.workflow.backbone.person;

import za.ac.nwu.workflow.backbone.person.service.Person;

public class PersonForm {
	
	private String id;
	
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
	
	private boolean active;
	
	public PersonForm(){
	}
	
	public PersonForm(Person person){
		this.id = person.getId();
		this.year = person.getYear();
		this.name = person.getName();
		this.surname = person.getSurname();
		this.email = person.getEmail();
		this.cellphone = person.getCellphone();
		this.faxNumber = person.getFaxNumber();
		this.phoneNumber = person.getFaxNumber();
		this.racialType = person.getRacialType();
		this.genderType = person.getGenderType();
		this.firstAid = person.isFirstAid();
		this.licenseType = person.getLicenseType();
		this.previousDisadvantage = person.isPreviousDisadvantage();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Person toPerson(){
		Person person = new Person();
		person.setId(this.getId());
		person.setYear(this.getYear());
		person.setName(this.getName());
		person.setSurname(this.getSurname());
		person.setEmail(this.getEmail());
		person.setCellphone(this.getCellphone());
		person.setFaxNumber(this.getFaxNumber());
		person.setPhoneNumber(this.getPhoneNumber());
		person.setRacialType(this.getRacialType());
		person.setGenderType(this.getGenderType());
		person.setFirstAid(this.isFirstAid());
		person.setLicenseType(this.getLicenseType());
		person.setPreviousDisadvantage(this.isPreviousDisadvantage());
		person.setActive(this.isActive());
		return person;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getSurname();
	}

}
