package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRacing {
    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;
    private final int MIN_NUMBER_CAN_MOVE = 4;
    private final String MOVE_TRACE_FORMAT = "%s : ";
    private final String MOVE_TRACE_SYMBOL = "-";

    private final CarName name;
    private int moveCount;

    public CarRacing(CarName name) {
        this.name = name;
    }

    public void randomMoveOrStop() {
        int number = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER);
        if (number >= MIN_NUMBER_CAN_MOVE) {
            moveCount++;
        }
    }

    public String getMoveTraceWithFormat() {
        StringBuilder moveTrace =
                new StringBuilder(String.format(MOVE_TRACE_FORMAT, name.getCarName()));
        for (int i = 0; i < moveCount; i++) {
            moveTrace.append(MOVE_TRACE_SYMBOL);
        }
        return moveTrace.toString();
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getCarName() {
        return name.getCarName();
    }
}
