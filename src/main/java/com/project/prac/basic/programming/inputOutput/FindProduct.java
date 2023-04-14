package com.project.prac.basic.programming.inputOutput;

import java.util.Scanner;

public class FindProduct {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int N;
		
		N = s.nextInt();
		
		int answer = 1;
		int moduloArray[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			moduloArray[i] = s.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			answer = (answer*moduloArray[i]) % ((int)(Math.pow(10, 9))+7);
		}
		
		System.out.println(answer);
	}

}
