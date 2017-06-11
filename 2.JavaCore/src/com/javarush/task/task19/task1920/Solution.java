package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    private static SortedMap<String, Double> cash;

    public static void main(String[] args) throws Exception{
        if (args.length < 1) System.exit(1);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        cash = new TreeMap<>();
        while (reader.ready()) {
            String fileLine = reader.readLine();
            String[] line = fileLine.split(" ");
            String name = line[0];
            Double value = Double.parseDouble(line[1]);
            cash.put(name, cash.getOrDefault(name, 0.0) + value);
        }
        reader.close();

//        Set<Double> set = cash.values();
        Collection<Double> values = cash.values();
        Double max = Collections.max(values);
//        System.out.println(max);
        for (Map.Entry<String, Double> entry :
                cash.entrySet()) {
            if (entry.getValue().equals(max)) System.out.print(entry.getKey()+" ");
        }
    }
}
