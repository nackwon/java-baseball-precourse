package baseball;

import baseball.model.Baseball;
import baseball.model.BaseballValidation;
import baseball.model.baseballCommonUtil;
import baseball.view.BaseballInputView;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public void baseballGameStarter() {

    }

    /**
     * Computer Random Number Logic
     * @return
     */
    public List<Integer> computerUser() {
        Baseball baseball = new Baseball();

        String sComputerNumbers = baseball.computerRandomNumbers();
        if (BaseballValidation.isCheckCommonNumber(sComputerNumbers)) {
            return baseballCommonUtil.convertList(sComputerNumbers);
        }
        return null;
    }

    /**
     * User input Number Logic
     * @return
     */
    public List<Integer> inputUser() {
        String sInputNumber = BaseballInputView.userInputNumbers();

        if (BaseballValidation.isCheckCommonNumber(sInputNumber)) {
            return baseballCommonUtil.convertList(sInputNumber);
        }
        return null;
    }
}
