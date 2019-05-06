package com.epam.func.lesson2;

interface UserFactory {
    User createUser(String name, String secondName);
}

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        UserFactory factory = User::new;
        User user1 = factory.createUser("Barsik", "AngryCat");
        User user2 = factory.createUser("Murzik", "AngryCat");
        User user3 = factory.createUser("Snezhok", "AngryCat");
        System.out.println(user1);
    }

}

class User {
    private String name;
    private String secondName;

    public User(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
