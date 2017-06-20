package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
//        long[] result = null;
        ArrayList<Long> list = new ArrayList();
        for (long l = 0; l < N; l++) {
            int[] digits = getDigits(l);
            int exponent = digits.length;
            int sum=0;
            for (int d : digits) {
                sum+=l*Math.pow(d, exponent);
            }
            if (l == sum) list.add(l);
        }
        Long[] result = list.toArray(new Long[list.size()]);
        return result;
    }

    public static int[] getDigits(long N){
        String number = N + "";
        char[] chars = number.toCharArray();
        int[] digits = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            digits[i] = Integer.parseInt(chars[i] + "");
        }
        return digits;
    }

//    public static long getSum()

//    public static int[] getDigits()

    public static void main(String[] args) {

    }
}
