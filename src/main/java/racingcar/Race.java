package racingcar;

import java.util.ArrayList;

public class Race {
	private final ArrayList<Car> cars = new ArrayList<Car>();

	public Race(String[] carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void moveAllCars() {
		for (Car car : cars) {
			car.move();
		}
	}

	public ArrayList<Car> getCars() {
		return cars;
	}
}
