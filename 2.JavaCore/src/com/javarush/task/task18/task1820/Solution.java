package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer;
        String f1,f2;
        f1 = reader.readLine();
        f2 = reader.readLine();
        reader.close();
        List<Float> floats = new ArrayList<>();

        reader = new BufferedReader(new FileReader(f1));
        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                floats.add(Float.parseFloat(s[i]));
            }
        }
        reader.close();
        writer = new BufferedWriter(new FileWriter(f2));
        for (Float f:
             floats) {
            writer.write((int)Math.round(f)+" ");
            System.out.println(f);
        }
        writer.close();
    }
}
