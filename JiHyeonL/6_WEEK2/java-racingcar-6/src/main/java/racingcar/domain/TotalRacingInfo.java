package racingcar.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TotalRacingInfo {
    private final String FINAL_WINNER_FORMAT = "최종 우승자 : %s";
    private final String FINAL_WINNER_DELIMITER= ", ";

    private final List<CarRacing> totalRacing;

    public TotalRacingInfo(List<CarRacing> totalRacing) {
        this.totalRacing = totalRacing;
    }

    public String getFinalWinnersWithFormat() {
        List<String> result = new ArrayList();
        List<CarRacing> sortTotalRacing = new ArrayList<>(totalRacing);
        Collections.sort(sortTotalRacing, (o1, o2) -> o2.getMoveCount() - o1.getMoveCount());

        int max = sortTotalRacing.get(0).getMoveCount();
        for (int i = 0; i < sortTotalRacing.size(); i++) {
            if (sortTotalRacing.get(i).getMoveCount() != max) {
                break;
            }
            result.add(sortTotalRacing.get(i).getCarName());
        }

        return String.format(FINAL_WINNER_FORMAT, String.join(FINAL_WINNER_DELIMITER, result));
    }
}
