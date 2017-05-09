package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = bufferedReader.readLine();
        Reader reader = new InputStreamReader(new FileInputStream(inFile));
        SortedSet<Integer> set = new TreeSet<>();

        while (reader.ready()) {
            set.add(reader.read());
        }
        set.forEach(i->{System.out.print(i+" ");});
        reader.close();
    }
}
