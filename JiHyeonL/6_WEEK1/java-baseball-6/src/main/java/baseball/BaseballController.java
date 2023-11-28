package baseball;

import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private Numbers validNumbers;
    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        validNumbers = new Numbers(numbers);



    }
}
