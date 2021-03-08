package com.github.eugenelesnov;

import java.util.Optional;

/**
 * @author Eugene Lesnov
 */
public class Right<L, R> extends Either<L, R> {

    protected R rightValue;

    public Right(R right) {
        this.rightValue = right;
    }

    @Override
    public Optional<R> getRight() {
        return Optional.ofNullable(rightValue);
    }

    @Override
    public Optional<L> getLeft() {
        return Optional.empty();
    }
}