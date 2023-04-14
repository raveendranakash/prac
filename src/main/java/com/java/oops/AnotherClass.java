package com.java.oops;

public class AnotherClass {

	public final void play(){
		System.out.println("Play method of Another class");
	}
	
	private final String finalVariable = "das";
	
	public String getFinalVariable() {
		return finalVariable;
	}
	
	public void someMethod(){
		//finalVariable = "abc";    // COMPILE TIME ERROR
	}

	public static void main(String[] args) {
		
	}
	
}
