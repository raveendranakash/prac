package com.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingExample {
	
	public static void main(String[] args) {
		simpleSorting();  // WORKS FINE
		//employeeSorting();  // GIVES ERROR : java.lang.ClassCastException: com.java.collections.Employee cannot be cast to java.lang.Comparable
		comparableEmployeeSorting();  // WORKS FINE
	}

	public static void simpleSorting() {
		int[] intArr = {11,4,533,53,23};
		Arrays.sort(intArr);
		System.out.println("The sorted integer array is : "+Arrays.toString(intArr));
		
		String[] stringArr = {"A","K","A","S","H"};
		Arrays.sort(stringArr);
		System.out.println("The sorted string array is : "+Arrays.toString(stringArr));
		
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("K");
		list.add("A");
		list.add("S");
		list.add("H");
		Collections.sort(list);
		System.out.println("The sorted list is : "+Arrays.toString(list.toArray(new String[list.size()])));
	}
	
	public static void employeeSorting() {
		Employee[] employeeArr = new Employee[3];
		employeeArr[0] = new Employee("abc",1,5000L);
		employeeArr[1] = new Employee("pqr",2,2000L);
		employeeArr[2] = new Employee("xyz",3,3000L);
		
		Arrays.sort(employeeArr);
		System.out.println("The sorted employee array is : "+Arrays.toString(employeeArr));
	}
	
	
	public static void comparableEmployeeSorting() {
		CompareEmployee[] employeeArr = new CompareEmployee[3];
		employeeArr[0] = new CompareEmployee("abc",1,5000L);
		employeeArr[1] = new CompareEmployee("pqr",2,2000L);
		employeeArr[2] = new CompareEmployee("xyz",3,3000L);
		
		Arrays.sort(employeeArr);
		System.out.println("The sorted employee array is : "+Arrays.toString(employeeArr));
		
		Arrays.sort(employeeArr, CompareEmployee.NameComparator);
		System.out.println("The sorted employee array by name is : "+Arrays.toString(employeeArr));
		
		Arrays.sort(employeeArr, CompareEmployee.SalaryComparator);
		System.out.println("The sorted employee array by salary is : "+Arrays.toString(employeeArr));
		
	}
}
