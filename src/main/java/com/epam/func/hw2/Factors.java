package com.epam.func.hw2;

public class Factors {

    public static String getFactorizationOfRandomNumber() {
        long n = (long) (Math.random() * 1000000000);
        StringBuilder stringBuilder = new StringBuilder("The prime factorization of ")
                .append(n)
                .append(" is:");

        for (long factor = 2; factor*factor <= n; factor++) {
            while (n % factor == 0) {
                stringBuilder.append(" ").append(factor);
                n = n / factor;
            }
        }
        if (n > 1) {
            stringBuilder.append(" ").append(n);
        }

        return stringBuilder.toString();
    }
}
