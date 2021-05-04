package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	void createRaceTest() {
		String[] carNames = new String[] {"pobi", "crong", "honux", "ondol"};
		assertDoesNotThrow(() -> new Cars(carNames));
	}

	@Test
	void createRaceWith_6LetterCarNameTest() {
		String[] carNames = new String[] {"pororo"};
		assertThatThrownBy(() -> new Cars(carNames)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
	}

	@Test
	void moveAllCarsTest() {
		String[] carNames = new String[] {"pobi", "crong", "honux", "ondol"};
		Cars cars = new Cars(carNames);
		cars.moveAllCars();

		ArrayList<Car> carsList = cars.getCars();
		for (Car car : carsList) {
			assertThat(car.getPosition()).isBetween(0, 1);
		}
	}
}
