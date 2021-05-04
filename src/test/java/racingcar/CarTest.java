package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void createCar() {
		assertThat(new Car("crong").getName()).isEqualTo("crong");
	}

	@Test
	void createCarWith_6letter() {
		assertThatThrownBy(() -> new Car("pororo")).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
	}
}
