package com.functionalInterfaces.functionalInterfaceDemo;

public class ConstructorReference {
	
	private int x;
	

	public ConstructorReference(int x) {
		this.x = x;
		System.err.println("From Parameterized Constructor : " + x);
	}
	
	public ConstructorReference() {
		System.err.println("Empty constructor");
	}
	
}
