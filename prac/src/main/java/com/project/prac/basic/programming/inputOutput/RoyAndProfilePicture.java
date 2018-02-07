package com.project.prac.basic.programming.inputOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class RoyAndProfilePicture {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String args[] ) throws Exception {
        int L;
        int N;
        
        L = s.nextInt();
        N = s.nextInt();
        
        if(N > 1000){
        	s.close();
        	throw new Exception("Not permitted to upload more than 1000 photos");
        }
        int photoArray[][] = new int[N][2];
        
        for(int i=0;i<N;i++) {
        	photoArray[i][0] = s.nextInt();
        	if (photoArray[i][0] > 10000) {
        		throw new Exception("Dimensions of photo must not exceed 10000 units");
        	}
        	photoArray[i][1] = s.nextInt();
        	if (photoArray[i][1] > 10000) {
        		throw new Exception("Dimensions of photo must not exceed 10000 units");
        	}
        }
        
        s.close();
        
        /*System.out.print("The array looks like : [");
        for(int i=0;i<N;i++){
        	System.out.print("("+photoArray[i][0]+","+photoArray[i][1]+")");
        	if(i<N-1)
        		System.out.print(",");
        }
        System.out.println("]");*/
        
        for(int i=0;i<N;i++) {
        	if((photoArray[i][0]==photoArray[i][1]) &&
        		(photoArray[i][0] >= L && photoArray[i][1] >= L)) {
                System.out.println("ACCEPTED"/*+" "+photoArray[i][0]+" "+photoArray[i][1]*/);
            }
            
            if((photoArray[i][0] < L && photoArray[i][1] < L) || 
                (photoArray[i][0] >= L && photoArray[i][1] < L) ||
                (photoArray[i][0] < L && photoArray[i][1] >= L)) {
                System.out.println("UPLOAD ANOTHER"/*+" "+photoArray[i][0]+" "+photoArray[i][1]*/);
            }
            
            if((photoArray[i][0]!=photoArray[i][1]) &&
            	(photoArray[i][0] >= L && photoArray[i][1] >= L)) {
                System.out.println("CROP IT"/*+" "+photoArray[i][0]+" "+photoArray[i][1]*/);
            }
        }
        
    }
    
}
