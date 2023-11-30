package racingcar.domain;

public class CarName {
    private final int MIN_NAME_LENGTH = 1;
    private final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    private void validate(String name) {
        checkNameInRange(name);
    }

    private void checkNameInRange(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이가 범위에 벗어납니다.");
        }
    }
}
