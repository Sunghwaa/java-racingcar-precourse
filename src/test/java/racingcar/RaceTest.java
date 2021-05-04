package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RaceTest {
	@Test
	void createRaceTest() {
		String[] carNames = new String[] {"pobi", "crong", "honux", "ondol"};
		assertDoesNotThrow(() -> new Race(carNames));
	}

	@Test
	void createRaceWith_6LetterCarNameTest() {
		String[] carName = new String[] {"pororo"};
		assertThatThrownBy(() -> new Race(carName)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
	}
}
