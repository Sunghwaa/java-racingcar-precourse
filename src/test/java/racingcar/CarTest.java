package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void createCarTest() {
		assertThat(new Car("crong").getName()).isEqualTo("crong");
	}

	@Test
	void createCarWith_6letterTest() {
		assertThatThrownBy(() -> new Car("pororo")).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
	}

	@Test
	void getPositionTest() {
		assertThat(new Car("crong").getPosition()).isEqualTo(0);
	}

	@Test
	void moveTest() {
		Car car = new Car("crong");
		car.move();
		assertThat(car.getPosition()).isBetween(0, 1);
	}
}
