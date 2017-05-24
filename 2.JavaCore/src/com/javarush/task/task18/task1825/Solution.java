package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream;
        FileOutputStream outputStream;
        byte[] bytes;
        String s, fileName;
        while (!("end".equals(s=reader.readLine()))) {
            list.add(s);
        }
        reader.close();
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
        String[] strings = list.get(0).split(".part");
        fileName = strings[0];
        System.out.println(fileName+"\n");
        outputStream = new FileOutputStream(fileName);
        for (String ss :
                list) {
        fileInputStream = new FileInputStream(ss);
        bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        outputStream.write(bytes);
        fileInputStream.close();
        }

        outputStream.close();

    }
}
