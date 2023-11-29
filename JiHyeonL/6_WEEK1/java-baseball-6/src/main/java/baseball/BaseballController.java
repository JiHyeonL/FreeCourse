package baseball;

import baseball.domain.EndStatus;
import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private final String GAME_END_RESULT = "3스트라이크";
    private Numbers validNumbers;
    private EndStatus validEndStatus;
    public void run() {
        OutputView.writeStartGame();
        do {
            oneGamePlaying(Numbers.makeRandomAnswerNumbers());
        } while (validEndStatus.canGaming());

    }

    public void oneGamePlaying(List<Integer> answerNumbers) {
        while (true) {
            String numbers = InputView.readNumbers();
            validNumbers = new Numbers(numbers, answerNumbers);

            String hint = validNumbers.makeHint();
            OutputView.writeHint(hint);

            if (hint.equals(GAME_END_RESULT)) {
                OutputView.writeEndGame();
                String endStatus = InputView.readEndStatus();
                validEndStatus = new EndStatus(endStatus);
                break;
            }
        }
    }
}
