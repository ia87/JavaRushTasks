package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;


public class Solution {
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    private static byte[] bytes;
    public static void main(String[] args) throws Exception{
        if (args.length < 3) System.exit(1);
        if (args[0].equals("-e")) encryptFile(args[1], args[2]);
        if (args[0].equals("-d")) decryptFile(args[1], args[2]);

    }

    private static void decryptFile(String in, String out) throws Exception {
        fileInputStream = new FileInputStream(in);
        fileOutputStream = new FileOutputStream(out);
        bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        for (int i = 0; i < bytes.length / 2; i++) {
            byte temp = bytes[i];
            bytes[i] = bytes[bytes.length - i - 1];
            bytes[bytes.length - i - 1] = temp;
        }
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();


    }

    private static void encryptFile(String in, String out) throws Exception{
        fileInputStream = new FileInputStream(in);
        fileOutputStream = new FileOutputStream(out);
        bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        for (int i = 0; i < bytes.length / 2; i++) {
            byte temp = bytes[i];
            bytes[i] = bytes[bytes.length - i - 1];
            bytes[bytes.length - i - 1] = temp;
        }
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();

    }

}
