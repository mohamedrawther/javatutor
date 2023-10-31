package com.jf.tutor.stream;

import java.util.*;
import com.jf.tutor.stream.data.*;
import java.time.*;
import java.util.stream.*;

public class StreamOperation {
	List<Agent> agents;
	Queue<Agent> agentsQ;
	Deque<Agent > agentsDq;
	{
		Agent agent1 = new Agent(1, "mohamed", LocalDateTime.now(), List.of(new Address(1,"","","","","","")),20);
		Agent agent2 = new Agent(2, "aaaa", LocalDateTime.now(), List.of(new Address(2,"","","","","","")),30);
		Agent agent3 = new Agent(3, "bbbb", LocalDateTime.now(), List.of(new Address(3,"","","","","","")),40);
		Agent agent4 = new Agent(4, "ccccc", LocalDateTime.now(), List.of(new Address(4,"","","","","","")),50);
		Agent agent5 = new Agent(5, "dddd", LocalDateTime.now(), List.of(new Address(5,"","","","","","")),60);
		Agent agent6 = new Agent(6, "eeeeeee", LocalDateTime.now(), List.of(new Address(6,"","","","","","")),70);
		Agent agent7 = new Agent(1, "mohamed", LocalDateTime.now(), List.of(new Address(1,"","","","","","")),20);
		agents = List.of(agent1,agent2,agent3,agent4,agent5,agent6,agent7);
		
		agentsQ = new PriorityQueue<>(Comparator.comparingInt(Agent::getAge));
		agentsQ.add(agent1);agentsQ.add(agent6);
		agentsQ.add(agent2);agentsQ.add(agent3);agentsQ.add(agent4);agentsQ.add(agent5);
		
		agentsDq = new ArrayDeque<>();
		agentsDq.add(agent1);agentsDq.add(agent6);
		agentsDq.add(agent2);agentsDq.add(agent3);agentsDq.add(agent4);agentsDq.add(agent5);
	}
	
	public void callAllFunctions() {
		//All map functions
		streamMapInterface();
		//All collection function
		streamDequeInterface();
		streamQueueInterface();
		streamSetInterface();
		streamListInterface();
		streamCollectionInterface();		
	}

	private void streamMapInterface() {		
		Map<String, List<Agent>> agentsByNameMap = agents.stream().collect(Collectors.groupingBy(Agent::getName));
		System.out.println(agentsByNameMap);
		
		Map<String, Map<Integer, List<Agent>>> agentsAddressByNameMap = agents.stream().collect(
				Collectors.groupingBy(Agent::getName, Collectors.groupingBy(Agent::getAge)));
		System.out.println(agentsAddressByNameMap);
		
		Map<String, Integer> agentsAgeSumByNameMap = agents.stream().collect(
				Collectors.groupingBy(Agent::getName, Collectors.summingInt(Agent::getAge)));
		for(Map.Entry<String,Integer> e: agentsAgeSumByNameMap.entrySet()) {
			System.out.println(e.getKey()+e.getValue());
		}
		
	}
	
	private void streamDequeInterface() {		
		List<Integer> ages = agentsDq.stream().peek(agent -> System.out.println(agent.getAge())).mapToInt(Agent::getAge)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);		
	}

	private void streamQueueInterface() {		
		List<Integer> ages = agentsQ.stream().peek(agent -> System.out.println(agent.getAge())).mapToInt(Agent::getAge)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);		
	}
	
	private void streamSetInterface() {		
		Set<String> originalData = agents.stream().map(Agent::getName).collect(Collectors.toSet());
		System.out.println(originalData.toString());
		
		TreeSet<String> sortedName = agents.stream().map(Agent::getName).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(sortedName.toString());		
	}
	
	private void streamListInterface() {
		List<String> allData = agents.stream().map(Agent::getName).collect(Collectors.toList());
		System.out.println(allData.toString());
	}
	
	private void streamCollectionInterface() {
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
