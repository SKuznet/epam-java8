package com.epam.func.lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureEx5 {
    public static void main(String[] args) {
        CompletableFuture<CompletableFuture<Integer>> result = getUserDetails(5)
                .thenApply(CompletableFutureEx5::getCreditRaiting);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(result.get().get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        CompletableFuture<Integer> result2 = getUserDetails(5)
                .thenCompose(CompletableFutureEx5::getCreditRaiting);
        try {
            System.out.println(result2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    static CompletableFuture<User> getUserDetails(int userId) {
        return CompletableFuture.supplyAsync(()->UserService.getUserDetails(userId));
    }

    static CompletableFuture<Integer> getCreditRaiting(User user) {
        return CompletableFuture.supplyAsync(()->CreditRaitingService.getCreditRaiting(user));
    }

}

class UserService {
    static User getUserDetails(int id) {
        return new User(id);
    }
}


class CreditRaitingService {
    static Integer getCreditRaiting(User user) {
        CreditRating cr = new CreditRating(user.getId());
        return cr.getRaiting();
    }
}

class CreditRating {
    private int raiting;

    CreditRating(int i) {
        this.raiting = i;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}

class User {
    private String name;
    private int id;

    User(int id) {
        this.id = id;
        this.name = "jack " + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
