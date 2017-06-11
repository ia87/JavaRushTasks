package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{
        if (args.length < 1) System.exit(1);

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        while (fileReader.ready()) {
            String fileLine = fileReader.readLine();

            String[] line = fileLine.split(" ");
            String name;
            int day, month, year;


            year = Integer.parseInt(line[line.length-1]);
            month = Integer.parseInt(line[line.length-2]);
            day = Integer.parseInt(line[line.length-3]);

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month    -1, day);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < line.length-3; i++) {
                stringBuilder.append(line[i]).append(" ");
            }

            name = stringBuilder.toString();

            PEOPLE.add(new Person(name.substring(0, name.length()-1), calendar.getTime()));
        }
        fileReader.close();
    }
}
