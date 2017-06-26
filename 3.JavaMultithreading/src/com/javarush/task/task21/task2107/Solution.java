package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone =  solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution clone = new Solution();
        User user;
        for (Map.Entry<String, User> entry : this.users.entrySet()) {
            user = entry.getValue().clone();
            clone.users.put(entry.getKey(), user);
        }
        return clone;
    }

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return 31*  age + (name!=null ? name.hashCode() : 0);
        }

        @Override
        public boolean equals(Object obj) {
            if (this==obj) return true;
            if (!(obj instanceof User)) return false;
            User user = (User) obj;
            if (age!=user.age) return false;
//            if (this.age != 0 ? this.age!=user.age : user.age!=0) return false;
//            if (this.name != null ? this.name.equals(user.name) : user.name != null) return false;
            return name.equals(user.name);
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return new User(this.age, this.name);
        }
    }
}
