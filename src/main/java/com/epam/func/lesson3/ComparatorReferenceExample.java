package com.epam.func.lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorReferenceExample {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Nick", "Jagger"));
        users.add(new User("Tom", "Soyer"));
        users.add(new User("Jack", "Vorobei"));
        users.add(new User("Ara", "Parrot1"));
        users.add(new User("Ara", "Parrot3"));
        users.add(new User("Ara", "Parrot2"));
        users.add(new User("Ara", "Parrot4"));

        System.out.println("Sort with names!");
        users.sort(Comparator.comparing(User::getName));
        System.out.println(users);

        System.out.println("Sort with names and then with secondName");
        users.sort(Comparator.comparing(User::getName).thenComparing(User::getSecondName));
        System.out.println(users);
    }


    static class User {
        private String name;
        private String secondName;

        public User(String name, String secondName) {
            this.name = name;
            this.secondName = secondName;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", secondName='" + secondName + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }
    }
}
