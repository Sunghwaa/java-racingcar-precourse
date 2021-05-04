package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {
	private static final Scanner scanner = new Scanner(System.in);

	private ArrayList<String> winners;
	private Cars cars;
	private int moveCount;

	private void startRace() {
		System.out.println("실행 결과");
		for (int i = 0; i < moveCount; i++) {
			cars.moveAllCars();
			printCurrentStatus();
		}
		printWinners();
	}

	private void printWinners() {
		System.out.printf("%s가 최종 우승했습니다.%n", getWinnersString());
	}

	private String getWinnersString() {
		int winnersPosition = getWinnersPosition();
		calculateWinners(winnersPosition);
		return String.join(", ", winners);
	}

	private void calculateWinners(int winnersPosition) {
		winners = new ArrayList<String>();
		for (Car car : cars.getCars()) {
			addIfWinner(car, winnersPosition);
		}
	}

	private void addIfWinner(Car car, int winnersPosition) {
		if (car.getPosition() == winnersPosition) {
			winners.add(car.getName());
		}
	}

	private int getWinnersPosition() {
		int maxPosition = 0;
		for (Car car : cars.getCars()) {
			maxPosition = Math.max(car.getPosition(), maxPosition);
		}
		return maxPosition;
	}

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
