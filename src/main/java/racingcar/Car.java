package racingcar;

public class Car {
	private final CarName name;
	private final CarPosition position;

	public Car(String name) {
		this.name = new CarName(name);
		this.position = new CarPosition();
	}

	public String getName() {
		return this.name.toString();
	}

	public int getPosition() {
		return position.getCurrentPosition();
	}

	public void move() {
		position.move();
	}
}
