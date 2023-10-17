package com.jf.tutor.stream.data;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
non-sealed public class Agent extends AgentBase {

	public Agent() {
		super();
	}
	
	public Agent(Integer id, String name, LocalDateTime dob, List<Address> permanentAddr, Integer age) {
		super(id);
		this.name = name;
		this.dob = dob;
		this.permanentAddr = permanentAddr;
		this.age = age;
	}
	private String name;	
	private LocalDateTime dob;
	private List<Address> permanentAddr;
	private Integer age;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public List<Address> getPermanentAddr() {
		return permanentAddr;
	}

	public void setPermanentAddr(List<Address> permanentAddr) {
		this.permanentAddr = permanentAddr;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
