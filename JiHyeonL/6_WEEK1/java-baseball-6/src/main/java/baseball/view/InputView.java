package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String REQUEST_NUMBERS = "숫자를 입력해주세요 : ";
    private final static String REQUEST_END_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String readNumbers() {
        System.out.print(REQUEST_NUMBERS);
        return Console.readLine();
    }

    public static String readEndStatus() {
        System.out.println(REQUEST_END_NUMBER);
        return Console.readLine();
    }
}
