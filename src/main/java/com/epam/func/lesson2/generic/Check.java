package com.epam.func.lesson2.generic;

@FunctionalInterface
public interface Check<T> {
    T get(Cat cat);
}
