package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String File1 = reader.readLine();
        String File2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(File1);
        FileOutputStream outputStream = new FileOutputStream(File2);
        byte[] buff = new byte[inputStream.available()];
        byte[] buff2 = new byte[inputStream.available()];;
        int counter = 0;


        if (inputStream.available() > 0)  {
            counter = inputStream.read(buff);
            for (int i = 0; i < counter; i++) {
                buff2[i] = buff[counter-1-i];
            }
            outputStream.write(buff2,0,counter);
        }



        inputStream.close();
        outputStream.close();

    }
}
