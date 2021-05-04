package racingcar;

import java.util.Scanner;

public class Race {
	private static final Scanner scanner = new Scanner(System.in);

	private Cars cars;
	private int moveCount;

	private void printCurrentStatus() {
		StringBuilder builder = new StringBuilder();
		for (Car car : cars.getCars()) {
			builder.append(String.format("%s : %s%n", car.getName(), getPositionString(car)));
		}
		System.out.print(builder);
	}

	private String getPositionString(Car car) {
		if (car.getPosition() == 0) {
			return "";
		}
		return new String(new char[car.getPosition()]).replace("\0", "-");
	}

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
