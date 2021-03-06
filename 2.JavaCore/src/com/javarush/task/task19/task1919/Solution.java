package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private static TreeMap<String, Double> cash;

    public static void main(String[] args) throws Exception{
        if (args.length < 1) System.exit(1);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        cash = new TreeMap<>();
        while (reader.ready()) {
            String fileLine = reader.readLine();
//            System.out.println(fileLine);
            String[] line = fileLine.split(" ");
            String name = line[0];
            Double value = Double.parseDouble(line[1]);
            cash.put(name, cash.getOrDefault(name, 0.0) + value);
        }
        reader.close();

        for (Map.Entry<String, Double> entry :
                cash.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
//            System.out.format(UT);
        }
    }
}
