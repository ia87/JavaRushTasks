package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {}
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {}
            System.out.println("InterruptedException");
        }
    }

    static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        }
    }

    static class Thread4 extends Thread implements Message{

        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (!isInterrupted()) {}
        }
    }

    static class Thread5 extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int summ=0;
            while (!isInterrupted()) {
                String s="";
                try {
                    while (!("N".equals(s = reader.readLine()))) {
                        summ += Integer.parseInt(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(summ);
            }
        }

    }

    public static void main(String[] args) {
    }
}