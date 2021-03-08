import com.github.eugenelesnov.Either;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Eugene Lesnov
 */
class EitherTest {

    @Nested
    class EitherLeft {

        private String leftValue;
        private String rightValue;
        private Either<String, String> either;

        @BeforeEach
        void setUp() {
            leftValue = "value";
            rightValue = null;

            either = Either.either(() -> leftValue, () -> rightValue);
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
}
