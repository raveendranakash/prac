package com.java.crypt;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.java.util.Log.print;
import static com.java.crypt.ByteAsciiConverter.convertByteArrayToAsciiArray;

public class AESEncryptDecrypt {

    //static Scanner scanner = new Scanner(System.in);
    public static final String AES = "AES";
    public static final String TEXT_CIPHER_PARAM = "AES/CFB8/NoPadding";
    public static final String FILE_CIPHER_PARAM = "AES/CBC/PKCS5Padding";
    public static final String INPUT_FILE_PATH = "/home/akash/Desktop/misc/papa_mummy_pass"; // /home/akash/unix_shell_script_tutorial/ch1.txt
    public static final String OUTPUT_FILE_PATH = "/home/akash/Desktop/misc/enc_file";
    public static final String DECRYPT_FILE_PATH = "/home/akash/Desktop/misc/decrypt_file";

    public static void main(String[] args) throws Exception {
        String inputPlainText = "Akash";
        print("received text : "+inputPlainText);
        //scanner.close();

        SecretKey key = generateKey();
        IvParameterSpec ivSpec = generateIV();

        byte[] encryptedText = encryptText(inputPlainText, key, ivSpec);
        print("encrypted cipher text : "+ Arrays.toString(encryptedText));

        String decryptedText = decryptText(encryptedText, key, ivSpec);
        print("decrypted plain text : "+decryptedText);

        encryptFile(INPUT_FILE_PATH, OUTPUT_FILE_PATH, key, ivSpec);
        readFile(OUTPUT_FILE_PATH);

        //decryptFile(OUTPUT_FILE_PATH, DECRYPT_FILE_PATH, key, ivSpec);
        //readFile(DECRYPT_FILE_PATH);
    }

    public static byte[] encryptText(String inputPlainText, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception {
        Cipher cipher = Cipher.getInstance(TEXT_CIPHER_PARAM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(inputPlainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String decryptText(byte[] cipherBytes, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception{
        Cipher cipher = Cipher.getInstance(TEXT_CIPHER_PARAM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] decryptedPlainText = cipher.doFinal(cipherBytes);
        return new String(decryptedPlainText);
    }

    public static void encryptFile(String inputFilePath, String outputFilePath, SecretKey key, IvParameterSpec iv) throws Exception{
        cipherFileProcess(Cipher.ENCRYPT_MODE, inputFilePath, outputFilePath, key, iv);
    }

    public static void decryptFile(String inputFilePath, String outputFilePath, SecretKey key, IvParameterSpec iv) throws Exception{
        cipherFileProcess(Cipher.DECRYPT_MODE, inputFilePath, outputFilePath, key, iv);
    }

    public static void cipherFileProcess(int mode, String inputFilePath, String outputFilePath, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception{
        Cipher cipher = Cipher.getInstance(FILE_CIPHER_PARAM);
        cipher.init(mode, secretKey, ivParameterSpec);
        String keyBytes = String.valueOf(convertByteArrayToAsciiArray(secretKey.getEncoded()));
        String ivBytes = String.valueOf(convertByteArrayToAsciiArray(ivParameterSpec.getIV()));
        print("Bytes from key : "+ Arrays.toString(secretKey.getEncoded()));
        print("String of bytes from key : "+ keyBytes);
        print("IV bytes from ivSpec : "+Arrays.toString(ivParameterSpec.getIV()));
        print("String of IV bytes from ivSpec : "+ivBytes);
        try(FileInputStream fis = new FileInputStream(inputFilePath);
            FileOutputStream fos = new FileOutputStream(outputFilePath);
            CipherOutputStream cos = new CipherOutputStream(fos, cipher)){

            //fos.write(ivParameterSpec.getIV()); // important for decryption. Writes IV to the beginning of the o/p file
                                                  // however during testing found that it adds an extra illegible text to the start of the decrypted file.
                                                  // hence commented later
            // TEST AND WRITE LOGIC TO PLACE KEY AND IV IN THE ENCRYPTED FILE ITSELF AND WHILE DECRYPTION READ THE SAME KEY AND IV
            if(mode==1){
                fos.write(secretKey.getEncoded());
                fos.write(ivParameterSpec.getIV());
            }

            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = fis.read(buffer)) != -1){
                cos.write(buffer, 0, bytesRead);
            }
        }
    }


    public static File getFile(String filePath){
        return new File(filePath);
    }

    public static void readFile(String filePath) throws IOException {
        File file = getFile(filePath);
        List<String> fileLinesList  = null;
        if (file.canRead()){
            try(BufferedReader reader = Files.newBufferedReader(Paths.get(file.toURI()), StandardCharsets.UTF_8)) {
                    fileLinesList = reader.lines().collect(Collectors.toList());
                    print(fileLinesList.toString());
            } catch (Exception e){
                print(e.getMessage());
            }
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

    /*public static <T>void print(T msg){
        System.out.println(msg);
    }*/

}
