package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarNames;
import racingcar.domain.CarRacing;
import racingcar.domain.TotalRacingInfo;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingController {
    private final String SPLIT_DELIMITER = ",";

    private CarNames validCarNames;
    private TryCount validTryCount;
    private TotalRacingInfo totalRacingInfo;
    private RacingService racingService;

    public void run() {
        String names = InputView.readCarsName();
        isNullOrBlank(names);
        validCarNames = new CarNames(parseToStringList(names));

        String tryCount = InputView.readTryCount();
        isNullOrBlank(tryCount);
        validTryCount = new TryCount(parseToInt(tryCount));

        OutputView.writeAnnounceRacingResult();
        racingService = new RacingService(validCarNames, validTryCount);

        totalRacingInfo = new TotalRacingInfo(racingService.racing());
        OutputView.writeFinalWinners(totalRacingInfo.getFinalWinnersWithFormat());
    }

    private void isNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }

    private List<String> parseToStringList(String names) {
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }

    private int parseToInt(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
