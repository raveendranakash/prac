package com.java.oops;

public class Umbrella implements ParentInterface{

	public Umbrella(){
		System.out.println("Inside Umbrella class constructor");
		StaticClass staticClass = new StaticClass();
		InnerClass innerClass = new InnerClass();
	}
	
	public static void main(String[] args) {
		Umbrella u = new Umbrella();
		InnerClass innerClass = u.new InnerClass();
		StaticClass staticClass = new StaticClass();
	}
	
	public class InnerClass{
		public InnerClass(){
			System.out.println("Inside InnerClass class constructor");
		}
	}
	
	
	public static class StaticClass{
		public StaticClass(){
			System.out.println("Inside StaticClass class constructor");
		}
	}


	public void nameOfParent() {
		
	}

	public void nameOfAnotherParent() {
		
	}
}
