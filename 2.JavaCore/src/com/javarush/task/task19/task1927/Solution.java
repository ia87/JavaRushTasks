package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new MyStream(new PrintStream(outputStream));
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);
        System.out.println(outputStream);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class MyStream extends PrintStream{
        private static int counter = 0;
        private String addLine = "\r\nJavaRush - курсы Java онлайн";
        private PrintStream printStream;

        public MyStream(PrintStream printStream) {
            super(printStream);
            this.printStream = printStream;
        }

        @Override
        public void print(String s) {
            if (counter ==1) {
                super.print(s+addLine);
                counter = 0;
            } else {
                super.print(s);
                counter++;
            }
        }
    }
}
