package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final String BALL = "%d볼";
    private final String STRIKE = "%d스트라이크";
    private final String NOTHING = "낫싱";
    private final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private final int NUMBERS_LENGTH = 3;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;

    private final List<Integer> numbers;
    private List<Integer> answerNumbers;

    public Numbers(String rawNumbers, List<Integer> answerNumbers) {
        checkIsNullOrBlank(rawNumbers);

        List<Integer> splitNumbers = parseToIntList(rawNumbers);

        checkIsThree(splitNumbers);
        checkNumberInRange(splitNumbers);
        checkIsDuplicate(splitNumbers);

        this.numbers = splitNumbers;
        this.answerNumbers = answerNumbers;
    }

    public static List<Integer> makeRandomAnswerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public String makeHint() {
        if (isNothing())
            return NOTHING;
        List<Integer> ballAndStrike = calculateBallAndStrikeCount();
        if (ballAndStrike.get(0) == 0) {    // 볼 없음
            return String.format(STRIKE, ballAndStrike.get(1));
        }
        if (ballAndStrike.get(1) == 0) {    // 스트라이크 없음
            return String.format(BALL, ballAndStrike.get(0));
        }

        return String.format(BALL, ballAndStrike.get(0)) + " " + String.format(STRIKE, ballAndStrike.get(1));
    }

    private boolean isNothing() {
        Set<Integer> noDuplicate = new HashSet<>(numbers);
        noDuplicate.addAll(answerNumbers);
        if (noDuplicate.size() == NUMBERS_LENGTH * 2) {
            return true;
        }
        return false;
    }

    private List<Integer> calculateBallAndStrikeCount() {
        int ballCount = 0;
        int StrikeCount = 0;

        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            if (numbers.get(i) == answerNumbers.get(i)) {
                StrikeCount++;
                continue;
            }
            if (answerNumbers.contains(numbers.get(i))) {
                ballCount++;
            }
        }
        return List.of(ballCount, StrikeCount);
    }


    private void checkIsNullOrBlank(String rawNumbers) {
        if (rawNumbers == null || rawNumbers.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void checkIsThree(List<Integer> splitNumbers) {
        if (splitNumbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void checkNumberInRange(List<Integer> splitNumbers) {
        for (int number : splitNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
    }

    private void checkIsDuplicate(List<Integer> splitNumbers) {
        Set<Integer> noDuplicate = new HashSet<>(splitNumbers);
        if (noDuplicate.size() != splitNumbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private List<Integer> parseToIntList(String rawNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < rawNumbers.length(); i++) {
            try {
                int number = Integer.parseInt(Character.toString(rawNumbers.charAt(i)));
                numbers.add(number);
            } catch (NumberFormatException | NullPointerException e) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
        return numbers;
    }
}
