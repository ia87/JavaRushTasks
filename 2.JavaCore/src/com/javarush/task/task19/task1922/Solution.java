package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(conReader.readLine()));
        conReader.close();
        while(reader.ready()) {
            String line = reader.readLine();
            int containWords=0;
            for (String s:
                 words) {
                if (line.contains(s)) containWords++;
            }
            if (containWords == 2) System.out.println(line);
        }
        reader.close();

    }
}
