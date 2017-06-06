    package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String s = outputStream.toString().replace("\\n","");

        System.setOut(consoleStream);

        String[] ss = s.split(" ");
//        System.out.println("+".equals(ss[1]));
        int a = Integer.parseInt(ss[0]);
        int b = Integer.parseInt(ss[2]);
        int c = 0;
        switch (ss[1]){
            case "+": c = a+b; break;
            case "-": c = a-b; break;
            case "*": c = a*b; break;
            default:  c = 0;
        }


        System.out.print(ss[0] + " " + ss[1] + " " + ss[2] + " " + ss[3] + " " + c);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

