package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!("exit".equals(fileName = reader.readLine()))) {
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private FileReader fileReader;
        private String fileName;
        private Map<Integer, Integer> bytes = new HashMap<>();
        Map.Entry<Integer,Integer> maxEntry = null;

        public ReadThread(String fileName) throws Exception{
            //implement constructor body
            this.fileReader = new FileReader(fileName);
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run(){
            try {
                while (fileReader.ready()) {
                    int b = fileReader.read();
                    bytes.put(b, bytes.getOrDefault(b, 0) + 1);
                }
                fileReader.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Map.Entry<Integer, Integer> entry: bytes.entrySet()){
                if ((maxEntry == null) || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                    maxEntry = entry;
            }
            resultMap.put(fileName, maxEntry.getKey());
        }
    }
}
