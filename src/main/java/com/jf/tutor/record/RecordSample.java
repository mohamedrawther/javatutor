package com.jf.tutor.record;

import com.jf.tutor.annotation.GreaterThanZero;
import com.jf.tutor.record.AgentGrade;

public class RecordSample {

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
