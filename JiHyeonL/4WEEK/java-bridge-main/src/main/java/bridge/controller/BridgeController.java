package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;
    public void start() {
        inputView.readBridgeSize();
    }
}
