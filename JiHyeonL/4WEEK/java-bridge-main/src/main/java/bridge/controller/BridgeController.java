package bridge.controller;

import bridge.util.PrintMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private InputView inputView;
    private PrintMessage printMessage;
    private OutputView outputView;
    private int length;
    private int direction;
    public void start() {
        // 시작 메세지
        printMessage.startGame();
        // 다리 길이 입력 받기
        inputView.readBridgeSize();
        // 이동할 칸 선택
        inputView.readMoving();
        //

    }
}
