package baseball.view;

public class OutputView {
    private final static String START_GAME_ANNOUNCE = "숫자 야구 게임을 시작합니다.";
    private final static String CORRECT_ANNOUNCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void writeStartGame() {
        System.out.println(START_GAME_ANNOUNCE);
    }

    public static void writeEndGame() {
        System.out.println(CORRECT_ANNOUNCE);
    }

    public static void writeHint(String hint) {
        System.out.println(hint);
    }
}
