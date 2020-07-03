package com.functionalInterfaces;

import com.functionalInterfaces.functionalInterfaceDemo.FunctionalInterfaceDemo;

/*
 * FunctionalInterface : an interface that has exactly 1 abstract method
 * */

public class FunctionalInterface {

	public static void main(String[] args) {
			
		/*
		 * Provide Implementation
		 * */
		FunctionalInterfaceDemo newFid = new FunctionalInterfaceDemo() {
			
			@Override
			public void demoInterface() {
								
			}
		};
		
		FunctionalInterface fi = new FunctionalInterface();
		fi.functional(() -> System.out.println("hello world"));
		
//		newFid.demoInterface(() -> System.out.println("hello world"));

	}
	
	public void functional(FunctionalInterfaceDemo functionalInterfaceDemo) {
		functionalInterfaceDemo.demoInterface();
	}

}
