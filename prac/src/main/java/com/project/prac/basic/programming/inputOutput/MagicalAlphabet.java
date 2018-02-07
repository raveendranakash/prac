package com.project.prac.basic.programming.inputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MagicalAlphabet {

	static Integer checkPrime(int n){  
		  int i,m=0,flag=0;
		  int primeNumber = 0;
		  m=n/2;      
		  if(n==0||n==1){  
		   return null;     
		  }else{  
		   for(i=2;i<=m;i++){      
		    if(n%i==0){      
		     flag=1;      
		     break;      
		    }      
		   }      
		   if(flag==0)  { return primeNumber = n; }  
		  }
		  if(primeNumber>0)
			  return Integer.valueOf(primeNumber);
		  else
			  return null;
		}  

	
	public static void main(String[] args) {
		int smallAlphaStartNum = 65;
		int smallAlphaEndNum = 90;
		int capsAlphaStartNum = 97;
		int capsAlphaEndNum = 122;
		
		List<Integer> primeNumbers = new ArrayList<Integer>();
		Integer num;
		for (int i=smallAlphaStartNum; i<=smallAlphaEndNum; i++) {
			num = checkPrime(i);
			if(num!= null)
				primeNumbers.add(num);
		}
		
		for (int i=capsAlphaStartNum; i<=capsAlphaEndNum;i++) {
			num = checkPrime(i);
			if(num!= null)
				primeNumbers.add(num);
		}
		
		Integer primeArray[] = primeNumbers.toArray(new Integer[primeNumbers.size()]);
		System.out.println("The prime numbers are : "+ Arrays.toString(primeArray));
		
	}
	
}
