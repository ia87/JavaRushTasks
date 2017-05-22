package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
//        if (args.length<1) System.exit(1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        int i = Integer.parseInt(args[0]);

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()){
            String[] s = fileReader.readLine().split(" ");
            if (Integer.parseInt(s[0]) == i) {
                for (String ss :
                        s) {
                    System.out.print(ss+" ");
                }
            }
        }

        fileReader.close();
    }
}
