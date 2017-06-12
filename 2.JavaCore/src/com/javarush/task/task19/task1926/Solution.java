package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = conReader.readLine();
        conReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            System.out.println(new StringBuilder(line).reverse().toString());
        }

        reader.close();
    }
}
