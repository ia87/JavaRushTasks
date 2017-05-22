package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1,f2,f3,s;
        f1 = reader.readLine();
        f2 = reader.readLine();
        f3 = reader.readLine();

//        FileOutputStream out = new FileOutputStream(f1);
        BufferedWriter out = new BufferedWriter(new FileWriter(f1));
        BufferedReader in1 = new BufferedReader(new FileReader(f2));
        BufferedReader in2 = new BufferedReader(new FileReader(f3));
//        FileInputStream in1 = new FileInputStream(f2);
//        FileInputStream in2 = new FileInputStream(f3);

        while (in1.ready()) {
            s = in1.readLine();
            out.write(s);
            out.flush();
        }
        while (in2.ready()) {
            s = in2.readLine();
            out.write(s);
            out.flush();
        }
        out.close();
        in1.close();
        in2.close();

    }
}
