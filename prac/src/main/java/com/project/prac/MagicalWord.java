package com.project.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MagicalWord {
	
	static Scanner s = new Scanner(System.in) ;
	static String asciiArray[] = {"C","G","I","O","S","Y","a","e","g","k","m","q"};
	
	public static void main(String[] args) {
		int T;
		int N;
		
		T = s.nextInt();
		List<String> asciiList = Arrays.asList(asciiArray); 
		
		String stringArray[] = new String[T];
		int stringLengthArray[] = new int[T];
		Map<String, String[]> stringMap = new HashMap<String, String[]>();
		
		for(int i=0;i<T;i++) {
			stringLengthArray[i] = s.nextInt();
			String word = s.next();
			stringMap.put(word, word.split(""));
			stringArray[i] = word;
		}
		
		System.out.print("The string array looks like : [");
		for(int i=0;i<T;i++){
			System.out.print(stringArray[i]);
			if(i<T-1)
        		System.out.print(", ");
		}
		System.out.println("]");
		System.out.println("The string length array looks like : "+Arrays.toString(stringLengthArray));
		
		List<String> valueList;
		for(Map.Entry<String, String []> entry: stringMap.entrySet()){
			valueList = Arrays.asList(entry.getValue());
		}
		
		
	}
	
}
