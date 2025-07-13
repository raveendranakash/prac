package com.java.crypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AESEncryptDecrypt {

    static Scanner scanner = new Scanner(System.in);
    public static final String AES = "AES";
    public static final String CIPHER_PARAM = "AES/CFB8/NoPadding";
    public static final String FILE_PATH = "/home/akash/unix_shell_script_tutorial/ch1.txt";

    public static void main(String[] args) throws Exception {
        String inputPlainText = scanner.next();
        print("received text : "+inputPlainText);
        scanner.close();

        SecretKey key = generateKey();
        IvParameterSpec ivSpec = generateIV();

        byte[] encryptedText = encryptText(inputPlainText, key, ivSpec);
        print("encrypted cipher text : "+ Arrays.toString(encryptedText));

        String decryptedText = decryptText(encryptedText, key, ivSpec);
        print("decrypted plain text : "+decryptedText);

        readFile(FILE_PATH);
    }

    public static byte[] encryptText(String inputPlainText, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_PARAM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(inputPlainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String decryptText(byte[] cipherBytes, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception{
        Cipher cipher = Cipher.getInstance(CIPHER_PARAM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] decryptedPlainText = cipher.doFinal(cipherBytes);
        return new String(decryptedPlainText);
    }

    public static byte[] encryptFile(File inputFile,SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception{
        Cipher cipher = Cipher.getInstance(CIPHER_PARAM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(inputFile.getAbsolutePath().getBytes(StandardCharsets.UTF_8));
    }

    public static File decryptFile(byte[] cipherBytes, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception{
        Cipher cipher = Cipher.getInstance(CIPHER_PARAM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] decryptedPlainText = cipher.doFinal(cipherBytes);
        return new File(Arrays.toString(decryptedPlainText));
    }

    public static File getFile(String filePath){
        return new File(filePath);
    }

    public static void readFile(String filePath) throws IOException {
        File file = getFile(filePath);
        BufferedReader reader = null;
        List<String> fileLinesList  = null;
        try {
            if (file.canRead()){
                reader = Files.newBufferedReader(Paths.get(file.toURI()));
                //fileLinesList = reader.lines().map(String::toString).collect(Collectors.toList());
                fileLinesList = reader.lines().collect(Collectors.toList());
                print(fileLinesList.toString());
            }
        } catch (Exception e){
            print(e.getMessage());
        } finally {
            if (reader!=null)
                reader.close();
        }

    }

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    public static IvParameterSpec generateIV(){
        byte[] ivArray = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(ivArray);
        return new IvParameterSpec(ivArray);
    }

    public static <T>void print(T msg){
        System.out.println(msg);
    }

}
