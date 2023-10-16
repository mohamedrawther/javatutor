package com.jf.tutor.stream;

import java.time.LocalDateTime;
import java.util.List;

import com.jf.tutor.annotation.GreaterThanZero;
import com.jf.tutor.stream.data.Address;
import com.jf.tutor.stream.data.Agent;
import com.jf.tutor.stream.data.AgentBase;

public class StreamMain {

	public static void main(String[] args) {
		//switchPatternFeature(); -- this feature is till in preview status
		testRecordClass();
	}
	
	
	public static void switchPatternFeature() {
		AgentBase agentbase = new Agent(1,"rawther",LocalDateTime.now(),List.of(new Address()));
		/*
		switch(agentbase) {
		case Agent agent -> System.out.println();
			
		case Address address -> System.out.println();
			
		default  -> System.out.println();
		
		};*/
	}

	public static void testRecordClass() {
		AgentGrade rec = new AgentGrade(10, 12345645.0);
		System.out.println(rec.agentGrade());
	}
}


record AgentGrade(@GreaterThanZero Integer totalYears, @GreaterThanZero Double turnover) {
	static double minRatio;
	static {
		minRatio = 1.0;
	}
	public  AgentGrade{
		if(totalYears < 5) { 
			throw new java.lang.IllegalArgumentException(
	                String.format("Invalid Claim: %f, %f", totalYears, turnover));
		}
	}
	public double calRatio() {
		return (turnover / totalYears.doubleValue()) * 0.5;
	}
	public Integer agentGrade() {
		if(calRatio() > 1.0) return 1;
		return 0;
	}
}

