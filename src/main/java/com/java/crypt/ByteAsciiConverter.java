package com.java.crypt;

import com.java.util.Log;

import java.util.Arrays;

public class ByteAsciiConverter {

    public static void main(String[] args) {
        byte[] bytes = {87, 105, 84, 18, 23, 110, 71, -33, 30, 17, -105, 42, 74, -109, 77, -29};
        char[] chars = convertByteArrayToAsciiArray(bytes);
        Log.print(String.valueOf(chars));
        byte[] bytesConverted = convertAsciiArrayToByteArray(chars);
        printByteArray(bytesConverted);
    }

    public static char[] convertByteArrayToAsciiArray(byte[] byteArray){
        char[] charArray = new char[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            charArray[i] = (char)byteArray[i];
        }
        return charArray;
    }

    public static byte[] convertAsciiArrayToByteArray(char[] charArray){
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte)charArray[i];
        }
        return byteArray;
    }

    public static void printByteArray(byte[] byteArr){
        Log.print(Arrays.toString(byteArr));
    }

}
