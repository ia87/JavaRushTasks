package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        if (args.length <1) System.exit(1);
        TreeMap <Character, Integer> symbols = new TreeMap<>();
        FileReader fileReader = new FileReader(args[0]);
        while(fileReader.ready()) {
            char symbol = (char) fileReader.read();
            symbols.put(symbol, symbols.getOrDefault(symbol,0)+1);
        }
        fileReader.close();
        for (Map.Entry<Character, Integer> entry :
                symbols.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
