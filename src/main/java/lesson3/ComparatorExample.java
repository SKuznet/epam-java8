package lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Nick" , "Jagger"));
        users.add(new User("Nick" , "AJagger"));
        users.add(new User("ANick" , "HJagger"));
        users.add(new User("ZNick" , "AJagger"));

        users.sort(Comparator.comparing(User::getName).thenComparing(User::getSecondName));
        users.forEach(System.out::println);
    }



    static class User {

        private String name;
        private String secondName;


        public String getName() {
            return name;
        }

        public String getSecondName() {
            return secondName;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", secondName='" + secondName + '\'' +
                    '}';
        }

        public User(String name, String secondName) {
            this.name = name;
            this.secondName = secondName;


        }
    }
}
