package com.github.eugenelesnov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Eugene Lesnov
 */
class EitherTest {

    private String leftValue;
    private String rightValue;
    private Either<String, String> either;

    @Nested
    class EitherLeft {

        @BeforeEach
        void setUp() {
            leftValue = "value";

            either = Either.either(() -> leftValue, () -> null);
        }

        @Test
        void shouldReturnLeftImplementation() {
            assertThat(either).isInstanceOf(Left.class);
        }

        @Test
        void leftValueShouldExist() {
            assertThat(either.getLeft().isPresent()).isTrue();
        }

        @Test
        void rightValueShouldBeEmpty() {
            assertThat(either.getRight().isEmpty()).isTrue();
        }

        @Test
        void leftValueShouldBeEqualsToExpected() {
            String actualLeftValue = either.getLeft().get();

            assertThat(actualLeftValue).isEqualTo(leftValue);
        }
    }

    @Nested
    class EitherRight {

        @BeforeEach
        void setUp() {
            rightValue = "value";

            either = Either.either(() -> null, () -> rightValue);
        }

        @Test
        void shouldReturnRightImplementation() {
            assertThat(either).isInstanceOf(Right.class);
        }

        @Test
        void rightValueShouldExist() {
            assertThat(either.getRight().isPresent()).isTrue();
        }

        @Test
        void leftValueShouldBeEmpty() {
            assertThat(either.getLeft().isEmpty()).isTrue();
        }

        @Test
        void rightValueShouldBeEqualsToExpected() {
            String actualRightValue = either.getRight().get();

            assertThat(actualRightValue).isEqualTo(rightValue);
        }
    }
}
