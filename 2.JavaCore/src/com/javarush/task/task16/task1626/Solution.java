package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable{
        //Add your code here - добавь код тут
        private int countUpIndex = 0;
        public String toString() {
            return Thread.currentThread().getName() + ": " + countUpIndex;
        }
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    countUpIndex += 1;
                    System.out.println(toString());
                    if (countUpIndex == Solution.number) return;

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
