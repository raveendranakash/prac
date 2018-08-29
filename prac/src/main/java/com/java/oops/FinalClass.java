package com.java.oops;

import java.util.HashMap;
import java.util.Iterator;

public final class FinalClass {

	void methodOfFinalClass(){
		
	}
	
	private final int id;
	
	private final String name;
	
	private final HashMap<String,String> testMap;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * Accessor function for mutable objects
	 */
	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	/**
	 * Constructor performing Deep 
	 * @param i
	 * @param n
	 * @param hm
	 */
	/*public FinalClass(int i, String n, HashMap<String,String> hm){
		System.out.println("Performing Deep  for Object initialization");
		this.id=i;
		this.name=n;
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap=tempMap;
	}*/
	
	
	/**
	 * Constructor performing Shallow 
	 * @param i
	 * @param n
	 * @param hm
	 */
	public FinalClass(int i, String n, HashMap<String,String> hm){
		System.out.println("Performing Shallow  for Object initialization");
		this.id=i;
		this.name=n;
		this.testMap=hm;
	}
	
	
	/**
	 * To test the consequences of Shallow  and how to avoid it with Deep  for creating immutable classes
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		
		String s = "original";
		
		int i=10;
		
		FinalClass finalClass = new FinalClass(i,s,h1);
		
		//Lets see whether its copy by field or reference
		System.out.println("s==finalClass.getName() : "+(s==finalClass.getName()));
		System.out.println("h1 == finalClass.getTestMap() : "+(h1 == finalClass.getTestMap()));
		//print the ce values
		System.out.println("finalClass id:"+finalClass.getId());
		System.out.println("finalClass name:"+finalClass.getName());
		System.out.println("finalClass testMap:"+finalClass.getTestMap());
		//change the local variable values
		i=20;
		s="modified";
		h1.put("3", "third");
		//print the values again
		System.out.println("finalClass id after local variable change:"+finalClass.getId());
		System.out.println("finalClass name after local variable change:"+finalClass.getName());
		System.out.println("finalClass testMap after local variable change:"+finalClass.getTestMap());
		
		HashMap<String, String> hmTest = finalClass.getTestMap();
		hmTest.put("4", "new");
		
		System.out.println("finalClass testMap after changing variable from accessor methods:"+finalClass.getTestMap());

	}


}
