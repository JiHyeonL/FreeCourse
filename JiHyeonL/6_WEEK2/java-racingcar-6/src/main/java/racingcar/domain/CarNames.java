package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    private final List<CarName> names = new ArrayList<>();

    public CarNames(List<String> names) {
        for (String name : names) {
            this.names.add(new CarName(name));
        }
    }

    public int getTotalCarsCount() {
        return names.size();
    }

    public CarName getCarNameByIndex(int index) {
        return names.get(index);
    }
}
