package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
-c name sex bd
-u id name sex bd
-d id
-i id
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String key = "";
        int id = -1;
        String name = "";
        String sex = "";
        Date bd = null;
        Person person = null;
        SimpleDateFormat dateFormat = null;

        if (args.length > 0) {
            key = args[0];
            switch (key) {
                case "-c" :
                    if (args.length > 1) name = args[1];
                    if (args.length > 2) sex = args[2];
                    if (args.length > 3) bd = new Date(args[3]);
                    if ("м".equals(sex)) allPeople.add(Person.createMale(name , bd));
                        else if ("ж".equals(sex)) allPeople.add(Person.createFemale(name , bd));
                    System.out.println(allPeople.size()-1);

                case "-u" :
                    if (args.length > 1) id = Integer.parseInt(args[1]);
                    if (args.length > 2) name = args[2];
                    if (args.length > 3) sex = args[3];
                    if (args.length > 4) bd = new Date(args[4]);

                    if (id < allPeople.size() && id!= -1) person = allPeople.get(id);
                    if (person != null) {
                        person.setName(name);
                        person.setSex( "м".equals(sex) ? Sex.MALE : "ж".equals(sex) ? Sex.FEMALE : null);
                        person.setBirthDay(bd);
                    }

                case "-d" :
                    if (args.length > 1) id = Integer.parseInt(args[1]);
                    allPeople.remove(id);
                case "-i" :
                    if (args.length > 1) id = Integer.parseInt(args[1]);
                    if (id < allPeople.size() && id!= -1) person = allPeople.get(id);
                    if (person != null) {
                        dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        name = person.getName();
                        sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                        bd = person.getBirthDay();
                        System.out.println(name + " " + sex + dateFormat.format(bd));
                    }

            }
        }
    }
}
