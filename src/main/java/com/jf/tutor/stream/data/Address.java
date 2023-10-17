package com.jf.tutor.stream.data;

import lombok.Data;

@Data
non-sealed public class Address extends AgentBase{

	public Address() {
		
	}
	
	public Address(Integer id, String locality, String address1, String state, String country, String city,
			String pincode) {
		super(id);
		this.locality = locality;
		this.address1 = address1;
		this.state = state;
		this.country = country;
		this.city = city;
		this.pincode = pincode;
	}
	private String locality;
	private String address1;
	private String state;
	private String country;
	private String city;
	private String pincode;
	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
