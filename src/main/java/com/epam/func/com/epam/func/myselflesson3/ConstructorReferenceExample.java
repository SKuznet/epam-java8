package com.epam.func.com.epam.func.myselflesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
//        UserFactory factorylambda = (s, s1) -> new User(s, s1);
        UserFactory factory = User::new;
        User user = factory.createUser("Barsic", "Angry");
        User user2 = factory.createUser("Barsic2", "Angry2");
        User user23 = factory.createUser("Barsic23", "Angry23");
        System.out.println();

        List<User> users = new ArrayList<>();
        users.add(new User("Ni`sdccK", "Jagger"));
        users.add(new User("NzvicK", "SFSJagger"));
        users.add(new User("NdfbxicK", "WFFSJagger"));
        users.add(new User("sddfs`sdfNicK", "QQEJagger"));

        System.out.println("Sort with name");
        users.sort(Comparator.comparing(User::getName));
        System.out.println(users);

        System.out.println("With ");
        users.sort(Comparator.comparing(User::getName).thenComparing(User::getSecondname));
        System.out.println(users);

        System.out.println("With ");
        users.sort(Comparator.comparing(User::getName).thenComparing(User::getSecondname).reversed());
        System.out.println(users);
    }
}

interface UserFactory {
    User createUser(String name, String secondname);
}

class User {
    private String name;
    private String secondname;

    public User(String name, String secondname) {
        this.name = name;
        this.secondname = secondname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", secondname='" + secondname + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
}

