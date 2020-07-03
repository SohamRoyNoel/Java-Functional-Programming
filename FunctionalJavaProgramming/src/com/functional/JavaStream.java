package com.functional;

import java.util.List;

public class JavaStream {

	public static void main(String[] args) {

		 ListValuePrinter(List.of(10, 20, 25, 259, 251, 35, 52, 15, 2165, 31,77,89));
		// CourseValuePrinter(List.of("Spring Boot", "Spring MVC", "Spring Microservices", "Spring Rest", "Java", "Python", "MongoDB"));

	}

	/*public static void ListValuePrinter(List<Integer> numbers) {

		numbers.stream().forEach(System.out::println);

	}*/
	
	/*public static boolean isEven(int number) {
		return number%2==0?true:false;
	}

	// using filter inside stream
	public static void ListValuePrinter(List<Integer> numbers) {

		numbers
		.stream()
		.filter(JavaStream::isEven)
		.forEach(System.out::println);

	}*/
	
	// Lambda expression
	/*public static void ListValuePrinter(List<Integer> numbers) {

		numbers
		.stream()
		.filter(n -> n%2==0?true:false) // filter always takes lambdas that returns BOOLEAN value
		.forEach(System.out::println);

	}*/
	
	/*
	 * 1. find the courses containing word 'Spring'
	 * 2. find course name has 10 letters
	 * */
	/*private static void CourseValuePrinter(List<String> course) {

		course
		.stream()
		.filter(c-> c.contains("Spring"))
		.filter(c -> c.length()>10)
		.forEach(System.out::println);
	}*/
	
	/*
	 * Using stream mapping
	 * */
	public static void ListValuePrinter(List<Integer> numbers) {

		numbers
		.stream()
		.filter(n -> n%2!=0?true:false) 
		.map(n -> n*n) // accepts methods and maps to the variable
		.forEach(System.out::println);

	}
}
