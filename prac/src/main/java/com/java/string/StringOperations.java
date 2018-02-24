package com.java.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringOperations {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("ab");
		builder.append("c");
		
		StringBuffer buffer = new StringBuffer("ab");
		buffer.append("c");
		
		String abcLiteral = "abc";
		String abcLiteral2 = "abc";
		String defLiteral = "defLiteral";
		String abcObject = new String("abc");
		String copyOfAbc = abcObject;
		String bufferString = new String(buffer);
		String builderString = new String(builder);
		
		// OPERATIONS ON STRING
		
		System.out.print("abcLiteral == abcLiteral2  --> ");
		System.out.println(abcLiteral==abcLiteral2);
		System.out.println("abcLiteral.equals(abcLiteral2)  --> "+abcLiteral.equals(abcLiteral2));
		
		System.out.print("abcLiteral == defLiteral  --> ");
		System.out.println(abcLiteral==defLiteral);
		System.out.println("abcLiteral.equals(defLiteral)  --> "+abcLiteral.equals(defLiteral));
		
		System.out.print("abcLiteral == abcObject  --> ");
		System.out.println(abcLiteral==abcObject);
		System.out.println("abcLiteral.equals(abcObject)  --> "+abcLiteral.equals(abcObject));
		
		System.out.print("defLiteral == abcObject  --> ");
		System.out.println(defLiteral==abcObject);
		System.out.println("defLiteral.equals(abcObject)  --> "+defLiteral.equals(abcObject));
		
		System.out.print("copyOfAbc == abcObject  --> ");
		System.out.println(copyOfAbc==abcObject);
		System.out.println("copyOfAbc.equals(abcObject)  --> "+copyOfAbc.equals(abcObject));
		
		System.out.print("bufferString == abcObject  --> ");
		System.out.println(bufferString==abcObject);
		System.out.println("bufferString.equals(abcObject)  --> "+bufferString.equals(abcObject));
		
		System.out.print("bufferString == defLiteral  --> ");
		System.out.println(bufferString==defLiteral);
		System.out.println("bufferString.equals(defLiteral)  --> "+bufferString.equals(defLiteral));
		
		System.out.print("bufferString == abcLiteral  --> ");
		System.out.println(bufferString==abcLiteral);
		System.out.println("bufferString.equals(abcLiteral)  --> "+bufferString.equals(abcLiteral));
		
		System.out.print("builderString == abcObject  --> ");
		System.out.println(builderString==abcObject);
		System.out.println("builderString.equals(abcObject)  --> "+builderString.equals(abcObject));
		
		System.out.print("builderString == defLiteral  --> ");
		System.out.println(builderString==defLiteral);
		System.out.println("builderString.equals(defLiteral)  --> "+builderString.equals(defLiteral));
		
		System.out.print("builderString == abcLiteral  --> ");
		System.out.println(builderString==abcLiteral);
		System.out.println("builderString.equals(abcLiteral)  --> "+builderString.equals(abcLiteral));
		
		System.out.print("builderString == bufferString  --> ");
		System.out.println(builderString==bufferString);
		System.out.println("builderString.equals(bufferString)  --> "+builderString.equals(bufferString));
		
		String str1 = "fdsfr";
		String str2 = "gfagg";
		
		System.out.println(Arrays.toString(str1.split("")));
		List<String> list = new ArrayList<String>(); 
		list.addAll(Arrays.asList(str1.split("")));	
		List<String> anotherList = new ArrayList<String>(); 
		anotherList.addAll(Arrays.asList(str2.split(""))); 
		list.retainAll(anotherList);
		System.out.println(Arrays.toString(list.toArray(new String[list.size()]))); 
		
		
	}
	
}
