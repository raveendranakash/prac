package com.project.prac.basic.programming.inputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MagicalWord {
	
	static Scanner s = new Scanner(System.in) ;
	//static String asciiStringArray[] = {"C","G","I","O","S","Y","a","e","g","k","m","q"};
	static Integer asciiIntegerArray[] = {67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113};
	static char asciiStringArray[] = {'C','G','I','O','S','Y','a','e','g','k','m','q'};
	
	public static void main(String[] args) {
		int T;
		int N;
		
		T = s.nextInt();
		List<String> magicWordList = new ArrayList<String>(); 
		
		String stringArray[] = new String[T];
		int stringLengthArray[] = new int[T];
		Map<String, char[]> stringMap = new LinkedHashMap<String, char[]>();
		
		for(int i=0;i<T;i++) {
			stringLengthArray[i] = s.nextInt();
			String word = s.next();
			// stringMap.put(word, word.split(""));
			stringMap.put(word, word.toCharArray());
			//stringArray[i] = word;
			
		}
		
		/*System.out.print("The string array looks like : [");
		for(int i=0;i<T;i++){
			System.out.print(stringArray[i]);
			if(i<T-1)
        		System.out.print(", ");
		}
		System.out.println("]");
		System.out.println("The string length array looks like : "+Arrays.toString(stringLengthArray));*/
		
		
		for(Map.Entry<String, char []> entry: stringMap.entrySet()){
			//System.out.println("Key is : "+entry.getKey());
			//System.out.println("Value is : "+entry.getValue().toString());
			String string = "";
			for(char alphabet : entry.getValue()) {
				string += String.valueOf(closestMagicAlphabet(alphabet));
				//asciiIntegerArray.
			}
			magicWordList.add(string);
		}
		
		for(String str: magicWordList) {
			System.out.println(str);
			//System.out.println(str.length());
		}
		
	}
	
	
	public static char closestMagicAlphabet(char alphabet) {
		int asciiCode = (int)alphabet;
		int closestInteger;
		Map<Integer, Integer> differenceMap = new HashMap<Integer, Integer>();
		differenceMap.put(67, Math.abs(67-asciiCode));
		//	System.out.println("Key : 67 Value : "+Math.abs(67-asciiCode));
		differenceMap.put(71, Math.abs(71-asciiCode));
		//	System.out.println("Key : 71 Value : "+Math.abs(71-asciiCode));
		differenceMap.put(73, Math.abs(73-asciiCode));
		//	System.out.println("Key : 73 Value : "+Math.abs(73-asciiCode));
		differenceMap.put(79, Math.abs(79-asciiCode));
		//	System.out.println("Key : 79 Value : "+Math.abs(79-asciiCode));
		differenceMap.put(83, Math.abs(83-asciiCode));
		//	System.out.println("Key : 83 Value : "+Math.abs(83-asciiCode));
		differenceMap.put(89, Math.abs(89-asciiCode));
		//	System.out.println("Key : 89 Value : "+Math.abs(89-asciiCode));
		differenceMap.put(97, Math.abs(97-asciiCode));
		//	System.out.println("Key : 97 Value : "+Math.abs(97-asciiCode));
		differenceMap.put(101, Math.abs(101-asciiCode));
		//	System.out.println("Key : 101 Value : "+Math.abs(101-asciiCode));
		differenceMap.put(103, Math.abs(103-asciiCode));
		//	System.out.println("Key : 103 Value : "+Math.abs(103-asciiCode));
		differenceMap.put(107, Math.abs(107-asciiCode));
		//	System.out.println("Key : 107 Value : "+Math.abs(107-asciiCode));
		differenceMap.put(109, Math.abs(109-asciiCode));
		//	System.out.println("Key : 109 Value : "+Math.abs(109-asciiCode));
		differenceMap.put(113, Math.abs(113-asciiCode));
		//	System.out.println("Key : 113 Value : "+Math.abs(113-asciiCode));
		
		SortedSet<Integer> sortedDiffSet = new TreeSet<Integer>(differenceMap.values());
		//	System.out.println("Sorted diff set : "+Arrays.toString(sortedDiffSet.toArray(new Integer[sortedDiffSet.size()])));
		Set<Integer> diffKeySet = getKeysByValue(differenceMap, sortedDiffSet.first());
		//	System.out.println("Diff key set : "+Arrays.toString(diffKeySet.toArray(new Integer[diffKeySet.size()])));
		if(diffKeySet.size()>1){
			SortedSet<Integer> sortedDiffKeySet = new TreeSet<Integer>(diffKeySet);
			closestInteger = sortedDiffKeySet.first();
		} else {
			closestInteger = diffKeySet.toArray(new Integer[diffKeySet.size()])[0];
		}
		// Arrays.asList(asciiIntegerArray).indexOf(closestInteger);
		// asciiStringArray[Arrays.asList(asciiIntegerArray).indexOf(closestInteger)];
		return asciiStringArray[Arrays.asList(asciiIntegerArray).indexOf(closestInteger)];
	}
	
	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
	    Set<T> keys = new HashSet<T>();
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
	
}
