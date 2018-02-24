package com.project.prac.basic.programming.inputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagrams {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int t;
		t = s.nextInt();

		String a[] = new String[t];
		String b[] = new String[t];
		int anagrams[] = new int[t];
		
		for(int i = 0; i < t; i++) {
			a[i] = s.next();
			b[i] = s.next();
		}
		
		for(int i=0; i<t; i++) {
			anagrams[i] = getAnagrams(a[i], b[i]);
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(anagrams[i]);
		}
		
	}
	
	public static int getAnagrams(String a, String b) {
		/*System.out.println("String a is : "+a);
		System.out.println("String b is : "+b);*/
		
		//System.out.println(Arrays.toString(a.split("")));
		List<String> listA = new ArrayList<String>();
		listA.addAll(Arrays.asList(a.split("")));
		int sizeA = listA.size();
		List<String> listB = new ArrayList<String>(); 
		listB.addAll(Arrays.asList(b.split("")));
		int sizeB = listB.size();
		listA.retainAll(listB);
		//System.out.println(Arrays.toString(listA.toArray(new String[listA.size()])));
		return ((sizeA+sizeB)-(listA.size()*2));
	}

}
