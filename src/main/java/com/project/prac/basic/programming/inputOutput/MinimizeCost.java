package com.project.prac.basic.programming.inputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinimizeCost {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N;
		int K;
		
		N = s.nextInt();
		K = s.nextInt();
		
		Integer mainArray[] = new Integer[N];
		Integer negativeArray[];
		Integer positiveArray[];
		int transferArray[] = new int[K+1];
		List<Integer> negativeList = new ArrayList<Integer>();
		List<Integer> positiveList = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			mainArray[i] = s.nextInt();
			if(mainArray[i] < 0) {
				negativeList.add(mainArray[i]);
			} else if(mainArray[i] > 0){
				positiveList.add(mainArray[i]);
			}
		}
		negativeArray = negativeList.toArray(new Integer[negativeList.size()]);
		
		Integer negativeMagnitudeArray[];
		
		negativeMagnitudeArray = negativeList.toArray(new Integer[negativeList.size()]);
		
		for(int i=0; i<negativeMagnitudeArray.length; i++) {
			negativeMagnitudeArray[i] *= -1;
		}
		
		/*System.out.println("Before sorting negative array: "+Arrays.toString(negativeArray));
		System.out.println("Before sorting negative magnitude array: "+Arrays.toString(negativeMagnitudeArray));
		System.out.println("Before sorting main array: "+Arrays.toString(mainArray));*/
		
		quickSort(mainArray, 0, (mainArray.length-1));
		quickSort(negativeMagnitudeArray, 0, (negativeMagnitudeArray.length-1));
		
		positiveList.remove(mainArray[mainArray.length-1]);
		positiveArray = positiveList.toArray(new Integer[positiveList.size()]);
		System.out.println("Contents in positive array: "+Arrays.toString(positiveArray));
		
		System.out.println("After sorting negative magnitude array: "+Arrays.toString(negativeMagnitudeArray));
		System.out.println("After sorting main array: "+Arrays.toString(mainArray));
		
		System.out.println("Largest value in main array is : "+mainArray[mainArray.length-1]);
		System.out.println("Largest value in negative magnitude array is : "+negativeMagnitudeArray[0]);
		
		
		transferArray[0] = mainArray[mainArray.length-1]*(-1);
		transferArray[1] = negativeMagnitudeArray[0];
		int residue = mainArray[mainArray.length-1]-negativeMagnitudeArray[0];
		
		if(K>1){
			for(int i=2; i<=K; i++){
				transferArray[i] = residue;
				if((transferArray[i]-residue)>0){
					residue = transferArray[i]-residue;
				} else if(residue==0){
					break;
				}
			}
		}
		
		int sum = transferArray[0]+mainArray[mainArray.length-1];
		
		if(positiveArray.length>0){
			for(int i=0; i<positiveArray.length;i++){
				sum += positiveArray[i];
			}
		}
		
		for(int i=transferArray.length; i<negativeArray.length;i++){
			for(int j=0; j<transferArray.length;j++){
				sum += ((negativeMagnitudeArray[j]*-1)+transferArray[i+1]);
			}
			sum += (negativeMagnitudeArray[i]*-1);
		}
		
		System.out.println("Original array : "+Arrays.toString(mainArray));
		System.out.println("Transfer array : "+Arrays.toString(transferArray));
		
		System.out.println(/*"The cost C(x) = "*/+sum);
		
	}
	
	public static int partition(Integer arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    public static void quickSort(Integer arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

}
