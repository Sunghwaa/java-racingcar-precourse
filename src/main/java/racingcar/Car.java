package racingcar;

public class Car {
	private final CarName name;

	public Car(String name) {
		this.name = new CarName(name);
	}

	public String getName() {
		return this.name.toString();
	}
}
