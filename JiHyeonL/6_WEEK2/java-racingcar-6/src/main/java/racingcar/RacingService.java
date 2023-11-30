package racingcar;

import racingcar.domain.CarNames;
import racingcar.domain.CarRacing;
import racingcar.domain.TryCount;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    private List<CarRacing> allCarRacing = new ArrayList<>();

    private CarNames validCarNames;
    private TryCount validTryCount;

    public RacingService(CarNames validCarNames, TryCount validTryCount) {
        this.validCarNames = validCarNames;
        this.validTryCount = validTryCount;
    }

    public List<CarRacing> racing() {
        setCarRacingList();

        for (int i = 0; i < validTryCount.getTryCount(); i++) {
            OutputView.writeRacingResult(racingOneCycleForAllCars());
        }

        return allCarRacing;
    }

    private void setCarRacingList() {
        for (int i = 0 ; i < validCarNames.getTotalCarsCount(); i++) {
            allCarRacing.add(new CarRacing(validCarNames.getCarNameByIndex(i)));
        }
    }

    private String racingOneCycleForAllCars() {
        StringBuilder racingOneCycle = new StringBuilder();

        for (int j = 0 ; j < validCarNames.getTotalCarsCount(); j++) {
            allCarRacing.get(j).randomMoveOrStop();
            racingOneCycle.append(allCarRacing.get(j).getMoveTraceWithFormat())
                    .append(OutputView.NEW_LINE);
        }
        return racingOneCycle.toString();
    }

}
