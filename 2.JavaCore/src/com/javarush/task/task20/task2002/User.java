package com.javarush.task.task20.task2002;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isMale != user.isMale) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(user.birthDate) : user.birthDate != null) return false;
        return country == user.country;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (isMale ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(outputStream);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getFirstName()).append(",")
                .append(getLastName()).append(",")
                .append(getBirthDate()!=null ? getBirthDate().getTime() : null).append(",")
                .append(isMale()).append(",")
                .append(getCountry()!=null ? getCountry().name() : null).append("\r\n");
        writer.write(stringBuilder.toString());
        System.out.print(stringBuilder.toString());
        writer.flush();
    }

    public void load(BufferedReader bufferedReader) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = bufferedReader;
        String[] params = reader.readLine().split(",");
        setFirstName("null".equals(params[0]) ? null : params[0]);
        setLastName("null".equals(params[1]) ? null : params[1]);
        if (!"null".equals(params[2])) {
            setBirthDate(new Date(Long.parseLong(params[2])));
        }
        setMale("null".equals(params[3]) ? false : Boolean.parseBoolean(params[3]));
        if (!"null".equals(params[4])) {
            setCountry(Country.valueOf(params[4]));
        }
    }
}
