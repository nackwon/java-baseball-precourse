package baseball;

import baseball.model.Baseball;
import baseball.model.BaseballStrikeAndBallCount;
import baseball.model.BaseballValidation;
import baseball.model.baseballCommonUtil;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램

        List<Integer> computerNumberList = computerUser();

        baseballGameStarter(computerNumberList);
    }

    public static void baseballGameStarter(List<Integer> computerNumberList) {

        Application application = new Application();
        List<Integer> inputUserNumberList = application.inputUser();

        Map mpBallCount = application.baseballGameRule(inputUserNumberList, computerNumberList);

        int strikeCount = (int) mpBallCount.get("strike");
        int ballCount = (int) mpBallCount.get("ball");

        if (0 != strikeCount && 0 != ballCount) {
            BaseballOutputView.resultStrikeAndBallCount((int) mpBallCount.get("strike"), (int) mpBallCount.get("ball"));
            baseballGameStarter(computerNumberList);
        }
        if ( 0 == strikeCount && 0 == ballCount) {
            BaseballOutputView.nothingMSG();
            baseballGameStarter(computerNumberList);
        }
        if (3 == strikeCount) {
            BaseballOutputView.winningMSG();
            application.gameRestart();
        }
    }

    public Map baseballGameRule(List<Integer> inputUserNumberList, List<Integer> computerUserNumberList) {

        BaseballStrikeAndBallCount strikeAndBallCount = new BaseballStrikeAndBallCount();

        return strikeAndBallCount.countBallCount(inputUserNumberList, computerUserNumberList);
    }

    public void gameRestart() {

        // 재시작
        String sRestartCode = BaseballInputView.restartGame();

        if ("1".equals(sRestartCode)) {
            BaseballInputView.userInputNumbers();
        }
        if("2".equals(sRestartCode)) {
            return;
        }
    }

    /**
     * Computer Random Number Logic
     * @return
     */
    public static List<Integer> computerUser() {
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
