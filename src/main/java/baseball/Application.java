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

        do {
            List<Integer> computerNumberList = computerUser();
            baseballGameStarter(computerNumberList);
        } while (gameRestart());
    }

    public static void baseballGameStarter(List<Integer> computerNumberList) {

        Application application = new Application();
        List<Integer> inputUserNumberList = application.inputUser();

        Map mpBallCount = application.baseballGameRule(inputUserNumberList, computerNumberList);

        int strikeCount = (int) mpBallCount.get("strike");
        int ballCount = (int) mpBallCount.get("ball");

        if ( 0 == strikeCount && 0 == ballCount) {
            BaseballOutputView.nothingMSG();
            baseballGameStarter(computerNumberList);
            return;
        }

        if (3 == strikeCount) {
            BaseballOutputView.resultStrikeAndBallCount(strikeCount, ballCount);
            BaseballOutputView.winningMSG();
            return;
        }

        if( 0 != strikeCount || 0 != ballCount) {
            BaseballOutputView.resultStrikeAndBallCount(strikeCount, ballCount);
            baseballGameStarter(computerNumberList);
            return;
        }
    }

    public Map baseballGameRule(List<Integer> inputUserNumberList, List<Integer> computerUserNumberList) {
        BaseballStrikeAndBallCount strikeAndBallCount = new BaseballStrikeAndBallCount();
        return strikeAndBallCount.countBallCount(inputUserNumberList, computerUserNumberList);
    }

    public static boolean gameRestart() {

        final int NEW_GAME_CODE = 1;
        final int QUIT_CODE = 2;
        final String ERROR_MSG = "잘못된 입력입니다.";

        String sRestartCode = BaseballInputView.restartGame();

        if (Integer.parseInt(sRestartCode) != NEW_GAME_CODE && Integer.parseInt(sRestartCode) != QUIT_CODE) {
            throw new IllegalArgumentException(ERROR_MSG);
        }

        return Integer.parseInt(sRestartCode) == NEW_GAME_CODE;
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
