package com.jf.tutor.stream.data;

import lombok.Data;

@Data
sealed public class AgentBase permits Agent, Address{

	public AgentBase() {
		super();
	}
	
	public AgentBase(Integer id) {
		super();
		this.id = id;
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
