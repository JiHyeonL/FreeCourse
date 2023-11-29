package baseball.domain;

public class EndStatus {
    private static final String RESTART = "1";
    private static final String END = "2";
    private final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private final String endStatus;

    public EndStatus(String endStatus) {
        checkIsNullOrBlank(endStatus);
        checkInRange(endStatus);

        this.endStatus = endStatus;
    }

    public boolean canGaming() {
        if (endStatus.equals(RESTART)) {
            return true;
        }
        return false;
    }

    private void checkIsNullOrBlank(String endStatus) {
        if (endStatus == null || endStatus.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void checkInRange(String endStatus) {
        if (!(endStatus.equals(RESTART) || endStatus.equals(END))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
