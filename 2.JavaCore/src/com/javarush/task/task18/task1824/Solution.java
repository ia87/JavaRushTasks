package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    static boolean stop;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader;
        String fileName;
        while (!stop) {
            fileName = reader.readLine();
            try {
                fileReader = new FileReader(fileName);
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
//                stop = true;
            } finally {
            }
        }
    }
//
//    public static class FileReadingThread extends Thread{
//        String fileName;
//        FileReader fileReader;
//        FileReadingThread(String fileName) {
//            this.fileName = fileName;
//        }
//
//        @Override
//        public void run() {
//            try {
//                fileReader = new FileReader(fileName);
//            } catch (FileNotFoundException e) {
//                System.out.println(fileName);
//                stop = true;
//            } finally {
//                fileReader.close();
//            }
//
//        }
//    }
}
