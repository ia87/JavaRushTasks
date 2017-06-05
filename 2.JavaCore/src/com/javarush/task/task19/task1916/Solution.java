package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static ArrayList<String> lines1 = new ArrayList<>();
    public static ArrayList<String> lines2 = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        BufferedReader fileReader1 = new BufferedReader(new FileReader(f1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(f2));

        while (fileReader1.ready()) {lines1.add(fileReader1.readLine());}
        fileReader1.close();
        while (fileReader2.ready()) {lines2.add(fileReader2.readLine());}
        fileReader2.close();

            for (int i = 0, j = 0; i <= lines1.size(); i++) {
                try {
                    if (i == lines1.size() && (j)<lines2.size())  {lines.add(new LineItem(Type.ADDED, lines2.get(j))); j++; i--; continue;}
                    else if (i == lines1.size()) break;
                    if (lines1.get(i).equals(lines2.get(j))) {lines.add(new LineItem(Type.SAME, lines1.get(i))); j++; continue;}
                    else if ((j+1)<lines2.size() && lines1.get(i).equals(lines2.get(j+1))) {lines.add(new LineItem(Type.ADDED, lines2.get(j))); j++; i--; continue;}
                    else {lines.add(new LineItem(Type.REMOVED, lines1.get(i))); continue; }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                }
            }

        lines.forEach(System.out::println);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type.toString()+" "+line;
        }
    }
}
