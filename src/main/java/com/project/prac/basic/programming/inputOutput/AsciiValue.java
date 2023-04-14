package com.project.prac.basic.programming.inputOutput;

import java.util.Scanner;

public class AsciiValue {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		char C;
		
		C = s.next().toCharArray()[0];
		
		int asciiValue = C;
		System.out.println(/*"The Ascii value of character is "*/+asciiValue);
	}

}
