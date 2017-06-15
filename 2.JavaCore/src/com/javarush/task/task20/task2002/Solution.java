package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("d:\\1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User usr = new User();
            usr.setFirstName("Ivan");
            usr.setLastName("Ivanov");
            usr.setBirthDate(new GregorianCalendar(1980, 11, 25).getTime());
            usr.setCountry(User.Country.UKRAINE);
            usr.setMale(true);

            javaRush.users.add(usr);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(javaRush.users.get(0).getFirstName()).append(",")
                    .append(javaRush.users.get(0).getLastName()).append(",")
                    .append(javaRush.users.get(0).getBirthDate()!=null ? javaRush.users.get(0).getBirthDate().getTime() : null).append(",")
                    .append(javaRush.users.get(0).isMale()).append(",")
                    .append(javaRush.users.get(0).getCountry()!=null ? javaRush.users.get(0).getCountry().name() : null).append("\r\n");
            System.out.print(stringBuilder.toString());

            stringBuilder.delete(0,stringBuilder.length()-1);

            stringBuilder.append(loadedObject.users.get(0).getFirstName()).append(",")
                    .append(loadedObject.users.get(0).getLastName()).append(",")
                    .append(loadedObject.users.get(0).getBirthDate()!=null ? loadedObject.users.get(0).getBirthDate().getTime() : null).append(",")
                    .append(loadedObject.users.get(0).isMale()).append(",")
                    .append(loadedObject.users.get(0).getCountry()!=null ? loadedObject.users.get(0).getCountry().name() : null).append("\r\n");
            System.out.print(stringBuilder.toString());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            writer.flush();

            for (User user: users) {
                user.save(outputStream);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int userListSize = Integer.parseInt(reader.readLine());
//            System.out.println(userListSize);
            User user;
            for (int i = 0; i < userListSize; i++) {
                user = new User();
                user.load(reader);
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
