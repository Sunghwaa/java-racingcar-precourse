package racingcar;

import java.util.Random;

public class CarPosition {
	private int position;

	public CarPosition() {
		this.position = 0;
	}

	public int getCurrentPosition() {
		return position;
	}

	public void move() {
		if (isGO()) {
			position += 1;
		}
	}

	private boolean isGO() {
		final int bound = 10;
		final int goCondition = 4;
		return new Random().nextInt(bound) >= goCondition;
	}
}
