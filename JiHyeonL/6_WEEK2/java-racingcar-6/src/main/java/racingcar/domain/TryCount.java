package racingcar.domain;

public class TryCount {
    private final int MIN_TRY_COUNT = 1;
    private final int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validate(int tryCount) {
        checkTryCountInRange(tryCount);
    }

    private void checkTryCountInRange(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 회수를 1 이상으로 입력해 주세요.");
        }
    }
}
