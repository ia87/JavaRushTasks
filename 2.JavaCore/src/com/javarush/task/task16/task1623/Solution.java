package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads));
            start();
        }

        public static synchronized int getCount() {
            return ++countCreatedThreads;
        }

        @Override
        public String toString() {
            return super.getName()+" created";
        }

        @Override
        public void run() {
            if (countCreatedThreads < count) {

                    Thread t = new GenerateThread();
                    System.out.println(t);

            }
        }
    }

}
