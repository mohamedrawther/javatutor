package com.jf.tutor.stream.data;

sealed public class AgentBase permits Agent, Address{

	public AgentBase() {
		super();
	}
	
	public AgentBase(Integer id) {
		super();
		this.id = id;
	}

	private Integer id;
}
