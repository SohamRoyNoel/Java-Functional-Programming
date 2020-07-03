package com.functional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedStream {

	public static void main(String[] args) {
		
//		ListSortWithConditionValuePrinter(List.of(10, 10, 25, 259, 251, 35, 52, 15, 2165, 31,77,89));
		List<Integer> newList = CourseValuePrinter3(List.of("Spring Boot", "Spring MVC", "Spring Microservices", "Spring Rest", "Java", "Python", "MongoDB"));
		System.out.println(newList);
	}

	/*
	 * Using Reduce : aggregate functions 
	 * */
	private static int sum(int a, int b) {
		return a+b;
	}
	private static int ListValuePrinter(List<Integer> numbers) {
		return numbers
				.stream()
				//.reduce(0, AdvancedStream::sum); // method reference
				//.reduce(0, Integer::sum); // predefined functions
				.reduce(0, (x,y)->x+y); // lambda expression
	}
	
	private static void ListDistValuePrinter(List<Integer> numbers) {
		numbers
		.stream()
		.distinct()
		.sorted()
		.forEach(System.out::println);
	}
	
	private static void ListSortWithConditionValuePrinter(List<Integer> numbers) {
		numbers
		.stream()
		.distinct()
//		.sorted(Comparator.naturalOrder())
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
	}
	
	// Length of the string to compare
	private static void CourseValuePrinter(List<String> courses) {
		courses
		.stream()
		.sorted(Comparator.comparing(x -> x.length()))
		.forEach(System.out::println);
	}
	
	// collector method : collect to built something
	/*
	 * collecting the string Length to create a new list 
	 * */
	private static List<Integer> CourseValuePrinter2(List<String> courses) {
		return courses
		.stream() // get the stream
		.sorted(Comparator.comparing(x -> x.length())) // sort by length first
		.map(x -> x.length())
		.collect(Collectors.toList())
		;
	}

	private static List<Integer> CourseValuePrinter3(List<String> courses) {
		return courses
		.stream() // get the stream
		.filter(x -> x.contains("B"))
		.sorted(Comparator.comparing(x -> x.length() > 10)) // sort by length first
		.map(x -> x.length())
		.collect(Collectors.toList())
		;
	}
}












