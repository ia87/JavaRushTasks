package com.javarush.task.task20.task2025;

/* 
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        String number = N + "";
        char[] digits = number.toCharArray();
        int[] d = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            d[i] = Integer.parseInt(digits[i] + "");
        }

        return result;
    }

    int[] getDigits()

    public static void main(String[] args) {

    }
}
