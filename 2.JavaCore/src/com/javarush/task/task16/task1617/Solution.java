package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 5;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
//        if (clock.isAlive()) clock.interrupt();
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (countSeconds>0){
//                for (int i = countSeconds; i > 0 ; i--) {
                    System.out.print(countSeconds+" ");
                    countSeconds--;
                    sleep(1000);
                }
                System.out.print("Марш!");
            } catch (InterruptedException e) {
                System.out.print("Прервано!");
            }
        }
    }
}
