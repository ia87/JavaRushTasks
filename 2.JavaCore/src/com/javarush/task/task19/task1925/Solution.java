package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        if (args.length<2) System.exit(1);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder stringBuilder = new StringBuilder();

        while(reader.ready()){
            String line = reader.readLine();
            String[] words = line.split(" ");
            for (String s :
                    words) {
                if (s.length() > 6) stringBuilder.append(s+",");
            }
        }
        stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
        writer.write(stringBuilder.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}
