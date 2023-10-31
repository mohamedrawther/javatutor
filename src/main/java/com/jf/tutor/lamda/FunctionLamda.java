package com.jf.tutor.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionLamda {
	/**
	 * Function is taking an input and return an output and type can be different
	 * T input type,R return type
	 * @FunctionalInterface
		public interface Function<T, R> {
      R apply(T t);}
	 */
	
	Function<String, Integer> lenFunction = e -> e.length();
	Function<Integer, Double> lenConvToPercentage = e -> e * 0.01;
	Function<String, String> composeFun = e -> e+e;
	
	public void callFunctions() {
		functionlamda();
		
	}

	private void functionlamda() {
		System.out.println(lenFunction.apply("mohamed"));
		
		System.out.println(lenFunction.andThen(lenConvToPercentage).apply("mohamed"));
		
		System.out.println(lenFunction.compose(composeFun).andThen(lenConvToPercentage).apply("mohamed"));
		
		map(Arrays.asList("assd","sfd","sdsf"), this::length).forEach(System.out::println);
		
		ExampleFunctionalInterface display1 = FunctionLamda::functionalreference;
		ExampleFunctionalInterface display2_inst_meth_refere = this::instanceFunctionalReference;
		display1.display();
		display2_inst_meth_refere.display();
	}
	
	public List<Integer> length(List<String> str) {
		return str.stream().map(e->e.length()).collect(Collectors.toList());
	}
	
	public <T,R> List<R> map(List<T> leObj, Function<List<T>,List<R>> funclen){	
		return funclen.apply(leObj);
	}
	
	public static void functionalreference() {
		System.out.println("This is static functional reference");
	}
	
	private String instanceFunctionalReference() {
		System.out.println("This is instance functional reference");
		return "hai";
	}	
}
