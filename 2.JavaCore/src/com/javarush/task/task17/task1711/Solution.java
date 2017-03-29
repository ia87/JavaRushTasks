package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-u 0 Гаврилов м 12/03/2001 1 Чубренко ж 08/12/2012
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String key = "";
        int id = -1,
            argNum = 0;
        int listSize = allPeople.size();
        String name = "";
        String sex = "";
        Date bd = null;
        Person person = null;
        SimpleDateFormat dateFormat = null;
        SimpleDateFormat inputDate = new SimpleDateFormat("dd/MM/yyyy");


        if (args.length > 0) {
            switch (args[0]) {
                case "-c" :
                    synchronized (allPeople) {
                        if (args.length > 1) {
                            argNum = 1;
                            while (argNum < args.length) {
                                name = null;
                                sex = null;
                                bd = null;
                                person =null;
                                if (args.length > argNum) {
                                    name = args[argNum];
                                    argNum++;
                                }
                                if (args.length > argNum) {
                                    sex = args[argNum];
                                    argNum++;
                                }
                                try {
                                    if (args.length > argNum) {
                                        bd = inputDate.parse(args[argNum]);
                                        argNum++;
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                if ("м".equals(sex)) person = Person.createMale(name, bd);
                                else if ("ж".equals(sex)) person = Person.createFemale(name, bd);

                                if (!allPeople.contains(person)) allPeople.add(person);
                                if (allPeople.contains(person)) System.out.println(allPeople.indexOf(person));
                            }
                            break;
                        }

                        if ("м".equals(sex)) person = Person.createMale(name, bd);
                        else if ("ж".equals(sex)) person = Person.createFemale(name, bd);

                        if (!allPeople.contains(person)) allPeople.add(person);
//                        if (allPeople.contains(person)) System.out.println(allPeople.indexOf(person));
                        System.out.println(allPeople.size() - 1);
                    }
                    break;


                case "-u" :
                    synchronized (allPeople) {
                        listSize = allPeople.size();
                        if (args.length > 1) {
                            argNum = 1;
                            while (argNum < args.length) {
                                name = null;
                                sex = null;
                                bd = null;
                                if (args.length > argNum) {
                                    id = Integer.parseInt(args[argNum]);
                                    argNum++;
                                }
                                if (args.length > argNum) {
                                    name = args[argNum];
                                    argNum++;
                                }
                                if (args.length > argNum) {
                                    sex = args[argNum];
                                    argNum++;
                                }
                                try {
                                    if (args.length > argNum) {
                                        bd = new SimpleDateFormat("dd/MM/yyyy").parse(args[argNum]);
                                        argNum++;
                                    }
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
                            }
                        }
                    }
                    break;


                case "-d" :
                    synchronized (allPeople) {
                        if (args.length > 1) {
                            argNum = 1;
                            while (argNum < args.length) {
                                id = Integer.parseInt(args[argNum]);
                                argNum++;
                                person = allPeople.get(id);
                                if (person != null) {
                                    person.setBirthDay(null);
                                    person.setSex(null);
                                    person.setName(null);
                                }
                            }
                        }
                    }
                    break;
                case "-i" :
                    synchronized (allPeople) {
                        if (args.length > 1) {
                            argNum = 1;
                            while (argNum < args.length) {
                                id = Integer.parseInt(args[argNum]);
                                argNum++;
                                if (id < allPeople.size() && id != -1) person = allPeople.get(id);
                                if (person != null) {
                                    dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                                    name = person.getName();
                                    sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                                    bd = person.getBirthDay();
                                    System.out.println(name + " " + sex + " " + dateFormat.format(bd));
                                }
                            }
                        }
                    }
                    break;

            }
        }

    }
}
