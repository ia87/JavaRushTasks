package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
        private static int[][] exp;
        public static long getSumTime=0;
        public static long fillExpTime=0;
        public static long getDigitsTime=0;
        public static long getNumbersTime=0;
        public static int counter;

    public static long[] getNumbers(long N) {
        long t0=0,t1=0;
        long[] result = null;
        ArrayList<Long> list = new ArrayList();

        fillExp();
        t0 = System.currentTimeMillis();

        label:
        for (long l = 288; l < N; l++) {
            int[] digits = getDigits(l, true);
            if (digits == null) continue label;
            counter++;
            long sum1= getSum(digits);

            digits = getDigits(sum1, false);
            long sum2= getSum(digits);


            if (sum1 == sum2) {
                list.add(sum1);
//                System.out.println(System.currentTimeMillis()-t0 + "------");
            }
            t1 = System.currentTimeMillis();
            getNumbersTime+=t1-t0;
            t0=t1;
        }


        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }


        return result;
    }
    public static void fillExp(){
        long t0 = System.currentTimeMillis();
        exp = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                exp[i][j] = (int)Math.pow(i,j);
            }
        }
        long t1 = System.currentTimeMillis();
        fillExpTime+=t1-t0;
    }

    public static long getSum(int[] digits) {
        long t0 = System.currentTimeMillis();
        long sum =0;
        int exponent = digits.length;
        for (int d : digits) {
            sum+=exp[d][exponent];
        }
        long t1 = System.currentTimeMillis();
        getSumTime+=t1-t0;
        return sum;
    }

    public static int[] getDigits(long N, boolean checkOrder){
        long t0 = System.currentTimeMillis();
        long n = N;
        String s = N+"";
        int previous = 10;
        int current;
        int[] digits = new int[s.length()];
        int count = s.length()-1;
        while (n>0) {
            current = (int) n%10;
            if (checkOrder && current > previous) return null;
            digits[count] = current;
            previous = current;
            n = n/10;
            count--;
        }
        long t1 = System.currentTimeMillis();
        getDigitsTime+=t1-t0;
        return digits;
    }

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        long[] nums = getNumbers(9999999);
        long t1 = System.currentTimeMillis();
        System.out.println("total time, s: " + (t1-t0) / 1000d);
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(getDigitsTime/ 1000d);
        System.out.println(getSumTime/ 1000d);
        System.out.println(fillExpTime/ 1000d);
        System.out.println(getNumbersTime/ 1000d);
        System.out.println("Counter= "+counter);

//        for (long l : nums) {
//            System.out.println(l);
//        }

    }
}
