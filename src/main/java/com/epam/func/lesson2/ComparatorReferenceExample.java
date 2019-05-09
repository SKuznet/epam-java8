package com.epam.func.lesson2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorReferenceExample {
    public static void main(String[] args) {
        List <User> users = new ArrayList<>();
        users.add(new User("Nick","Jagger"));
        users.add(new User("Tom","Soyer"));
        users.add(new User("Jack","Sparrow"));
        users.add(new User("Ara","Parrot11"));
        users.add(new User("Ara","Parrot2"));
        users.add(new User("Ara","Parrot3"));

        System.out.println("Sort them");
        users.sort(Comparator.comparing(User::getName));
        System.out.println(users);


        System.out.println("Sort them, usin secondname then");
        users.sort(Comparator.comparing(User::getName).thenComparing(User::getSecondName));
        System.out.println(users);
    }

    static class User {
        private String name;
        private String secondName;

        User (String s1, String s2){
            name =s1;
            secondName = s2;
        }

        User(){
            this("", "");
        }

        public String getName() {
            return name;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        @Override
        public String toString() {
            return String.format("Name = %s seconName = %s", getName(), getSecondName());
        }
    }
}
