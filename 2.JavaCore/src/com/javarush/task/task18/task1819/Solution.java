package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1,f2;
        f1 = reader.readLine();
        f2 = reader.readLine();

        BufferedReader in = new BufferedReader(new FileReader(f1));
        BufferedWriter out;
        List<String> strings = new ArrayList<>();
        while (in.ready()) {
            strings.add(in.readLine());
        }

        in.close();

        in = new BufferedReader(new FileReader(f2));
        out = new BufferedWriter(new FileWriter(f1));

        while (in.ready()){
            out.write(in.readLine());
            out.flush();
        }

        in.close();

        for (String s :
                strings) {
            out.write(s);
        }

        out.close();
    }
}
