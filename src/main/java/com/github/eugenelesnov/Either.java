package com.github.eugenelesnov;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Eugene Lesnov
 */
public abstract class Either<L, R> {

    public static <L, R> Either<L, R> either(Supplier<L> leftSupplier, Supplier<R> rightSupplier) {
        L leftValue = leftSupplier.get();
        if (leftValue != null) {
            return new Left<>(leftValue);
        } else {
            return new Right<>(rightSupplier.get());
        }
    }

    public abstract Optional<L> getLeft();

    public abstract Optional<R> getRight();
}