package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = bufferedReader.readLine();
        Reader reader = new InputStreamReader(new FileInputStream(inFile));
        int max=0;
        while (reader.ready()) {
            int a = reader.read();
            if (a>max) max =a;
        }
        System.out.println(max);
        reader.close();

    }
}
