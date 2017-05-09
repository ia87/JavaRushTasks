package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String File1 = reader.readLine();
        String File2 = reader.readLine();
        String File3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(File1);
        FileOutputStream outputStream1 = new FileOutputStream(File2);
        FileOutputStream outputStream2 = new FileOutputStream(File3);
        byte[] buff = new byte[(int)Math.ceil((double)inputStream.available()/2)];
        int counter = 0;


        if (inputStream.available() > 0)  {
            counter = inputStream.read(buff);
            outputStream1.write(buff,0,counter);
        }
        if (inputStream.available() > 0) {
            counter = inputStream.read(buff);
            outputStream2.write(buff,0,counter);
        }


        inputStream.close();
        outputStream1.close();
        outputStream2.close();

    }
}
