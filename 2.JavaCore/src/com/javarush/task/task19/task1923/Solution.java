package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        if (args.length <2) System.exit(1);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        while (reader.ready()) {
            String line =  reader.readLine();
//            System.out.println(line);
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].matches("(.*)\\d(.*)")) {
                    writer.write(words[i]+" ");
                    System.out.println(words[i]);}
            }

            writer.flush();
        }
        reader.close();
        writer.close();
    }
}
