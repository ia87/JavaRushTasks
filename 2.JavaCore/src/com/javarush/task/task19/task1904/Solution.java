package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws Exception{
        PersonScanner personScanner = new PersonScannerAdapter(new Scanner(System.in));
        Person person = personScanner.read();
        personScanner.close();
        System.out.println(person);

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] parts = fileScanner.nextLine().split(" ");
            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];

            int day = Integer.parseInt(parts[3]),
                month = Integer.parseInt(parts[4])-1,
                year = Integer.parseInt(parts[5]);
            Calendar calendar = new GregorianCalendar(year, month, day);
//            Date date = new Date(year, month, day);

            Person person = new Person(firstName, middleName, lastName, calendar.getTime());
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
