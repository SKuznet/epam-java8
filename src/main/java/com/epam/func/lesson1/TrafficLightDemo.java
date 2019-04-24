package com.epam.func.lesson1;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class TrafficLightDemo {
    public static void main(String[] args) {

        Function<Optional<Double>, TrafficLight> trafficLightFunction = TrafficLight::new;
        Supplier<OptionalDoubleSupplier> optionalDoubleSupplierSupplier = () -> new OptionalDoubleSupplier();

        final ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Optional<Double> optionalDouble;
            try (OptionalDoubleSupplier optionalDoubleSupplier = optionalDoubleSupplierSupplier.get()) {
                optionalDouble = optionalDoubleSupplier.getOptionalDouble();
            }

            executorService.execute(trafficLightFunction.apply(optionalDouble));
        }
    }
}
