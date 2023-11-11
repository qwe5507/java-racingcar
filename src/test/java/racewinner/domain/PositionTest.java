package racewinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    void create() {
        final Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @DisplayName("position 객체는 음수를 가질 수 없다.")
    @Test
    void negativeNumber() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("더 큰 position이 입력되면 True를 반환한다.")
    @Test
    void isGreaterThanTest() {
        final Position position = new Position(5);
        final boolean result = position.isGreaterThan(new Position(2));
        assertThat(result).isTrue();
    }
}