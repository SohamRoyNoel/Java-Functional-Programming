package com.functionalInterfaces;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;


/*
 * 
 * Supplier doesnt take value rather returns something
 * 
 * */

public class SupplierAndUnaryOperator {

	public static void main(String[] args) {
		
		// supplier
		Supplier<Integer> newRandomInteger = () -> {
			Random rand = new Random();
			return rand.nextInt();
		};

		System.out.println(newRandomInteger.get());
		
		// binary operator
		BinaryOperator<Integer> bins = (x,y) -> x+y;
		System.out.println(bins.apply(5, 6));
		
		// UnaryOperator
		UnaryOperator<String> concatStr = (x) -> "New String " + x;
		System.out.println(concatStr.apply("Nathan Drake"));
		
		// BiPredicate : always returns BOOLEAN 
		BiPredicate<List<String>, List<String>> newPredicate = (list1, list2) -> {
			
			return list1
			.stream()
			.allMatch(n -> list2.containsAll(list1));
			
		};
		
		List<String> l1 = List.of("Java", "Python", "Spring");
		List<String> l2 = List.of("Java9", "Pythons", "Spring Boot");
		System.err.println("BiPredicate " +newPredicate.test(l1, l2));
		
		// BiFunction : returns Anything :: BiFunction<T, U, R> [T,U are PARAMETER; R is return type]
		BiFunction<Stream<String>, Stream<String>, Stream<String>> appendedList = (list1, list2) -> {
			return Stream.concat(list1, list2);
		};
		
		Stream<String> stream1 = Stream.of("Java", "Python", "Spring");
		Stream<String> stream2 = Stream.of("Java9", "Pythons", "Spring Boot");
		Stream<String> append = appendedList.apply(stream1, stream2);
		append
		.forEach(System.err::println);
		
		// BiConsumer :: Consumes anything doesnt return anything 
		BiConsumer<String, String> biconsumers = (x,y) -> {
			System.out.println("x : " + x);
			System.out.println("y : " + y);
		};
		biconsumers.accept("Arther Morgan", "Nathan Drake");
	}

}
