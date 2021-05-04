package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {
	private static final Scanner scanner = new Scanner(System.in);

	private static ArrayList<String> winners;
	private static Cars cars;
	private static int moveCount;

	public static void main(String[] args) {
		prepareRace();
		startRace();
	}

	private static void prepareRace() {
		do {
			System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분 / 2대 이상 입력)");
		} while (scanCarNames());
		do {
			System.out.println("시도할 횟수는 몇 회인가요? (숫자로 입력)");
		} while (scanMoveCount());
	}

	private static void startRace() {
		System.out.println("실행 결과");
		for (int i = 0; i < moveCount; i++) {
			cars.moveAllCars();
			printCurrentStatus();
		}
		printWinners();
	}

	private static void printWinners() {
		System.out.printf("%s가 최종 우승했습니다.%n", getWinnersString());
	}

	private static String getWinnersString() {
		int winnersPosition = getWinnersPosition();
		calculateWinners(winnersPosition);
		return String.join(", ", winners);
	}

	private static void calculateWinners(int winnersPosition) {
		winners = new ArrayList<String>();
		for (Car car : cars.getCars()) {
			addIfWinner(car, winnersPosition);
		}
	}

	private static void addIfWinner(Car car, int winnersPosition) {
		if (car.getPosition() == winnersPosition) {
			winners.add(car.getName());
		}
	}

	private static int getWinnersPosition() {
		int maxPosition = 0;
		for (Car car : cars.getCars()) {
			maxPosition = Math.max(car.getPosition(), maxPosition);
		}
		return maxPosition;
	}

	private static void printCurrentStatus() {
		StringBuilder builder = new StringBuilder();
		for (Car car : cars.getCars()) {
			builder.append(String.format("%s : %s%n", car.getName(), getPositionString(car)));
		}
		System.out.print(builder);
	}

	private static String getPositionString(Car car) {
		if (car.getPosition() == 0) {
			return "";
		}
		return new String(new char[car.getPosition()]).replace("\0", "-");
	}

	private static boolean scanCarNames() {
		String[] carNames = scanner.next().split(",");
		if (carNames.length < 2) {
			return false;
		}
		try {
			cars = new Cars(carNames);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	private static boolean scanMoveCount() {
		String input = scanner.next();
		try {
			moveCount = Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
