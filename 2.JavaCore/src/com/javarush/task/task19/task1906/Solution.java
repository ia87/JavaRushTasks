package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader in = new FileReader(file1);
        FileWriter out = new FileWriter(file2);

        while (in.ready()) {
            in.read();
            out.write(in.read());
        }
        in.close();
        out.close();
    }
}
