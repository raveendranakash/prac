package com.project.prac.basic.programming.inputOutput;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String s1 = new String("JAVA");

		System.out.println("Before concatenation : "+s1);

		System.out.println("Before concatenation using concat func : "+s1.concat("J2EE"));
		s1 = s1.concat("J2EE");

		System.out.println("After concatenation : "+s1); 
    	
    }
}
