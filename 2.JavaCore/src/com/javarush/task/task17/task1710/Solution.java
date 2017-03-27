package com.javarush.task.task17.task1710;

import java.text.ParseException;
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
        int listSize = allPeople.size();
        String name = "";
        String sex = "";
        Date bd = null;
        Person person = null;
        SimpleDateFormat dateFormat = null;

        if (args.length > 0) {
            key = args[0];
            switch (key) {
                case "-c" : {
                    if (args.length > 1) name = args[1];

                    if (args.length > 2) sex = args[2];

                    try {
                        if (args.length > 3) bd = new SimpleDateFormat("dd/MM/yyyy").parse(args[3]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if ("м".equals(sex)) person = Person.createMale(name, bd);
                    else if ("ж".equals(sex)) person = Person.createFemale(name, bd);

                    if (!allPeople.contains(person)) allPeople.add(person);
                    if (allPeople.contains(person)) System.out.println(allPeople.indexOf(person));
//                    System.out.println(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
                    break;
                }

                case "-u" : {
                    listSize = allPeople.size();
                    if (args.length > 1) id = Integer.parseInt(args[1]);
                    if (args.length > 2) name = args[2];
                    if (args.length > 3) sex = args[3];
                    try {
                        if (args.length > 4) bd = new SimpleDateFormat("dd/MM/yyyy").parse(args[4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if (id < allPeople.size() && id != -1) person = allPeople.get(id);
                    if (person != null) {
                        person.setName(name);
                        person.setSex("м".equals(sex) ? Sex.MALE : "ж".equals(sex) ? Sex.FEMALE : null);
                        person.setBirthDay(bd);
                    }
                                        System.out.println(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
                    if (allPeople.size() > listSize) System.out.println("Insert");
                    break;
                }

                case "-d" :
                {
                    if (args.length > 1) id = Integer.parseInt(args[1]);
                    person = allPeople.get(id);
                    if (person!=null) {
                        person.setBirthDay(null);
                        person.setSex(null);
                        person.setName(null);
                    }
                    break;
                }
                case "-i" :
                {
                    if (args.length > 1) id = Integer.parseInt(args[1]);
                    if (id < allPeople.size() && id!= -1) person = allPeople.get(id);
                    if (person != null) {
                        dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        name = person.getName();
                        sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                        bd = person.getBirthDay();

                        System.out.println(name + " " + sex + " " + dateFormat.format(bd));
                    }

                    break;
                }

            }
        }
    }
}
