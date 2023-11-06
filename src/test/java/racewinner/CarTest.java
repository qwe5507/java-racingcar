package racewinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("자동차가 이동 할 때, 4~9 값이 나오면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void goTest(int number) {
        // given
        final Car car = new Car("popo", () -> number);

        // when
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("-");
    }

    @DisplayName("자동차가 이동 할 때, 0~3 값이 나오면 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopTest(int number) {
        // given
        final Car car = new Car("popo", () -> number);

        // when
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("");
    }
}