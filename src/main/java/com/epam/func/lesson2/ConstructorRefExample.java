package com.epam.func.lesson2;

import javax.jws.soap.SOAPBinding;

public class ConstructorRefExample {
    public static void main(String[] args) {
        UserFactory factory = User::new;
        User user = factory.createUser("a","b");
        System.out.println(user);
    }
}

@FunctionalInterface
interface UserFactory {
    User createUser (String name, String secondName);
}

class User {
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