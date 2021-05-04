package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class RaceTest {
	@Test
	void createRaceTest() {
		String[] carNames = new String[] {"pobi", "crong", "honux", "ondol"};
		assertDoesNotThrow(() -> new Race(carNames));
	}

	@Test
	void createRaceWith_6LetterCarNameTest() {
		String[] carNames = new String[] {"pororo"};
		assertThatThrownBy(() -> new Race(carNames)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
	}

	@Test
	void moveAllCarsTest() {
		String[] carNames = new String[] {"pobi", "crong", "honux", "ondol"};
		Race race = new Race(carNames);
		race.moveAllCars();

		ArrayList<Car> cars = race.getCars();
		for (Car car : cars) {
			assertThat(car.getPosition()).isBetween(0, 1);
		}
	}
}
