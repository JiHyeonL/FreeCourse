package racingcar.view;

public class OutputView {
    public static final String NEW_LINE = "\n";

    public static void writeAnnounceRacingResult() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public static void writeRacingResult(String racingOneCycle) {
        System.out.println(racingOneCycle);
    }

    public static void writeFinalWinners(String finalWinners) {
        System.out.println(finalWinners);
    }

}
