package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = bufferedReader.readLine();
        Reader reader = new InputStreamReader(new FileInputStream(inFile));
        int min=Integer.MAX_VALUE;
        while (reader.ready()) {
            int a = reader.read();
            if (a<min) min =a;
        }
        System.out.println(min);
        reader.close();
    }
}
