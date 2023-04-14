package com.project.prac.basic.programming.inputOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		int N;
		N = s.nextInt();
		
		if(N<1 || N>1000) {
			throw new Exception("The input number should not be greater than 1000 or less than 1");
		}
		
		List<Integer> primeNumberList = new ArrayList<Integer>();
		List<Integer> compositeNumberList = new ArrayList<Integer>();
		
		if(N>=2)
			primeNumberList.add(2);
		
		for(int i=2;i<=N;i++) {
			if((i%2)!=0) {
				primeNumberList.add(i);
			}
		}
		
		for(Integer number: primeNumberList){
			for(int i=2;i<(number/2);i++) {
				if((number%i)==0){
					compositeNumberList.add(number);
				}
			}
		}
		
		primeNumberList.removeAll(compositeNumberList);
		
		for(Integer number: primeNumberList) {
			System.out.print(number+" ");
		}
	}

}
