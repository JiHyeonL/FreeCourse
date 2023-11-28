package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private final int NUMBERS_LENGTH = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    private final List<Integer> numbers;

    public Numbers(String rawNumbers) {
        checkIsNullOrBlank(rawNumbers);

        List<Integer> splitNumbers = parseToIntList(rawNumbers);

        checkIsThree(splitNumbers);
        checkNumberInRange(splitNumbers);
        checkIsDuplicate(splitNumbers);

        this.numbers = splitNumbers;
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
            if (number < MAX_NUMBER || number > MAX_NUMBER) {
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
