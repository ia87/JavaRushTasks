package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

            if (firstFileName.isEmpty()) firstFileName = "d:\\1.txt";
            if (secondFileName.isEmpty()) secondFileName = "d:\\2.txt";


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private List<String> list = new ArrayList<>();
        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : list) {
                stringBuilder.append(s).append(" ");
            }
            return stringBuilder.toString();
        }

        @Override
        public void run() {
            try {
                BufferedReader filereader = new BufferedReader(new FileReader(fileName));
                while (filereader.ready()) {
                    String s = filereader.readLine();
                    list.add(s);
                }
                filereader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }  catch (IOException e) {
                System.out.println("IOException");
            }

        }
    }
}
