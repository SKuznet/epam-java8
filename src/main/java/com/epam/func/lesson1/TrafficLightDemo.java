package com.epam.func.lesson1;

import java.util.Optional;
import java.util.function.Supplier;

public class TrafficLightDemo {
    public static void main(String[] args) {

        Supplier<TrafficLight> trafficLightSupplier = TrafficLight::new;
        Supplier<OptionalDoubleSupplier> optionalDoubleSupplierSupplier = () -> new OptionalDoubleSupplier();

        Optional<Double> optionalDouble;
        final TrafficLight trafficLight = trafficLightSupplier.get();

        while (true) {
            try (OptionalDoubleSupplier optionalDoubleSupplier = optionalDoubleSupplierSupplier.get()) {
                optionalDouble = optionalDoubleSupplier.getOptionalDouble();
            }
            trafficLight.printColor(optionalDouble);
        }
    }
}
