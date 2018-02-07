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
	static Integer asciiIntegerArray[] = {67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113};
	static char asciiStringArray[] = {'C','G','I','O','S','Y','a','e','g','k','m','q'};
	
	public static void main(String[] args) {
		int T;
		
		T = s.nextInt();
		List<String> magicWordList = new ArrayList<String>(); 
		
		int stringLengthArray[] = new int[T];
		Map<String, char[]> stringMap = new LinkedHashMap<String, char[]>();
		
		for(int i=0;i<T;i++) {
			stringLengthArray[i] = s.nextInt();
			String word = s.next();
			stringMap.put(word, word.toCharArray());
			
		}
		
		for(Map.Entry<String, char []> entry: stringMap.entrySet()){
			String string = "";
			for(char alphabet : entry.getValue()) {
				string += String.valueOf(closestMagicAlphabet(alphabet));
			}
			magicWordList.add(string);
		}
		
		for(String str: magicWordList) {
			System.out.println(str);
		}
		
	}
	
	
	public static char closestMagicAlphabet(char alphabet) {
		int asciiCode = (int)alphabet;
		int closestInteger;
		Map<Integer, Integer> differenceMap = new HashMap<Integer, Integer>();
		differenceMap.put(67, Math.abs(67-asciiCode));
		differenceMap.put(71, Math.abs(71-asciiCode));
		differenceMap.put(73, Math.abs(73-asciiCode));
		differenceMap.put(79, Math.abs(79-asciiCode));
		differenceMap.put(83, Math.abs(83-asciiCode));
		differenceMap.put(89, Math.abs(89-asciiCode));
		differenceMap.put(97, Math.abs(97-asciiCode));
		differenceMap.put(101, Math.abs(101-asciiCode));
		differenceMap.put(103, Math.abs(103-asciiCode));
		differenceMap.put(107, Math.abs(107-asciiCode));
		differenceMap.put(109, Math.abs(109-asciiCode));
		differenceMap.put(113, Math.abs(113-asciiCode));
		
		SortedSet<Integer> sortedDiffSet = new TreeSet<Integer>(differenceMap.values());
		Set<Integer> diffKeySet = getKeysByValue(differenceMap, sortedDiffSet.first());
		if(diffKeySet.size()>1){
			SortedSet<Integer> sortedDiffKeySet = new TreeSet<Integer>(diffKeySet);
			closestInteger = sortedDiffKeySet.first();
		} else {
			closestInteger = diffKeySet.toArray(new Integer[diffKeySet.size()])[0];
		}
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
