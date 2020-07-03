package com.functionalInterfaces;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/*
 * Predicate : expression
 * Function : takes value returns value
 * Consumer : takes input doesnt return anything back
 * */
public class BehavioralParameterization {

	public static void main(String[] args) {

		List<Integer> newList = List.of(10, 20, 25,12,126,190, 259, 251, 35, 52, 15, 2165, 31,77,89);
		List<String> courses =List.of("Spring Boot", "Spring MVC", "Spring Microservices", "Spring Rest", "Java", "Python", "MongoDB");

		//Predicate<? super Integer> EvenPredicate = x -> x%2==0;
//		extracted(newList, x -> x%2==0);
		//Predicate<? super Integer> GeneralPredicate = x -> x%2!=0;
//		extracted(newList, x -> x%2!=0);

		// Collection
//		Predicate<? super Integer> EvenPredicate = x -> x%2==0;
//		Comparator<Integer> reverseOrder = Comparator.reverseOrder();
		extracted(newList, x -> x%2==0, Comparator.reverseOrder());
		
		System.out.println();
		
//		Predicate<? super Integer> OddPredicate = x -> x%2!=0;
//		Comparator<Integer> naturalOrder = Comparator.naturalOrder();
		extracted(newList, x -> x%2!=0, Comparator.naturalOrder());
		
		/*
		 * Collect
		 * */
//		Predicate<? super String> ParamPredicate = x-> x.contains("B");
//		Function<? super String, ? extends Integer> PredicateFunction = x -> x.length();
//		Comparator<String> naturalOrder = Comparator.naturalOrder();
		List<Integer> newlists = extracted(courses, x-> x.contains("B"), x -> x.length(), Comparator.naturalOrder());
		
		System.err.println(newlists);
		/*
		 * Consumer : takes input doesnt return anything back
		 * */
		Consumer<? super Integer> consumer = System.out::println;
		extracted(newList, consumer);
	}

	private static void extracted(List<Integer> newList, Consumer<? super Integer> consumer) {
		newList
		.stream()
		.distinct()
		.sorted()
		.forEach(consumer);
	}

	private static List<Integer> extracted(List<String> courses, Predicate<? super String> ParamPredicate,
			Function<? super String, ? extends Integer> PredicateFunction, Comparator<String> naturalOrder) {
		return courses
		.stream() // get the stream		
		.filter(ParamPredicate)
		.sorted(naturalOrder) // sort by length first
		.map(PredicateFunction)
		.collect(Collectors.toList());
	}

	private static void extracted(List<Integer> newList, Predicate<? super Integer> OddPredicate,
			Comparator<Integer> naturalOrder) {
		newList
		.stream()
		.filter(OddPredicate)
		.distinct()
		.sorted(naturalOrder)
		.forEach(System.out::println);
	}

	// generate by selecting stream -> refactor -> generate method
	private static void extracted(List<Integer> newList, Predicate<? super Integer> GeneralPredicate) {
		newList
		.stream()
		.filter(GeneralPredicate)
		.map(y -> y * y)
		.forEach(System.out::println);
	}
	
	
	
}
