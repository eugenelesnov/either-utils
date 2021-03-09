package com.github.eugenelesnov;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Eugene Lesnov
 */
public abstract class Either<L, R> {

    /**
     * Left handed implementation of `Either`
     *
     * @param leftSupplier  - supplier for left value
     * @param rightSupplier - supplier for right value
     * @return {@link Left} or {@link Right} implementation
     */
    public static <L, R> Either<L, R> either(Supplier<L> leftSupplier, Supplier<R> rightSupplier) {
        L leftValue = leftSupplier.get();
        if (leftValue != null) {
            return new Left<>(leftValue);
        } else {
            return new Right<>(rightSupplier.get());
        }
    }

    /**
     * Getter with optional for left value
     *
     * @return optional of left value
     */
    public abstract Optional<L> getLeft();

    /**
     * Getter with optional for right value
     *
     * @return optional of right value
     */
    public abstract Optional<R> getRight();
}