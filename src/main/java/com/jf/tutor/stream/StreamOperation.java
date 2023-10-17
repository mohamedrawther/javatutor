package com.jf.tutor.stream;

import java.util.*;
import com.jf.tutor.stream.data.*;
import java.time.*;
import java.util.stream.*;

public class StreamOperation {
	List<Agent> agents;
	{
		Agent agent1 = new Agent(1, "mohamed", LocalDateTime.now(), List.of(new Address(1,"","","","","","")),20);
		Agent agent2 = new Agent(2, "aaaa", LocalDateTime.now(), List.of(new Address(2,"","","","","","")),30);
		Agent agent3 = new Agent(3, "bbbb", LocalDateTime.now(), List.of(new Address(3,"","","","","","")),40);
		Agent agent4 = new Agent(4, "ccccc", LocalDateTime.now(), List.of(new Address(4,"","","","","","")),50);
		Agent agent5 = new Agent(5, "dddd", LocalDateTime.now(), List.of(new Address(5,"","","","","","")),60);
		Agent agent6 = new Agent(6, "eeeeeee", LocalDateTime.now(), List.of(new Address(6,"","","","","","")),70);
		agents = List.of(agent1,agent2,agent3,agent4,agent5,agent6);
	}
	
	public void callAllFunctions() {
		aggregatorFunctions();
	}
	
	private void aggregatorFunctions() {
		//forEarch
		 agents.stream().filter(e -> e.getAge() > 60).forEach(e -> System.out.println(e.getAge()));	
		 //Collection to String
		 String allAgentNames = agents.stream().map(Agent::getName).collect(Collectors.joining(","));
		 System.out.println(allAgentNames);
		 
		 Double agentsAverageAge = agents.stream().mapToInt(Agent::getAge).average().getAsDouble();
		 System.out.println(agentsAverageAge);

		 Double agentsAverageAgeAbove20 = agents.stream().mapMultiToInt((agent,consumer) -> {
			 if(agent.getAge() > 5)
				 consumer.accept(agent.getAge());
		 }).average().getAsDouble();
		 System.out.println(agentsAverageAgeAbove20);
		 
		 Integer totalAge = agents.stream().collect(Collectors.summingInt(Agent::getAge));
		 System.out.println(totalAge);
		 
		 List<String> agentNames = agents.stream().map(Agent::getName).collect(Collectors.toList());
		 System.out.println(agentNames.toString());
		 agentNames.removeAll(Collections.singletonList("bbbb"));
		 System.out.println(agentNames.toString());
		 
	}	
}
