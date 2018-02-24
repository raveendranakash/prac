package com.project.prac.basic.programming.inputOutput;

import java.util.Scanner;

public class CountDivisors {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		
		int l, r, k;
		
		l = s.nextInt();
		r = s.nextInt();
		k = s.nextInt();
		
		if(l<1 || r<1 || k<1 || l>1000 || r>1000 || k>1000) {
			throw new Exception("Entered numbers must be between 1 and 1000 (both inclusive)");
		}
		
		int largerNumber;
		int smallerNumber;
		
		if(l<r){
			largerNumber = r;
			smallerNumber = l;
		} else {
			largerNumber = l;
			smallerNumber = r;
		}
		
		int smallerNumberDivisors;
		int largerNumberDivisors;
		
		smallerNumberDivisors = smallerNumber/k;
		largerNumberDivisors = largerNumber/k;
		
		if((smallerNumber%k)==0) {
			System.out.println((largerNumberDivisors-smallerNumberDivisors)+1);
		} else {
			System.out.println(largerNumberDivisors-smallerNumberDivisors);
		}
		
	}

}
