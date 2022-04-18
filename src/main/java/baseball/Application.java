package baseball;

import baseball.model.Baseball;
import baseball.model.BaseballStrikeAndBallCount;
import baseball.model.BaseballValidation;
import baseball.model.baseballCommonUtil;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

import java.util.List;

public class Application {

    private static final String ERROR_MSG = "입력 오류";

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

        BaseballStrikeAndBallCount strikeAndBallCount = new BaseballStrikeAndBallCount();

        int intStrikeCount = strikeAndBallCount.countStrike(inputUserNumberList, computerNumberList);
        int intBallCount = strikeAndBallCount.countBall(inputUserNumberList, computerNumberList);

        if(baseballGameRule(intStrikeCount, intBallCount)) {
            baseballGameStarter(computerNumberList);
        }
    }

    /**
     * 
     * @param intStrikeCount : 스트라이크 갯수
     * @param intBallCount : 볼의 갯수
     * @return
     */
    public static boolean baseballGameRule(int intStrikeCount, int intBallCount) {

        if(intStrikeCount == 3) {
            BaseballOutputView.resultStrikeAndBallCount(intStrikeCount, intBallCount - intStrikeCount);
            BaseballOutputView.winningMSG();
            return false;
        }
        if(0 == intStrikeCount && 0 == intBallCount) {
            BaseballOutputView.nothingMSG();
            return true;
        }
        if(0 != intStrikeCount || 0 != intBallCount) {
            BaseballOutputView.resultStrikeAndBallCount(intStrikeCount, intBallCount - intStrikeCount);
            return true;
        }
        return false;
    }

    /**
     * Game Restart Method
     * @return
     */
    public static boolean gameRestart() {

        final int NEW_GAME_CODE = 1;
        final int QUIT_CODE = 2;

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
        if (!BaseballValidation.isCheckCommonNumber(sComputerNumbers)) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return baseballCommonUtil.convertList(sComputerNumbers);
    }

    /**
     * User input Number Logic
     * @return
     */
    public List<Integer> inputUser() {
        String sInputNumber = BaseballInputView.userInputNumbers();

        if (!BaseballValidation.isCheckCommonNumber(sInputNumber)) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return baseballCommonUtil.convertList(sInputNumber);
    }
}
