package racingcar;

public class CarName {
	private static final int MAX_LEN = 5;
	private final String name;

	public CarName(String name) {
		if (!isValidName(name)) {
			throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
		}
		this.name = name;
	}

	private boolean isValidName(String name) {
		return name.length() <= MAX_LEN;
	}

	@Override
	public String toString() {
		return name;
	}
}
