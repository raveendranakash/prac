package com.project.prac.basic.programming.inputOutput;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Cipher {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		String S;
		int K;
		
		S = s.next();
		K = s.nextInt();
		
		char charArray[] = S.toCharArray();
		
		Map<Integer, String> upperCaseAlphaMap = new LinkedHashMap<Integer, String>();
		Map<Integer, String> lowerCaseAlphaMap = new LinkedHashMap<Integer, String>();
		Map<Integer, Integer> numbersMap = new LinkedHashMap<Integer, Integer>();
		Map<Integer, String> symbolsMap = new LinkedHashMap<Integer, String>();
		
		int index=1;
		for(char alphabet: charArray) {
			int asciiCode = (int)alphabet;
			String next="";
			int charValue;
			if(65 <= asciiCode && asciiCode <= 90) {
				charValue = asciiCode + (K % 26);
				encryptString(charValue, 90, 65, upperCaseAlphaMap, next, index);
			} else if(97 <= asciiCode && asciiCode <= 122) {
				charValue = asciiCode + (K % 26);
				encryptString(charValue, 122, 97, lowerCaseAlphaMap, next, index);
			}else if(48 <= asciiCode && asciiCode <= 57) {
				charValue = asciiCode + (K % 10);
				encryptString(charValue, 57, 48, numbersMap, next, index);
			} else {
				symbolsMap.put(index, String.valueOf(alphabet));
			}
			index++;
		}
		
		String encryptedOutput = "";
		for(int mapIndex=1; mapIndex<=S.length(); mapIndex++){
			if(upperCaseAlphaMap.containsKey(mapIndex)){
				encryptedOutput = createEncryptedOutput(encryptedOutput, upperCaseAlphaMap, mapIndex);
			} else if(lowerCaseAlphaMap.containsKey(mapIndex)){
				encryptedOutput = createEncryptedOutput(encryptedOutput, lowerCaseAlphaMap, mapIndex);
			} else if(numbersMap.containsKey(mapIndex)){
				encryptedOutput = createEncryptedOutput(encryptedOutput, numbersMap, mapIndex);
			} else {
				encryptedOutput = createEncryptedOutput(encryptedOutput, symbolsMap, mapIndex);
			}
		}
		
		System.out.println(encryptedOutput);
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> void encryptString(int charValue, int upperLimit, int lowerLimit, Map<Integer, T> map, String string, int i) {
		if(charValue>upperLimit){
			charValue = (charValue - upperLimit) + (lowerLimit-1);
		}
		string = String.valueOf( (char) charValue);
		map.put(i, (T) string);
	}
	
	
	public static <T> String createEncryptedOutput(String string, Map<Integer, T> map, int i) throws Exception {
		if(map.get(i)!=null){
			string += map.get(i);
		}
		return string;
	}

}
