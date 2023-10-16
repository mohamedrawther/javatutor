package com.jf.tutor.stream.data;


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
}
