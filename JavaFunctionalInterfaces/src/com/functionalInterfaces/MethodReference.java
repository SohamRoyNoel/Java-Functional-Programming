package com.functionalInterfaces;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

import com.functionalInterfaces.functionalInterfaceDemo.ConstructorReference;

public class MethodReference {

	public static void main(String[] args) {
		
		List<Integer> xyz = List.of(1,2,3,4,5,6,7,9);
		xyz
		.stream()
		.forEach(MethodReference::StaticMethodReference);
		
		// constructor reference :: NO PARAMETER CONSTRUCTOR
		Supplier noParamConst = ConstructorReference::new;
		noParamConst.get(); // Empty constructor

		// constructor reference with parameter :: NO PARAMETER CONSTRUCTOR
		Function<Integer, ConstructorReference> consts = (integerNum) -> new ConstructorReference(integerNum);
		consts.apply(15);
		
		
	}

	public static void StaticMethodReference(Integer oneParam) {
		System.out.println("StaticMethodReference : " + oneParam);
	}
	
	
}
