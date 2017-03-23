package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)  {
        try {
            System.out.println(convertCelsiumToFahrenheit(40));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double convertCelsiumToFahrenheit(int celsium) throws Exception{
        //напишите тут ваш код
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s =reader.readLine();
//        int i = Integer.parseInt(s);
        double f = ((celsium + 32.*5./9.))*9./5.;
        return f;
    }
}