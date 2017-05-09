package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = reader.readLine();
        FileInputStream inputStream = new FileInputStream(inFile);
        char c = ',';
        int counter = 0;
        while (inputStream.available() > 0) {
            if (inputStream.read() == c) counter++;
        }

        System.out.println(counter);
        inputStream.close();
    }
}
