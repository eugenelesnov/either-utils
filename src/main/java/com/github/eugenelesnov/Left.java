package com.github.eugenelesnov;

import java.util.Optional;

/**
 * @author Eugene Lesnov
 */
public class Left<L, R> extends Either<L, R> {

    protected L leftValue;

    public Left(L left) {
        this.leftValue = left;
    }

    @Override
    public Optional<L> getLeft() {
        return Optional.ofNullable(this.leftValue);
    }

    @Override
    public Optional<R> getRight() {
        return Optional.empty();
    }
}