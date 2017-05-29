package com.javarush.task.task18.task1827;

/* 
Прайсы
*/


import java.io.*;
import java.util.Formatter;

public class Solution {
    public static void main(String[] args) throws Exception{
        if (args.length < 4) System.exit(1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Formatter formatter = new Formatter();
        File fileName = new File(reader.readLine());
        if (!fileName.exists()) fileName.createNewFile();
        //        String fileName = reader.readLine();
        String lastLine="",
                id="";
        String[] strings;
        int nextId = 1;
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            lastLine = fileReader.readLine();
        }
        fileReader.close();
        strings = lastLine.split(" ");
        if (strings.length > 1) {
                id = strings[0];
                nextId = Integer.parseInt(id) + 1;
            }

        formatter.format("%d%30.s%8.s%4.s", nextId, args[1], args[2], args[3]);
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName,true));
        fileWrite.write("\n"+nextId+args[1]+args[2]+args[3]);
//        fileWrite.write("qwerty");
        fileWrite.flush();
        fileWrite.close();

    }
}
