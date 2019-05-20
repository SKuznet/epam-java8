package com.epam.func.lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureEx5 {
    public static void main(String[] args) {
        CompletableFuture<CompletableFuture<Integer>> result = getUserDetails(5)
                .thenApply(CompletableFutureEx5::getCreditRating);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CompletableFuture<Integer> result2 = getUserDetails(5)
                .thenCompose(CompletableFutureEx5::getCreditRating);
        try {
            System.out.println(result2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static CompletableFuture<User> getUserDetails(int userId) {
        return CompletableFuture.supplyAsync(() -> UserService.getUserDetails(userId));
    }

    static CompletableFuture<Integer> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() -> CreditRatingService.getCreditRating(user));
    }

}


class UserService {
    static User getUserDetails(int id) {
        return new User(id);
    }
}


class CreditRatingService {
    static Integer getCreditRating(User user) {
        CreditRating creditRating = new CreditRating(user.getId());
        return creditRating.getRating();
    }
}


class CreditRating {
    private int rating;

    public CreditRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}


class User {
    private String name;
    private int id;

    public User(int id) {
        this.name = "Jack " + id;
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }
}
