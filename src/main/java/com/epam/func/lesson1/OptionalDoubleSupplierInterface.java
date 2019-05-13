package com.epam.func.lesson1;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

@FunctionalInterface
public interface OptionalDoubleSupplierInterface extends Supplier<Optional<Double>> {

    default Optional<Double> getOptionalDouble() {
        final Scanner scanner = new Scanner(System.in);
        final double value = scanner.nextDouble();
        return value > 0 ? Optional.of(value) : Optional.empty();
    }
}