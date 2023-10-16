package com.jf.tutor.stream.data;

import java.time.LocalDateTime;
import java.util.List;

non-sealed public class Agent extends AgentBase {
	
	public Agent() {
		super();
	}
	
	public Agent(Integer id, String name, LocalDateTime dob, List<Address> permanentAddr) {
		super(id);
		this.name = name;
		this.dob = dob;
		this.permanentAddr = permanentAddr;
	}
	private String name;	
	private LocalDateTime dob;
	private List<Address> permanentAddr;
}
