package com.epam.homeworks.hw1;

@FunctionalInterface
public interface TriFunction <T,U,V,R> {
    R create (T t, U u, V v);
}
