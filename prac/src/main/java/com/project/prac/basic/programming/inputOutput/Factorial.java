package com.project.prac.basic.programming.inputOutput;

import java.util.Scanner;

public class Factorial {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		
		int N;
		N = s.nextInt();
		if(N<1 || N>10) {
			throw new Exception("The input number must be between 1 and 10");
		}
		
		System.out.println(factorial(N));
	}
	
	public static int factorial(int n){
		if(n==1)
			return 1;
		return n*factorial(n-1);
	}

}
