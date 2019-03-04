package com.jc.moo;

public class Contact {
	
	private String forename; 
	private String surname;
	private String phoneNumber;
	private String address1;
	private String address2;
	private String city;
	private String postcode;
	
	public Contact(String forename, String surname, String phoneNumber, String address1, String city, String postcode) {
		this.forename = forename;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.address1 = address1;
		this.city = city;
		this.postcode = postcode;
	}

	public Contact(String forename, String surname, String phoneNumber, String address1, String address2, String city,
			String postcode) {
		this.forename = forename;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postcode = postcode;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
