package com.javarush.task.task01.task0140;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        int a;
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//        a = Integer.parseInt(s);
        System.out.println(a*a);

    }
}