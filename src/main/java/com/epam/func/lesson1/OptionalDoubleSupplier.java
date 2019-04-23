package com.epam.func.lesson1;

import java.util.Optional;

public class OptionalDoubleSupplier implements OptionalDoubleSupplierInterface, AutoCloseable {

    @Override
    public Optional<Double> get() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
    }
}
