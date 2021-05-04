package racingcar;

import java.util.Scanner;

public class Race {
	private static final Scanner scanner = new Scanner(System.in);

	private Cars cars;
	private int moveCount;

	private boolean scanCarNames() {
		String[] carNames = scanner.next().split(",");
		try {
			cars = new Cars(carNames);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	private boolean scanMoveCount() {
		String input = scanner.next();
		try {
			moveCount = Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
