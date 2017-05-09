package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = bufferedReader.readLine();
        Reader reader = new InputStreamReader(new FileInputStream(inFile));
        int max= 0;

        HashMap<Integer,Integer> bytes = new HashMap<>();

        while (reader.ready()) {
            int a = reader.read();
            bytes.put(a, bytes.getOrDefault(a,0)+1);
            if (bytes.get(a) > max) max = bytes.get(a);
        }
        for (Map.Entry<Integer,Integer> pair: bytes.entrySet()){
            if (pair.getValue() == max) System.out.print(pair.getKey() + " ");
        }

        reader.close();
    }
}
