package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        if (args.length<1) {System.exit(1);}
        System.out.println(args[0]);
        FileInputStream in=new FileInputStream(args[0]);
        int spaces=0;
        int allSymbols=0;
        float f;
        while(in.available()>0) {
            char c = (char) in.read();
            System.out.print(c);
            allSymbols++;
            if (c ==' ') spaces++;
        }
        f = (float)spaces/allSymbols*100;
        System.out.format("%.2f",f);
        System.out.println(spaces/allSymbols*100);
        in.close();

    }
}
